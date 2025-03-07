package com.ducker.lyric.dto.request;

import com.ducker.lyric.enums.ArtistType;
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
public class SongArtistRequest {
    private Long artistId;

    private ArtistType type;
}
