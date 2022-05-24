package com.prekes.web.prekesweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
public class Item implements Comparable<Item>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String category;
    public String imgUrl;
    public int price;

    public Item(int id, String category, String name, String imgUrl, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public Item() {

    }

    public void filterCategory(String category, List<Item> itemsList) {

    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }
}
