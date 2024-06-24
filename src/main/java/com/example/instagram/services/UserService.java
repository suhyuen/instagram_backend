package com.example.instagram.services;

import com.example.instagram.dtos.PostDto;
import com.example.instagram.dtos.UserDto;
import com.example.instagram.mappers.UserMapper;
import com.example.instagram.models.Post;
import com.example.instagram.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void signup(UserDto userDto){
        User user = User.builder()
                .userId(userDto.getUserId())
                .userPw(this.passwordEncoder.encode(userDto.getUserPw()))
                .userName(userDto.getUserName())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
        this.userMapper.insertUser(user);
    }

    public void login(String userId){
        Optional<User> userOptional = userMapper.userLogin(userId);
        if (userOptional.isPresent()){
            System.out.println("Login successful");
        } else {
            throw new NoSuchElementException("User not fount");
        }
    }

    public void deleteUser(UserDto userDto, int uid) {
        User user = User.builder()
                .uid(uid)
                .build();
        userMapper.deleteUser(user);
    }

    public void updateUser(UserDto userDto, int uid){
        User user = User.builder()
                .uid(uid)
                .img(userDto.getImg())
                .introduce(userDto.getIntroduce())
                .manWoman(userDto.getManWoman())
                .build();
        userMapper.updateUser(user);
    }

    public UserDto mypage(int userUid){
      return userMapper.selectMyData(userUid);
    }

    public UserDto userPage(int uid){
        return userMapper.selectUser(uid);
    }

    public List<User> selectAllUser(UserDto userDto){
        return userMapper.selectAllUser(userDto);
    }
}
