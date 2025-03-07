package com.ducker.lyric.dto.request;

import com.ducker.lyric.enums.ArtistType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistRequest {
    private ArtistType type;

    private String name;

    private String imageUrl;

    private String description;
}
