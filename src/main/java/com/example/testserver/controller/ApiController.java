package com.example.testserver.controller;
import com.example.testserver.repository.ArticleRepository;
import com.example.testserver.repository.UserRepository;
import com.example.testserver.entity.Article;
import com.example.testserver.entity.Color;
import com.example.testserver.entity.User;
import org.springframework.web.bind.annotation.*;
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
//    private final ArticleRepository articleRepository;

    @GetMapping("/users/age/{age}")
    public List<User> getUsersByAge(@PathVariable int age) {
        List<User> userRep =userRepository.findByAgeGreaterThan(age);
        return userRep;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/users/color/{color}")
    public List<User> getUsersByArticleColor(@PathVariable Color color) {
        return userRepository.findByArticlesColor(color);
    }

//    @GetMapping("/users/name")
//    public List<String> getUniqueUserNamesWithMoreThanThreeArticles() {
//        return userRepository.findByArticlesSizeGreaterThan(3)
//                .stream()
//                .map(User::getName)
//                .distinct()
//                .collect(Collectors.toList());
//    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/articles")
    public Article saveArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }
}

