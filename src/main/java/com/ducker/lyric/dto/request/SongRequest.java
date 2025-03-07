package com.ducker.lyric.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongRequest {
    private String title;

    private String coverUrl;

    private String description;

    private String artist;

    private List<SongArtistRequest> artists;

    private String lyric;

    private Instant releasedAt;
}
