package com.prekes.web.prekesweb.model;

import java.math.BigDecimal;

public class SaskaitaDto {
    public int id;
    public int telNrId;
    public int menuo;
    public BigDecimal suma;
    public String telNr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelNrId() {
        return telNrId;
    }

    public void setTelNrId(int telNrId) {
        this.telNrId = telNrId;
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

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public SaskaitaDto(Saskaita saskaita, String telNr) {
        this.id = saskaita.getId();
        this.telNrId = saskaita.getTelNrId();
        this.menuo = saskaita.getMenuo();
        this.suma = saskaita.getSuma();
        this.telNr = telNr;
    }

}
