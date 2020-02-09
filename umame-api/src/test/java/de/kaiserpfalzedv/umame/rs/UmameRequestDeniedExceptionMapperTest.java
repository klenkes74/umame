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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static de.kaiserpfalzedv.umame.rs.TestObjects.AS;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
public class UmameRequestDeniedExceptionMapperTest {
    private static final Logger LOG = LoggerFactory.getLogger(UmameRequestDeniedExceptionMapperTest.class);

    private static final UmameRequestDeniedException EXCEPTION = new UmameRequestDeniedException(AS);

    private UmameRequestDeniedExceptionMapper service;

    @Test
    public void shouldReturnAvalidResponseForPermissionNeededException() {
        MDC.put("id", "valid-response");

        Response result = service.toResponse(EXCEPTION);

        LOG.debug("Status: {} ({})", result.getStatusInfo(), result.getStatus());
        LOG.debug("Content type: {}", result.getMediaType());
        LOG.debug("Cache control: {}", result.getHeaderString("Cache-control"));
        LOG.debug("Content: {}", result.getEntity());


        assert result.getStatus() == Response.Status.FORBIDDEN.getStatusCode();
        assert result.getMediaType().equals(MediaType.APPLICATION_JSON_TYPE);
        assert result.getHeaderString("Cache-control").equals("no-store");

        assert result.getEntity().equals(EXCEPTION.getMessage());
    }

    @Test
    public void shouldReturnTheStatusWhenExceptionIsTested() {
        assert EXCEPTION.getStatus() == Response.Status.FORBIDDEN;
        assert EXCEPTION.getAS().equals(AS);
    }


    @BeforeEach
    public void setUpService() {
        service = new UmameRequestDeniedExceptionMapper();
    }
}
