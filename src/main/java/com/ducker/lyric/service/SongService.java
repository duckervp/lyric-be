package com.ducker.lyric.service;

import com.ducker.lyric.dto.request.SongFilterRequest;
import com.ducker.lyric.dto.request.SongRequest;
import com.ducker.lyric.dto.response.SongResponse;
import org.springframework.data.web.PagedModel;

public interface SongService {
    void save(SongRequest request);

    void update(Long id, SongRequest request);

    PagedModel<SongResponse> findAll(SongFilterRequest request);

    SongResponse findOne(Long id);

    void delete(Long id);
}
