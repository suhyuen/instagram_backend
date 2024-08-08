package com.example.instagram.mappers;

import com.example.instagram.dtos.LikesDto;
import com.example.instagram.models.Likes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LikesMapper {
    void insertLikes(@Param("userUid") int userUid, @Param("postUid") int postUid);
    List<Likes> likesUser(LikesDto likesDto);
    void deleteLikes(Likes likes);
}
