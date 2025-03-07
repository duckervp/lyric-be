package com.ducker.lyric.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistFilterRequest {
    private String searchValue;

    private Integer pageNo = 0;

    private Integer pageSize = 10;

    private Boolean unpaged;
}
