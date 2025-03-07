package com.ducker.lyric.model;

import com.ducker.lyric.base.BaseModel;
import com.ducker.lyric.enums.ArtistType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction(value = "is_deleted = false")
public class SongArtist extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long artistId;

    private Long songId;

    @Enumerated(EnumType.STRING)
    private ArtistType type;
}
