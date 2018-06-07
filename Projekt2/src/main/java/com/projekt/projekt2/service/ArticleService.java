package com.projekt.projekt2.service;

import com.projekt.projekt2.entity.Article;
import com.projekt.projekt2.entity.Purchase;
import com.projekt.projekt2.repository.ArticleRepo;
import com.projekt.projekt2.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {

    @Autowired
    PurchaseRepo purchaseRepo;

    @Autowired
    ArticleRepo articleRepo;

    public Article updateName(Article article, String newName) {
        if (articleRepo.findByName(article.getName()) != null) {
            article.setName(newName);
            return articleRepo.save(article);
        }
        return null;
    }

    public Article save(Article article) {
        if (articleRepo.findByName(article.getName()) == null) {
            return articleRepo.save(article);
        } else throw new IllegalArgumentException("Ta nazwa juz istnieje");
    }

    public Article updateValue(Article article, double newValue) {
        if (articleRepo.findByName(article.getName()) != null) {
            article.setValue(newValue);
            return articleRepo.save(article);
        }

        return null;
    }

    public Article updatePurchase(Article article, ArrayList<Purchase> purchases) {
        if (articleRepo.findByName(article.getName()) != null) {
            for (Purchase p : purchases) {
                if (purchaseRepo.findPurchaseById(p.getId()) != null) {
                    article.setPurchases(purchases);
                } else return null;
            }
            return articleRepo.save(article);
        }
        return null;
    }

    public boolean deleteArticle(Article article) {
        if (articleRepo.findByName(article.getName()) != null)
            return articleRepo.deleteByName(article.getName());
        return false;
    }
}
