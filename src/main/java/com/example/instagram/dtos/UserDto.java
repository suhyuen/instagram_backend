package com.example.instagram.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int uid;
    private String userId;
    private String userPw;
    private String userName;
    private String phoneNumber;
    private String Role;
    private byte[] img;
    private String introduce;
    private String manWoman;

}
