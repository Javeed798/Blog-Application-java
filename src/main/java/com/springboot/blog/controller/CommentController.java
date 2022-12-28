package com.springboot.blog.controller;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED);
    }

    @GetMapping("posts/comments/{postId}")
    public List<CommentDto> getCommentsByPostId(@PathVariable long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId, @PathVariable(value = "id") long id){
        CommentDto commentDto = commentService.getCommentById(postId,id);
        return new ResponseEntity(commentDto,HttpStatus.OK);
    }

    @PutMapping("posts/{postId}/comments/{commentId}/update")
    public ResponseEntity<CommentDto> updatedComment(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "commentId") Long commentId,
                                                     @Valid @RequestBody CommentDto commentDto){
        CommentDto commentDto1 = commentService.updateCommentById(postId,commentId,commentDto);
        return new ResponseEntity<>(commentDto1,HttpStatus.OK);
    }

    @DeleteMapping("posts/{postId}/comments/{commentId}/delete")
    public String deleteComment(@PathVariable  Long postId, @PathVariable  Long commentId){
        commentService.deleteComment(postId,commentId);
        return "Comment deleted Successfully";
    }
}
