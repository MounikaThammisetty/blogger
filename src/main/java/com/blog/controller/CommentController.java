package com.blog.controller;

import com.blog.Service.CommentService;
import com.blog.payload.CommentDto;

import com.blog.payload.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam("postId")long postId, @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

   @DeleteMapping("/{commentId}")
    public ResponseEntity<String>deleteComment(@PathVariable long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("comment is deleted",HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>>getCommentByPostId(@PathVariable long postId){
        List<CommentDto> commentDto = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CommentDto>updateComment(@RequestParam("commentId")long commentId,@RequestBody CommentDto commentDto){
        CommentDto dto = commentService.updateComment(commentId, commentDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

   @GetMapping
    public ResponseEntity<List<CommentDto>>getAllComments(){
      List<CommentDto> commentDtos =  commentService.getAllComments();
      return new ResponseEntity<>(commentDtos,HttpStatus.OK);
    }
}
