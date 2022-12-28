package com.springboot.blog.payload;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Data
public class CommentDto {
    private long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty
    @Email(message = "Please pass a correct email format")
    private String email;
    @NotEmpty(message = "Atleast some message is needed")
    private String body;
}
