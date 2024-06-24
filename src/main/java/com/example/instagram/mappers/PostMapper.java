package com.example.instagram.mappers;

import com.example.instagram.dtos.PostDto;
import com.example.instagram.models.Post;
import com.example.instagram.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void writePost(Post post);

    void updatePost(Post post);

    void deletePost(Post post);

    List<Post> selectPost(PostDto postDto);

    Post detailPost(int uid);

    List<PostDto> myPosts(int userUid);

}
