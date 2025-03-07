package com.ducker.lyric.service;

import com.ducker.lyric.dto.request.ArtistFilterRequest;
import com.ducker.lyric.dto.request.ArtistRequest;
import com.ducker.lyric.dto.response.ArtistResponse;
import org.springframework.data.web.PagedModel;

public interface ArtistService {
    void save(ArtistRequest request);

    void update(Long id, ArtistRequest request);

    PagedModel<ArtistResponse> findAll(ArtistFilterRequest request);

    ArtistResponse findOne(Long id);

    void delete(Long id);
}
