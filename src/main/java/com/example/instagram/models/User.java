package com.example.instagram.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String userId;
    private String userPw;
    private String userName;
    private String phoneNumber;
    private byte[] img;
    private String introduce;
    private String manWoman;
    private LocalDateTime createdAt;
    private String auth;
    private String deleteyn;
}
