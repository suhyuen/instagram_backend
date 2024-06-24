package com.example.instagram.controllers;

import com.example.instagram.dtos.PostDto;
import com.example.instagram.dtos.UserDto;
import com.example.instagram.models.Post;
import com.example.instagram.models.User;
import com.example.instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody UserDto userDto){
        userService.signup(userDto);
        return "test";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        userService.login(userDto.getUserId());
        return "test";
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody UserDto userDto){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.deleteUser(userDto, userUid);
    }

    @PostMapping("/changeprofile")
    public void updateUser(@RequestBody UserDto userDto){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.updateUser(userDto, userUid);
    }

    @PostMapping("/mypage")
    public UserDto mypage(){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.mypage(userUid);
    }

    @GetMapping("/profilepage")
    public UserDto userpage(@RequestParam("uid") int uid){
        return userService.userPage(uid);
    }

    @PostMapping("/selectUser")
    public List<User> selectuser(@RequestBody UserDto userDto){
        return userService.selectAllUser(userDto);

    }

}
