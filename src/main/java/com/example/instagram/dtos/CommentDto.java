package com.example.instagram.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private int uid;
    private int userUid;
    private int postUid;
    private String content;
    private LocalDateTime createdAt;
    private String deleteyn;
}
