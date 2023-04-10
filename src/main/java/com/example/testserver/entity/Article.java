package com.example.testserver.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="`article`")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    @Enumerated(EnumType.ORDINAL)
    private Color color;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;


    public Article() {
    }

    public Article(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
