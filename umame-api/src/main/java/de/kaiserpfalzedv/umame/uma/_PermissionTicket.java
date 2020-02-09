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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.kaiserpfalzedv.umame.Immutable;
import org.immutables.value.Value;

/**
 * A correlation handle representing requested permissions that is created and
 * maintained by the authorization server, initially passed to the client by the
 * resource server, and presented by the client at the token endpoint and during
 * requesting party redirects.
 *
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
@Immutable
@Value.Modifiable
@JsonSerialize(as = PermissionTicket.class)
@JsonDeserialize(builder = PermissionTicket.Builder.class)
public interface _PermissionTicket {
    String getTicket();
}
