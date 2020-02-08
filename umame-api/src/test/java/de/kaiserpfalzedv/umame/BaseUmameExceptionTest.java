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

package de.kaiserpfalzedv.umame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
public class BaseUmameExceptionTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseUmameExceptionTest.class);

    private static final String MESSAGE = "message";
    private static final Exception CAUSE = new Exception("cause");

    private BaseUmameException service;

    @Test
    public void shouldReturnMessageGivenInConstructor() {
        assert MESSAGE.equals(service.getMessage());
    }

    @Test
    public void shouldReturnCauseGivenInConstructor() {
        assert CAUSE.equals(service.getCause());
    }

    @Test
    public void shouldAcceptConstructorWithOnlyMessage() {
        service = new BaseUmameException(MESSAGE);

        assert service.getCause() == null;
        assert MESSAGE.equals(service.getMessage());
    }


    @BeforeEach
    public void setUpService() {
        service = new BaseUmameException(MESSAGE, CAUSE);
    }
}