package com.springboot.blog.payload;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {
    private long id;

    //    title should not be empty
//    title should have atleast 2 chars
    @NotEmpty
    @Size(min = 2, message = "Post title should have atleast 2 characters")
    private String title;
    //    description should not be empty
//    description should have atleast 2 chars
    @NotEmpty
    @Size(min = 10, message = "Description must be atleast 10 characters")
    private String description;
//    post content should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
