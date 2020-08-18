package com.devesh.Project.MongoDbAssignment.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

   /* @Id
     private String id;*/

    private String name;

    private String authorName;

    private int cost;

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Book setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public int getCost() {

        return cost;
    }

    public Book setCost(int cost) {
        this.cost = cost;
        return this;
    }


}
