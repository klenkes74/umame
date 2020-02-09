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
import de.kaiserpfalzedv.umame.uma.PermissionTicket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
public class TestObjects {
    public static URI AS_URI;

    static {
        try {
            AS_URI = new URI("https://sso.kaiserpfalz-edv.de/demo/.well_known/");
        } catch (URISyntaxException e) {
            // it's a valid URL!
        }
    }

    public static final AuthorizationServer AS = AuthorizationServer.builder()
            .realm("Kaiserpfalz EDV-Service")
            .uri(AS_URI)
            .build();

    public static final String TICKET_STRING = UUID.randomUUID().toString();
    public static final PermissionTicket PRT = PermissionTicket.builder()
            .ticket(TICKET_STRING)
            .build();

}
