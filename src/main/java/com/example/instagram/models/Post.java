package com.example.instagram.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private int uid;
    private int userUid;
    private String content;
    private LocalDateTime createdAt;
    private String deleteyn;
    private User user;
}
