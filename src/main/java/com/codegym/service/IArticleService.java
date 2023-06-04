package com.codegym.service;

import com.codegym.model.Article;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();

    void save(Article customer);

    Article findById(int id);

    void update(int id, Article customer);

    void remove(int id);
}
