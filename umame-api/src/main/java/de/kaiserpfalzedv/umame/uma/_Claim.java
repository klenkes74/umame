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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.kaiserpfalzedv.umame.Immutable;
import org.immutables.value.Value;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * The service handling the user authorization. Often the same service also
 * handles the authentication - without authentication no authorization may take
 * place. By default an OpenID Connect service.
 *
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
@Immutable
@Value.Modifiable
@JsonSerialize(as = Claim.class)
@JsonDeserialize(builder = Claim.Builder.class)
public interface _Claim {
    @JsonProperty("name")
    String getName();

    @JsonProperty("friendly_name")
    String getFriendlyName();

    @JsonProperty("claim_type")
    String getClaimType();

    @JsonProperty("issuer")
    List<URI> getIssuer();

    @Value.Default
    @JsonProperty("claim_token_format")
    default List<URI> getClaimTokenFormat() {
        List<URI> result = new ArrayList<>(1);

        try {
            result.add(new URI("http://openid.net/specs/openid-connect-core-1_0.html#IDToken"));
        } catch (URISyntaxException e) {
            // won't happen, it's a valid URI ...
        }

        return result;
    }
}
