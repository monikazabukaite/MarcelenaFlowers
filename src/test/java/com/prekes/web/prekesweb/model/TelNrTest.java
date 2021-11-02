package com.prekes.web.prekesweb.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelNrTest {
    @Test
    void telNrConstructorParameters() {
        TelNr telNr = new TelNr(1, "+370", 1);
        assertAll("Test TelNr constructor",
                () -> assertEquals(1, telNr.getId()),
                () -> assertEquals("+370", telNr.getTelNr()),
                () -> assertEquals(1, telNr.getUserId())
        );
    }

    @Test
    void testCompareTo() {
        TelNr telNr1 = new TelNr(1, "+370", 1);
        TelNr telNr2 = new TelNr(1, "+370", 1);
        assertEquals(0, telNr1.compareTo(telNr2));
    }

    @Test
    void testEqualsObject() {
        TelNr telNr1 = new TelNr(1, "+370", 1);
        TelNr telNr2 = new TelNr(1, "+370", 1);
        assertEquals(telNr1, telNr2);
    }

}
