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

package de.kaiserpfalzedv.umame.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
@UserManagedAuthorizationResource
@Interceptor
public class UserManagedAuthorizationInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(UserManagedAuthorizationInterceptor.class);

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
    public Object protect(InvocationContext context) throws Exception {
        return context.proceed();
    }
}
