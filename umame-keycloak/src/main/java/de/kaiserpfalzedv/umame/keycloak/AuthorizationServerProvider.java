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

package de.kaiserpfalzedv.umame.keycloak;

import de.kaiserpfalzedv.umame.uma.AuthorizationServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.net.URI;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
@Dependent
public class AuthorizationServerProvider {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationServerProvider.class);

    @Inject
    String realm;

    @Inject
    URI uri;

    public AuthorizationServerProvider() {}

    public AuthorizationServerProvider(
            final String realm,
            final URI uri
    ) {
        this.realm = realm;
        this.uri = uri;
    }


    @Produces
    public AuthorizationServer getAuthorizationServer() {
        return AuthorizationServer.builder()
                .realm(realm)
                .uri(uri)
                .build();
    }
}
