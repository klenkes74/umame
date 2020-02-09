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

package de.kaiserpfalzedv.umame.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.kaiserpfalzedv.umame.Immutable;
import org.immutables.value.Value;

import java.net.URI;


/**
 * A client according to UMA specification.
 *
 * @author rlichti
 * @version 1.0.0 2020-02-09
 * @since 1.0.0 2020-02-09
 */
@Immutable
@Value.Modifiable
@JsonSerialize(as = Client.class)
@JsonDeserialize(builder = Client.Builder.class)
public interface _Client {
    String getName();

    URI getURI();
}
