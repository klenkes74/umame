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

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This is a JAX-RS exception mapper for the {@link UmameAuthorizationServerUnreachableExceptionMapper}
 *
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
@Provider
public class UmameAuthorizationServerUnreachableExceptionMapper
        implements ExceptionMapper<UmameAuthorizationServerUnreachableException> {
    @Override
    public Response toResponse(final UmameAuthorizationServerUnreachableException e) {
        return Response
                .status(e.getStatus())

                .type(MediaType.APPLICATION_JSON_TYPE)
                .cacheControl(CacheControl.valueOf("no-store"))
                .header("Warning", e.getMessage())

                .build();
    }
}
