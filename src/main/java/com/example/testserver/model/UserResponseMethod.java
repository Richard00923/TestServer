package com.example.testserver.model;

import com.example.testserver.entity.Article;
import com.example.testserver.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseMethod {
    public List<User> userResponse = new ArrayList<>();

    public UserResponseMethod(List<User> allUsers, List<Article> allArticles) {
        for (User user : allUsers) {
            this.id = user.getId();
            this.name = user.getName();
            this.age = user.getAge();
            for (Article article : allArticles) {
                if (article.getUser().getId() == this.id) {
                    articles.add(new Article(article.getId(), article.getText(), article.getColor()));
                }
            }
            userResponse.add(new User(this.id, this.name, this.age, this.articles));
            this.articles = new ArrayList<>();
        }

    }

    private List<Article> articles = new ArrayList<>();
    private int id;
    private String name;
    private int age;
}
