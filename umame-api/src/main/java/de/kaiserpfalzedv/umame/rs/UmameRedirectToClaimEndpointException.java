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
import de.kaiserpfalzedv.umame.uma.PermissionTicket;

import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Redirects the requesting party to the claim endpoint of the authorization server.
 *
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
public class UmameRedirectToClaimEndpointException extends BaseUmameRuntimeException {
    private static final Response.Status STATUS = Response.Status.FORBIDDEN;

    private AuthorizationServer as;
    private PermissionTicket prt;
    private URI redirectionTarget;

    public UmameRedirectToClaimEndpointException(
            final AuthorizationServer as,
            final PermissionTicket prt,
            final URI redirectionTarget
    ) {
        super("{\n  \"error\": \"need_info\",\n  \"ticket\": \"" + prt.getTicket() + "\",\n  \"redirect_user\": \""
                      + redirectionTarget.toASCIIString() + "\"\n}");

        this.as = as;
        this.prt = prt;
        this.redirectionTarget = redirectionTarget;
    }

    public Response.Status getStatus() {
        return STATUS;
    }

    public AuthorizationServer getAS() {
        return as;
    }

    public PermissionTicket getPRT() {
        return prt;
    }

    public URI getRedirectionTarget() {
        return redirectionTarget;
    }
}
