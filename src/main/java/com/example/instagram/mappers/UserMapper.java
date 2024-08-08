package com.example.instagram.mappers;

import com.example.instagram.dtos.PostDto;
import com.example.instagram.dtos.UserDto;
import com.example.instagram.models.Post;
import com.example.instagram.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    Optional<User> userLogin(String userId);

    void deleteUser(User user);

    void updateUser(User user);
    void updateUserProfileImage(@Param("uid") int uid, @Param("img") String imagePath);

    UserDto selectMyData(int uid);

    UserDto selectUser(int uid);

    List<User> selectAllUser(UserDto userDto);

    List<User> selectUserId(UserDto userDto);

}
