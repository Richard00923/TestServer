package com.example.testserver.repository;
import com.example.testserver.entity.Color;
import com.example.testserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByAgeGreaterThan(int age);
    @Query("select u from User u inner join u.articles articles where articles.color = ?1")
    List<User> findByArticlesColor(Color color);
//    List<User> findByArticlesSizeGreaterThan(int size);
}