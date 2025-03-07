package com.ducker.lyric.dto.response;

import com.ducker.lyric.model.Artist;
import com.ducker.lyric.enums.ArtistType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistResponse {
    private Long id;

    private ArtistType type;

    private String name;

    private String imageUrl;

    private String description;


    public static ArtistResponse from(Artist artist) {
        return ArtistResponse.builder()
                .id(artist.getId())
                .name(artist.getName())
                .imageUrl(artist.getImageUrl())
                .description(artist.getDescription())
                .build();
    }
}
