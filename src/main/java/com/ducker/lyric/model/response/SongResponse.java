package com.ducker.lyric.model.response;

import com.ducker.lyric.entity.Song;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongResponse {
    private Long id;

    private String title;

    private String coverUrl;

    private String description;

    private String artist;

    private String lyric;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant releasedAt;


    public static SongResponse from(Song song) {
        return SongResponse.builder()
                .id(song.getId())
                .title(song.getTitle())
                .artist(song.getArtist())
                .coverUrl(song.getCoverUrl())
                .description(song.getDescription())
                .lyric(song.getLyric())
                .releasedAt(song.getReleasedAt())
                .build();
    }
}
