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

import de.kaiserpfalzedv.umame.uma.UmamePermissionNeededException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.ws.rs.core.Response;

import static de.kaiserpfalzedv.umame.rs.TestObjects.AS;
import static de.kaiserpfalzedv.umame.rs.TestObjects.PRT;
import static de.kaiserpfalzedv.umame.rs.TestObjects.TICKET_STRING;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
public class UmamePermissionNeededExceptionMapperTest {
    private static final Logger LOG = LoggerFactory.getLogger(UmamePermissionNeededExceptionMapperTest.class);

    private static final UmamePermissionNeededException EXCEPTION = new UmamePermissionNeededException(AS, PRT);

    private UmamePermissionNeededExceptionMapper service;

    @Test
    public void shouldReturnAvalidResponseForPermissionNeededException() {
        MDC.put("id", "valid-response");

        Response result = service.toResponse(EXCEPTION);

        LOG.debug("Status: {} ({})", result.getStatusInfo(), result.getStatus());
        LOG.debug("Cache control: {}", result.getHeaderString("Cache-control"));
        LOG.debug("Authorization Header: {}", result.getHeaderString("WWW-Authenticate"));

        assert result.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode();
        assert result.getHeaderString("Cache-control").equals("no-store");

        assert result.getHeaderString("WWW-Authenticate").equals(
                "UMA realm=\"" + AS.getRealm() + "\", as_uri=\"" + AS.getUri()
                        + "\", ticket=\"" + TICKET_STRING + "\""
        );
    }

    @Test
    public void shouldReturnTheStatusWhenExceptionIsTested() {
        assert EXCEPTION.getStatus() == Response.Status.UNAUTHORIZED;
        assert EXCEPTION.getAS().equals(AS);
        assert EXCEPTION.getPRT().equals(PRT);
    }


    @BeforeEach
    public void setUpService() {
        service = new UmamePermissionNeededExceptionMapper();
    }
}
