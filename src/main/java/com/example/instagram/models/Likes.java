package com.example.instagram.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Likes {
    private int uid;
    private int userUid;
    private int postUid;
    private String deleteyn;
    private int likesCount;
    private boolean liked;
}
