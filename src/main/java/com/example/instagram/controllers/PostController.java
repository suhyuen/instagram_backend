package com.example.instagram.controllers;

import com.example.instagram.dtos.PostDto;
import com.example.instagram.models.Post;
import com.example.instagram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/write")
    public String write(@RequestBody PostDto postDto){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.writePost(postDto, userUid);
        return "test";
    }

    @PostMapping("/updatepost")
    public void updatePost(@RequestBody PostDto postDto){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.updatePost(postDto, userUid);
    }

    @PostMapping("/deletepost")
        public void deletePost(@RequestBody PostDto postDto){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.deletePost(postDto, userUid);
    }

    @PostMapping("/selectposts")
    public List<Post> selectposts(@RequestBody PostDto postDto){
        return postService.selectPost(postDto);

    }

    @PostMapping("/detailpost")
    public Post detailPost(@RequestParam(name="uid") int uid){
        return postService.detailPost(uid);
    }

    @PostMapping("/myposts")
    public List<PostDto> myposts() {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.postService.myposts(userUid);
    }

}
