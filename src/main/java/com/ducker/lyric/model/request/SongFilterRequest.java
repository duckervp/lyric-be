package com.ducker.lyric.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongFilterRequest {
    private String title;

    private String coverUrl;

    private String description;

    private String artist;

    private String lyric;

    private Instant releasedAt;

    private Integer pageNo = 0;

    private Integer pageSize = 10;

    private Boolean unpaged;
}
