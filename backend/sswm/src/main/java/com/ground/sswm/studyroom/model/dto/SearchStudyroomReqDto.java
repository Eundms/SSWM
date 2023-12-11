package com.ground.sswm.studyroom.model.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class SearchStudyroomReqDto {

    private String sortBy;
    private String orderBy;
    private String searchKeyword;
    private List<String> tagNames;
    private boolean showFull;
    private boolean isPublic;

    public boolean getIsPublic() {
        return this.isPublic;
    }
}

