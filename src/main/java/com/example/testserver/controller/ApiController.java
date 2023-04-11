package com.example.testserver.controller;

import com.example.testserver.entity.Article;
import com.example.testserver.entity.Color;
import com.example.testserver.entity.User;
import com.example.testserver.model.UserResponseMethod;
import com.example.testserver.repository.ArticleRepository;
import com.example.testserver.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public ApiController(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/users/age/{age}")
    public List<User> getUsersByAge(@PathVariable int age) {
        List<User> userRep =userRepository.findByAgeGreaterThan(age);
        List<Article> articleRep=articleRepository.findAll();
        UserResponseMethod userReview = new UserResponseMethod(userRep,articleRep);
        return userReview.userResponse;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/users/color/{color}")
    public List<User> findByArticlesColor(@PathVariable Color color) {
        List<User> userRep =userRepository.findByArticlesColor(color);
        System.out.println(userRep.size());
        List<Article> articleRep=articleRepository.findAll();
        UserResponseMethod userReview = new UserResponseMethod(userRep,articleRep);
        return userReview .userResponse;
    }

    @GetMapping("/users/names-with-more-than-3-articles/{number}")
    public List<String> getUsersWithMoreThanThreeArticles(@PathVariable int number) {
        List<User> users = userRepository.findUsersByArticleCountGreaterThan(number);
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }
        return names;

    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/articles")
    public Article saveArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }
}

