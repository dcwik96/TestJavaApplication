package com.projekt.projekt2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Purchase {

    private Long id;
    private Customer customer;
    private List<Article> articles;

    public Purchase() {
    }

    public Purchase(Customer customer, List<Article> articles) {
        this.customer = customer;
        this.articles = articles;
    }

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
