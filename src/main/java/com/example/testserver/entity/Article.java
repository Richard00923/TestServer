package com.example.testserver.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "`article`")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    @Enumerated(EnumType.ORDINAL)
    private Color color;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Article() {
    }

    public Article(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }
}


