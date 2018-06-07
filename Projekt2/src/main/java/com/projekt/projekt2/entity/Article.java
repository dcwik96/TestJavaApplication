package com.projekt.projekt2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {

    private Long id;
    private String name;
    private double value;
    private List<Purchase> purchases;

    public Article() {
    }

    public Article(String name, double value, List<Purchase> orders) {
        this.name = name;
        this.value = value;
        this.purchases = orders;
    }

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @ManyToMany(mappedBy = "articles", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
