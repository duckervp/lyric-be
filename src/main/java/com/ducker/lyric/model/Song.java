package com.ducker.lyric.model;

import com.ducker.lyric.base.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction(value = "is_deleted = false")
public class Song extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String coverUrl;

    private String description;

    private String artist;

    @Column(columnDefinition = "TEXT")
    private String lyric;

    private Instant releasedAt;
}
