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

package de.kaiserpfalzedv.umame.uma;

import de.kaiserpfalzedv.umame.BaseUmameRuntimeException;

import javax.ws.rs.core.Response;

/**
 * This exception marks the need for a permission. The caller needs to request
 * the permission at the Authorization Server and return the token to access
 * the resource.
 *
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
public class UmamePermissionNeededException extends BaseUmameRuntimeException {
    private static final Response.Status STATUS = Response.Status.UNAUTHORIZED;
    /**
     * The permissin ticket returned by the Authorization Server for this
     * resource.
     */
    private AuthorizationServer as;
    private PermissionTicket prt;

    public UmamePermissionNeededException(final AuthorizationServer as, final PermissionTicket prt) {
        super("Permission needed.");

        this.as = as;
        this.prt = prt;
    }

    public Response.Status getStatus() {
        return STATUS;
    }

    public AuthorizationServer getAS() { return as; }

    public PermissionTicket getPRT() {
        return prt;
    }
}
