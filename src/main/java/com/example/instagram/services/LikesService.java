package com.example.instagram.services;

import com.example.instagram.dtos.LikesDto;
import com.example.instagram.mappers.LikesMapper;
import com.example.instagram.models.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LikesService {
    @Autowired
    LikesMapper likesMapper;

    public void insertLikes(int userUid, int postUid){

        likesMapper.insertLikes(userUid, postUid);

    }

    public List<Likes> likesUser(LikesDto likesDto){
        return likesMapper.likesUser(likesDto);
    }

    public void deleteLikes(LikesDto likesDto, int userUid, int postUid){
        Likes likes = Likes.builder()
                .uid(likesDto.getUid())
                .userUid(userUid)
                .postUid(postUid)
                .build();
        likesMapper.deleteLikes(likes);

    }
}
