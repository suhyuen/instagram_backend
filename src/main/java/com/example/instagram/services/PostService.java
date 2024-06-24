package com.example.instagram.services;

import com.example.instagram.dtos.PostDto;
import com.example.instagram.mappers.PostMapper;
import com.example.instagram.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;

    public void writePost(PostDto postDto, int userUid){
        Post post = Post.builder()
                .content(postDto.getContent())
                .userUid(userUid)
                .build();

        postMapper.writePost(post);
    }

    public void updatePost(PostDto postDto, int userUid){
        Post post = Post.builder()
                .uid(postDto.getUid())
                .userUid(userUid)
                .content(postDto.getContent())
                .build();
        postMapper.updatePost(post);
    }

    public void deletePost(PostDto postDto, int userUid){
        Post post = Post.builder()
                .uid(postDto.getUid())
                .userUid(userUid)
                .build();
        postMapper.deletePost(post);
    }


    public List<Post> selectPost(PostDto postDto){
        return postMapper.selectPost(postDto);
    }

    public Post detailPost(int uid){
        return postMapper.detailPost(uid);
    }

    public List<PostDto> myposts(int userUid) {
        return this.postMapper.myPosts(userUid);
    }

}
