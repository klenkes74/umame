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

import de.kaiserpfalzedv.umame.uma.AuthorizationServer;
import de.kaiserpfalzedv.umame.uma.UmameAuthorizationServerUnreachableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
public class UmameAuthorizationServerUnreachableExceptionMapperTest {
    private static final Logger LOG = LoggerFactory.getLogger(UmameAuthorizationServerUnreachableExceptionMapperTest.class);

    private static URI AS_URI;

    static {
        try {
            AS_URI = new URI("https://sso.kaiserpfalz-edv.de/demo/.well_known/");
        } catch (URISyntaxException e) {
            // it's a valid URL!
        }
    }

    private static final AuthorizationServer AS = AuthorizationServer.builder()
            .realm("Kaiserpfalz EDV-Service")
            .uri(AS_URI)
            .build();

    private static final UmameAuthorizationServerUnreachableException EXCEPTION = new UmameAuthorizationServerUnreachableException(AS);

    private UmameAuthorizationServerUnreachableExceptionMapper service;

    @Test
    public void shouldReturnAvalidResponseForUnreachableAuthorizationServers() {
        MDC.put("id", "valid-response");

        Response result = service.toResponse(EXCEPTION);

        LOG.debug("Status: {} ({})", result.getStatusInfo(), result.getStatus());
        LOG.debug("Media Type: {}", result.getMediaType());
        LOG.debug("Cache control: {}", result.getHeaderString("Cache-control"));
        LOG.debug("Warning: {}", result.getHeaderString("Warning"));

        assert result.getStatus() == Response.Status.FORBIDDEN.getStatusCode();
        assert result.getHeaderString("Warning").equals("199 - \"UMA Authorization Server Unreachable\"");
        assert result.getMediaType().equals(MediaType.APPLICATION_JSON_TYPE);
        assert result.getHeaderString("Cache-control").equals("no-store");
    }

    @Test
    public void shouldReturnTheStatusWhenExceptionIsTested() {
        assert EXCEPTION.getStatus() == Response.Status.FORBIDDEN;
        assert EXCEPTION.getAS().equals(AS);
    }


    @BeforeEach
    public void setUpService() {
        service = new UmameAuthorizationServerUnreachableExceptionMapper();
    }
}
