package com.example.instagram.controllers;

import com.example.instagram.dtos.LikesDto;
import com.example.instagram.models.Likes;
import com.example.instagram.services.LikesService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikesController {
    @Autowired
    LikesService likesService;

    @PostMapping("/post/{postUid}/insertLikes")
    public void insertLikes(@PathVariable("postUid") int postUid){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        likesService.insertLikes(userUid, postUid);
    }

    @PostMapping("/likesUser")
    public List<Likes> likesUser(@RequestBody LikesDto likesDto){
        System.out.println(likesService.likesUser(likesDto));
        return likesService.likesUser(likesDto);
    }

    @PostMapping("/post/{postUid}/deleteLikes")
    public void deleteLikes(@RequestBody LikesDto likesDto, @PathVariable("postUid") int postUid){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        likesService.deleteLikes(likesDto, userUid, postUid);
    }
}
