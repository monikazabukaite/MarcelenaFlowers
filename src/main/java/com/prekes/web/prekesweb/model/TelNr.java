package com.prekes.web.prekesweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TelNr implements Comparable<TelNr> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String telNr;
    private int userId;
    public TelNr() {
    }

    public TelNr(int id, String telNr, int userId) {
        this.id = id;
        this.telNr = telNr;
        this.userId = userId;
    }

    public TelNr(String telNr, int userId) {
        this.telNr = telNr;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(TelNr o) {
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
        TelNr other = (TelNr) obj;
        return id == other.id;
    }
}
