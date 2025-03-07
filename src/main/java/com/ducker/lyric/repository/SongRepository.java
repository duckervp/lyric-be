package com.ducker.lyric.repository;

import com.ducker.lyric.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Page<Song> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    @Query(
            """ 
            SELECT DISTINCT s FROM Song s LEFT JOIN SongArtist sa ON s.id = sa.songId
            LEFT JOIN Artist a ON sa.artistId = a.id
            WHERE a.id = :artistId
            """
    )
    Page<Song> findArtistSongs(Long artistId, Pageable pageable);
}
