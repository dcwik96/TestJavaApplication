package com.projekt.projekt2.service;

import com.projekt.projekt2.entity.Article;
import com.projekt.projekt2.entity.Customer;
import com.projekt.projekt2.entity.Purchase;
import com.projekt.projekt2.repository.ArticleRepo;
import com.projekt.projekt2.repository.CustomerRepo;
import com.projekt.projekt2.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseService {

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    CustomerRepo customerRepo;

    PurchaseRepo purchaseRepo;

    @Autowired
    public void setPurchaseRepo(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    public Purchase save(Purchase purchase) {
        if (customerRepo.findByEmail(purchase.getCustomer().getEmail()) != null) {
            for (Article a : purchase.getArticles()) {
                if (articleRepo.findByName(a.getName()) == null) throw new IllegalArgumentException("Brak artykułu");
            }
            return purchaseRepo.save(purchase);
        } else throw new IllegalArgumentException("Brak Customera");
    }

    public Purchase updateCustomer(Purchase purchase, Customer customer) {
        if (customerRepo.findByEmail(customer.getEmail()) != null) {
            purchase.setCustomer(customer);
            return purchaseRepo.save(purchase);
        }
        return null;
    }

    public Purchase updateArticles(Purchase purchase, ArrayList<Article> articles) {
        for (Article a : articles) {
            if (articleRepo.findByName(a.getName()) == null) return null;
        }
        purchase.setArticles(articles);
        return purchaseRepo.save(purchase);
    }

    public boolean checkIfExistsInDb(Long id) {
        return purchaseRepo.existsById(id);
    }
}
