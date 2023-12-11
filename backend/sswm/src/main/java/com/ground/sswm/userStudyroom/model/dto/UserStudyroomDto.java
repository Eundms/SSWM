package com.ground.sswm.userStudyroom.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserStudyroomDto {

    private String role;
    private Integer isDeleted;
    private Integer totalStudy;
    private Integer totalRest;
    private Long userId;
    private Long studyroomId;

}
