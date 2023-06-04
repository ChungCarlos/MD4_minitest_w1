package com.codegym.controller;

import com.codegym.model.Article;
import com.codegym.service.ArticleService;
import com.codegym.service.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/article")

public class ArticleController {
    private final IArticleService articleService = new ArticleService();
    @GetMapping("")
    public String index(Model model) {
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articles", articleList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("article", new Article());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Article article) {
        article.setId((int) (Math.random() * 10000));
        articleService.save(article);
        return "redirect:/article";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Article article) {
        articleService.update(article.getId(), article);
        return "redirect:/article";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Article article, RedirectAttributes redirect) {
        articleService.remove(article.getId());
        redirect.addFlashAttribute("success", "Removed article successfully!");
        return "redirect:/article";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "/view";
    }
}
