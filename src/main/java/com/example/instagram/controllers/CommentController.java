package com.example.instagram.controllers;

import com.example.instagram.dtos.CommentDto;
import com.example.instagram.models.Comment;
import com.example.instagram.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/detailpost/{postUid}/commentwrite")
    public String writeComment(@RequestBody CommentDto commentDto,  @PathVariable("postUid") int postUid){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.writeComment(commentDto, userUid, postUid);
        return "test";
    }

    @PostMapping("/selectcomment")
    public List<Comment> selectComment(@RequestParam(value = "postUid") int postUid){
        return commentService.selectComment(postUid);
    }

    @PostMapping("/detailpost/{postUid}/updatecomment")
    public void updateComment(@RequestBody CommentDto commentDto, @PathVariable(value = "postUid") int postUid){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.updateComment(commentDto, userUid);
    }

    @PostMapping("/detailpost/{postUid}/deletecomment")
    public void commentDelete(@RequestBody CommentDto commentDto, @PathVariable(value = "postUid") int postUid){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.deleteComment(commentDto, userUid);
    }

}
