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

import de.kaiserpfalzedv.umame.BaseUmameRuntimeException;
import de.kaiserpfalzedv.umame.uma.AuthorizationServer;

import javax.ws.rs.core.Response;

/**
 * If the resource server is unable to provide a permission ticket from the
 * authorization server, then it includes a header of the following form in its
 * response to the client: Warning: 199 - "UMA Authorization Server
 * Unreachable".
 *
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
public class UmameRequestDeniedException extends BaseUmameRuntimeException {
    private static final Response.Status STATUS = Response.Status.FORBIDDEN;

    private AuthorizationServer as;

    public UmameRequestDeniedException(AuthorizationServer as) {
        super("{\n  \"error\": \"request_denied\"\n}");

        this.as = as;
    }

    public Response.Status getStatus() {
        return STATUS;
    }

    public AuthorizationServer getAS() { return as; }
}
