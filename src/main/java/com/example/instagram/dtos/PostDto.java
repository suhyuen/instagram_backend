package com.example.instagram.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private int uid;
    private int userUid;
    private String content;
}
