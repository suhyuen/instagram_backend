package com.example.instagram.services;

import com.example.instagram.dtos.CommentDto;
import com.example.instagram.mappers.CommentMapper;
import com.example.instagram.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public void writeComment(CommentDto commentDto, int userUid, int postUid){
        Comment comment = Comment.builder()
                .userUid(userUid)
                .postUid(postUid)
                .content(commentDto.getContent())
                .build();
        commentMapper.commentCreate(comment);
    }

    public List<Comment> selectComment(int postUid){
        return commentMapper.selectComment(postUid);
    }

    public void updateComment(CommentDto commentDto, int userUid){
        Comment comment = Comment.builder()
                .uid(commentDto.getUid())
                .userUid(userUid)
                .content(commentDto.getContent())
                .build();
        commentMapper.updateComment(comment);
    }

    public void deleteComment(CommentDto commentDto, int userUId){
        Comment comment = Comment.builder()
                .uid(commentDto.getUid())
                .userUid(userUId)
                .build();
        commentMapper.deleteComment(comment);
    }
}
