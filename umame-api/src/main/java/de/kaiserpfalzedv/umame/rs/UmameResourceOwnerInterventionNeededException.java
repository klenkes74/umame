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
import java.util.Optional;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
public class UmameResourceOwnerInterventionNeededException extends BaseUmameRuntimeException {
    private static final Response.Status STATUS = Response.Status.FORBIDDEN;
    /**
     * The permissin ticket returned by the Authorization Server for this
     * resource.
     */
    private AuthorizationServer as;
    private PermissionTicket prt;
    private Long interval = null;

    public UmameResourceOwnerInterventionNeededException(
            final AuthorizationServer as,
            final PermissionTicket prt
    ) {
        super("{\n  \"error\":\"request_submitted\",\n  \"ticket\":\"" + prt.getTicket() + "\"\n}");

        this.as = as;
        this.prt = prt;
    }

    public UmameResourceOwnerInterventionNeededException(
            final AuthorizationServer as,
            final PermissionTicket prt,
            final Long interval
    ) {
        super("{\n  \"error\":\"request_submitted\",\n  \"ticket\":\"" + prt.getTicket() + "\",\n  \"interval\": " + interval + "\n}");

        this.as = as;
        this.prt = prt;
        this.interval = interval;
    }

    public Response.Status getStatus() {
        return STATUS;
    }

    public AuthorizationServer getAS() { return as; }

    public PermissionTicket getPRT() {
        return prt;
    }

    public Optional<Long> getInterval() {
        return Optional.ofNullable(interval);
    }
}
