package com.ducker.lyric.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Song {
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
