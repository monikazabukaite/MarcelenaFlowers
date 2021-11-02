package com.prekes.web.prekesweb.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaskaitaTest {
    @Test
    void saskaitaConstructorParameters() {
        Saskaita saskaita = new Saskaita(1, 2, 3, BigDecimal.TEN);
        assertAll("Test TelNr constructor",
                () -> assertEquals(1, saskaita.getId()),
                () -> assertEquals(2, saskaita.getTelNrId()),
                () -> assertEquals(3, saskaita.getMenuo()),
                () -> assertEquals(BigDecimal.TEN, saskaita.getSuma())
        );
    }

    @Test
    void testCompareTo() {
        Saskaita saskaita1 = new Saskaita(1, 2, 3, BigDecimal.TEN);
        Saskaita saskaita2 = new Saskaita(1, 2, 3, BigDecimal.TEN);
        assertEquals(0, saskaita1.compareTo(saskaita2));
    }

    @Test
    void testEqualsObject() {
        Saskaita saskaita1 = new Saskaita(1, 2, 3, BigDecimal.TEN);
        Saskaita saskaita2 = new Saskaita(1, 2, 3, BigDecimal.TEN);
        assertEquals(saskaita1, saskaita2);
    }

}
