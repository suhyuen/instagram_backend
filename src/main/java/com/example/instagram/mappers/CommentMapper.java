package com.example.instagram.mappers;

import com.example.instagram.models.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void commentCreate(Comment comment);
    List<Comment> selectComment(int postUid);

    void updateComment(Comment comment);

    void deleteComment(Comment comment);
}
