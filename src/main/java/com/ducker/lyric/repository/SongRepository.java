package com.ducker.lyric.repository;

import com.ducker.lyric.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Page<Song> findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(String title, String artist, Pageable pageable);
}
