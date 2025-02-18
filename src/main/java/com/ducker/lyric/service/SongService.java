package com.ducker.lyric.service;

import com.ducker.lyric.entity.Song;
import com.ducker.lyric.model.request.SongFilterRequest;
import com.ducker.lyric.model.request.SongRequest;
import com.ducker.lyric.model.response.SongResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;

public interface SongService {
    void save(SongRequest request);

    void update(Long id, SongRequest request);

    PagedModel<SongResponse> findAll(SongFilterRequest request);

    SongResponse findOne(Long id);

    void delete(Long id);
}
