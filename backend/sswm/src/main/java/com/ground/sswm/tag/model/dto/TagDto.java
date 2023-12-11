package com.ground.sswm.tag.model.dto;

import com.ground.sswm.tag.model.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TagDto {

    private Long id;
    private String name;


    @Builder
    public TagDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TagDto(String name) {
        this.name = name;
    }

    public static TagDto from(Tag tag) {
        return TagDto.builder()
            .id(tag.getId())
            .name(tag.getName())
            .build();
    }
}
