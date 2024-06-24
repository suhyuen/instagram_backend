package com.example.instagram.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Comment {
    private int uid;
    private int userUid;
    private int postUid;
    private String content;
    private LocalDateTime createdAt;
    private String deleteyn;
    private User user;
    private Post post;
}
