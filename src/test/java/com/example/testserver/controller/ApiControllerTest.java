package com.example.testserver.controller;
import com.example.testserver.entity.Article;
import com.example.testserver.entity.Color;
import com.example.testserver.entity.User;
import com.example.testserver.repository.ArticleRepository;
import com.example.testserver.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ApiControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ApiController apiController;



    @Test
    public void testGetUsersByAge() {

        int age = 18;
        List<User> users = new ArrayList<>();
        User user1 =new User();
        user1.setName("John");
        user1.setAge(20);
        user1.setId(1);

        User user2 = new User();
        user2.setName("Jane");
        user2.setAge(18);
        user2.setId(2);
        users.add(user1);
        users.add(user2);
        when(userRepository.findByAgeGreaterThan(anyInt())).thenReturn(users);

        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setText("Article 1");
        article.setUser(user1);
        article.setColor(Color.ORANGE);
        Article article1 = new Article();
        article1.setUser(user2);
        article1.setText("Article 2");
        article1.setColor(Color.GREEN);
        articles.add(article);
        articles.add(article1);
        when(articleRepository.findAll()).thenReturn(articles);

        List<User> result = apiController.getUsersByAge(age);

        assertEquals(users.size(), result.size());
        assertEquals(users.get(0).getName(), result.get(0).getName());
        assertEquals(users.get(1).getName(), result.get(1).getName());
    }
    @Test
    public void testGetUsersWithMoreThanThreeArticles() {
        // Arrange
        int number = 3;
        List<User> users = new ArrayList<>();
        User user1 =new User();
        user1.setName("John");
        user1.setAge(20);
        user1.setId(1);

        User user2 = new User();
        user2.setName("Jane");
        user2.setAge(18);
        user2.setId(2);
        users.add(user1);
        users.add(user2);

        when(userRepository.findUsersByArticleCountGreaterThan(number)).thenReturn(users);

        // Act
        List<String> result = apiController.getUsersWithMoreThanThreeArticles(number);

        // Assert
        assertEquals(users.size(), result.size());
        assertEquals(users.get(0).getName(), result.get(0));
        assertEquals(users.get(1).getName(), result.get(1));
    }
}