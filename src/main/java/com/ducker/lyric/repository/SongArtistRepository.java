package com.ducker.lyric.repository;

import com.ducker.lyric.model.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongArtistRepository extends JpaRepository<SongArtist, Long> {
}
