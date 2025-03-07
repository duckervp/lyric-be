package com.ducker.lyric.service.impl;

import com.ducker.lyric.dto.request.ArtistFilterRequest;
import com.ducker.lyric.dto.request.ArtistRequest;
import com.ducker.lyric.dto.response.ArtistResponse;
import com.ducker.lyric.model.Artist;
import com.ducker.lyric.enums.apicode.CommonApiCode;
import com.ducker.lyric.exception.ApiException;
import com.ducker.lyric.repository.ArtistRepository;
import com.ducker.lyric.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public void save(ArtistRequest request) {
        Artist artist = Artist.builder()
                .name(request.getName())
                .imageUrl(request.getImageUrl())
                .description(request.getDescription())
                .build();
        artistRepository.save(artist);
    }

    @Override
    public void update(Long id, ArtistRequest request) {
        Artist artist = findById(id);
        if (request.getName() != null) {
            artist.setName(request.getName());
        }

        if (request.getImageUrl() != null) {
            artist.setImageUrl(request.getImageUrl());
        }

        if (request.getDescription() != null) {
            artist.setDescription(request.getDescription());
        }

        artistRepository.save(artist);
    }

    @Override
    public PagedModel<ArtistResponse> findAll(ArtistFilterRequest request) {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        Pageable pageable = Pageable.unpaged(sort);
        if (!Boolean.TRUE.equals(request.getUnpaged())) {
            pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        }
        Page<Artist> result = artistRepository.findByNameContainsIgnoreCase(request.getSearchValue(), pageable);
        return new PagedModel<>(result.map(ArtistResponse::from));
    }

    @Override
    public ArtistResponse findOne(Long id) {
        Artist artist = findById(id);
        return ArtistResponse.from(artist);
    }

    @Override
    public void delete(Long id) {
        Artist artist = findById(id);
        artistRepository.delete(artist);
    }

    private Artist findById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new ApiException(CommonApiCode.NOT_FOUND));
    }
}
