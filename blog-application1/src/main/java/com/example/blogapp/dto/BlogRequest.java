package com.example.blogapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequest {

    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
