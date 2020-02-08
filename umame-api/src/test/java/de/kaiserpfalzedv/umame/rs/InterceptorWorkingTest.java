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

import org.junit.jupiter.api.Test;

import javax.interceptor.InvocationContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
public class InterceptorWorkingTest {
    @Test
    public void shouldRunWithoutException() throws Exception {
        UserManagedAuthorizationInterceptor service = new UserManagedAuthorizationInterceptor();

        service.protect(new InvocationContext() {
            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Object getTimer() {
                return null;
            }

            @Override
            public Method getMethod() {
                return null;
            }

            @Override
            public Constructor<?> getConstructor() {
                return null;
            }

            @Override
            public Object[] getParameters() {
                return new Object[0];
            }

            @Override
            public void setParameters(Object[] objects) {

            }

            @Override
            public Map<String, Object> getContextData() {
                return null;
            }

            @Override
            public Object proceed() {
                return null;
            }
        });
    }
}
