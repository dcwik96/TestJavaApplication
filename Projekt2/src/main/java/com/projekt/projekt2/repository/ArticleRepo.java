package com.projekt.projekt2.repository;


import com.projekt.projekt2.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {

    Article findByName(String name);

    boolean deleteByName(String name);

}
