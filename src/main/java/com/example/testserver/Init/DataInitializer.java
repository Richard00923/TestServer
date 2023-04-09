package com.example.testserver.Init;
import com.example.testserver.entity.Article;
import com.example.testserver.entity.Color;
import com.example.testserver.entity.User;
import com.example.testserver.repository.ArticleRepository;
import com.example.testserver.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public DataInitializer(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello");
        Random random = new Random();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("User " + (i + 1));
            user.setAge(random.nextInt(50) + 18);

            List<Article> articles = new ArrayList<>();
            for (int j = 0; j < Math.random()*6; j++) {
                Article article = new Article();
                article.setText("Article " + (j + 1) + " by " + user.getName());
                article.setColor(Color.values()[random.nextInt(Color.values().length)]);
                article.setUser(user);
                articles.add(article);
            }
            user.setArticleCount(articles.size());
            user.setArticles(articles);
            users.add(user);



        }
        System.out.println(users.get(1).getArticleCount());

        userRepository.saveAll(users);
    }
}