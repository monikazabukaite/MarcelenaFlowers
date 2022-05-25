package com.prekes.web.prekesweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Review implements Comparable<Review>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String user;

    private String product;

    private int rating;

    private String details;

    private String date;

    public Review(String user, String product, int rating, String details, String date) {
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.details = details;
        this.date = date;
    }

    public Review() {
    }

    @Override
    public int compareTo(Review o) {
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
        Review other = (Review) obj;
        return id == other.id;
    }
}
