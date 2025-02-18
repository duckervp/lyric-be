package com.ducker.lyric.service.impl;

import com.ducker.lyric.entity.Song;
import com.ducker.lyric.exception.ApiException;
import com.ducker.lyric.model.request.SongFilterRequest;
import com.ducker.lyric.model.request.SongRequest;
import com.ducker.lyric.model.response.SongResponse;
import com.ducker.lyric.repository.SongRepository;
import com.ducker.lyric.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    @Override
    public void save(SongRequest request) {
        Song song = Song.builder()
                .title(request.getTitle())
                .artist(request.getArtist())
                .coverUrl(request.getCoverUrl())
                .description(request.getDescription())
                .lyric(request.getLyric())
                .releasedAt(request.getReleasedAt())
                .build();
        songRepository.save(song);
    }

    @Override
    public void update(Long id, SongRequest request) {
        Song song = findById(id);
        if (request.getTitle() != null) {
            song.setTitle(request.getTitle());
        }

        if (request.getArtist() != null) {
            song.setArtist(request.getArtist());
        }

        if (request.getCoverUrl() != null) {
            song.setCoverUrl(request.getCoverUrl());
        }

        if (request.getDescription() != null) {
            song.setDescription(request.getDescription());
        }

        if (request.getLyric() != null) {
            song.setLyric(request.getLyric());
        }

        if (request.getReleasedAt() != null) {
            song.setReleasedAt(request.getReleasedAt());
        }

        songRepository.save(song);
    }

    @Override
    public PagedModel<SongResponse> findAll(SongFilterRequest request) {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        Pageable pageable = Pageable.unpaged(sort);
        if (!Boolean.TRUE.equals(request.getUnpaged())) {
            pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        }
        Page<Song> result = songRepository.findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(
                request.getTitle(), request.getArtist(), pageable);
        return new PagedModel<>(result.map(SongResponse::from));
    }

    @Override
    public SongResponse findOne(Long id) {
        Song song = findById(id);
        return SongResponse.from(song);
    }

    @Override
    public void delete(Long id) {
        Song song = findById(id);
        songRepository.delete(song);
    }

    private Song findById(Long id) {
        return songRepository.findById(id).orElseThrow(ApiException::new);
    }
}
