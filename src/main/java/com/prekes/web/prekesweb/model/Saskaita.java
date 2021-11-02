package com.prekes.web.prekesweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Saskaita implements Comparable<Saskaita>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int telNrId;
    private int menuo;
    private BigDecimal suma;

    public Saskaita(int id, int telNrId, int menuo, BigDecimal suma) {
        this.id = id;
        this.telNrId = telNrId;
        this.menuo = menuo;
        this.suma = suma;
    }

    public Saskaita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuo() {
        return menuo;
    }

    public void setMenuo(int menuo) {
        this.menuo = menuo;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }

    public int getTelNrId() {
        return telNrId;
    }

    public void setTelNrId(int telNrId) {
        this.telNrId = telNrId;
    }

    @Override
    public int compareTo(Saskaita o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Saskaita other = (Saskaita) obj;
        return id == other.id;
    }
}
