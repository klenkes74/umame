/*
 * Copyright (c) 2020 Kaiserpfalz EDV-Service, Roland T. Lichti
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.kaiserpfalzedv.umame.keycloak;

import de.kaiserpfalzedv.umame.UmameWrappedException;
import de.kaiserpfalzedv.umame.rs.UMAResource;
import de.kaiserpfalzedv.umame.rs.UmameRequestDeniedException;
import de.kaiserpfalzedv.umame.rs.UserManagedAuthorizationResource;
import de.kaiserpfalzedv.umame.uma.AuthorizationServer;
import io.quarkus.arc.AlternativePriority;
import io.quarkus.security.identity.SecurityIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.security.auth.AuthPermission;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * a * @since 1.0.0 2020-02-09
 */
@Interceptor
@Alternative
@AlternativePriority(Interceptor.Priority.LIBRARY_AFTER)
@Priority(Interceptor.Priority.LIBRARY_AFTER)
@UserManagedAuthorizationResource
public class UserManagedAuthorizationInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(UserManagedAuthorizationInterceptor.class);

    @Inject
    SecurityIdentity identity;

    @Inject
    AuthorizationServer as;


    public UserManagedAuthorizationInterceptor() {}

    public UserManagedAuthorizationInterceptor(
            final SecurityIdentity identity,
            final AuthorizationServer as
    ) {
        this.identity = identity;
        this.as = as;
    }


    /**
     * This method handles the UMA flow. If the result type of the intercepted method is Response, the needed HTTP
     * responses are generated directly, otherwise matching exceptions are thrown which will be handled via the matching
     * JAX-RS exception mappers.
     *
     * @param context the information about the called JAX-RS resource.
     * @return The result of the intercepted method call.
     * @throws Exception of the called method.
     */
    @AroundInvoke
    public Object protect(final InvocationContext context) throws Exception {
        String resourceName = getResourceNameFromContext(context);
        String user = identity.getPrincipal().getName();
        MDC.put("principal", user);
        MDC.put("resource", resourceName);

        identity.checkPermission(new AuthPermission(resourceName))
                .thenCompose(granted -> {
                    if (granted) {
                        return CompletableFuture.completedFuture(execute(context));
                    }

                    LOG.warn("Access not granted");
                    throw new UmameRequestDeniedException(as);
                });

        throw new UmameRequestDeniedException(as);
    }


    private String getResourceNameFromContext(final InvocationContext context) {
        Object[] parameterValues = context.getParameters();

        Method method = context.getMethod();
        Annotation[][] annotations = method.getParameterAnnotations();

        for (int i = 0; i < annotations.length; i++) {
            for (Annotation annotation : annotations[i]) {
                if (annotation instanceof UMAResource) {
                    return parameterValues[i].toString();
                }
            }
        }

        // Fallback: take the first parameter of the method.
        return parameterValues[0].toString();
    }

    private Object execute(final InvocationContext context) {
        try {
            return context.proceed();
        } catch (Exception e) {
            throw new UmameWrappedException(e);
        }
    }
}