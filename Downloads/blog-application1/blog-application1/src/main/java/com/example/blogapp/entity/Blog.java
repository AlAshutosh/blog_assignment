package com.example.blogapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter  // Generates getters for all fields
@Setter  // Generates setters for all fields
public class Blog {
    @Id
    private Long id;
    private String title;
    private String body;

    // You can also manually define the getters if you are not using Lombok
    // public String getTitle() {
    //     return title;
    // }

    // public String getBody() {
    //     return body;
    // }
}
