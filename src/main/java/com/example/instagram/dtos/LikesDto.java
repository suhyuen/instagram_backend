package com.example.instagram.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikesDto {
    private int uid;
    private int userUid;
    private int postUid;
    private boolean liked;
    private String deleteyn;

}
