package com.ducker.lyric.rest;

import com.ducker.lyric.base.WebConstants;
import com.ducker.lyric.dto.request.SongFilterRequest;
import com.ducker.lyric.dto.request.SongRequest;
import com.ducker.lyric.dto.response.SongResponse;
import com.ducker.lyric.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(WebConstants.API_ARTIST_PREFIX_V1)
@RequiredArgsConstructor
public class ArtistController {
    private final SongService songService;

    @GetMapping
    public ResponseEntity<PagedModel<SongResponse>> findAll(SongFilterRequest request) {
        return ResponseEntity.ok(songService.findAll(request));
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody SongRequest request) {
        songService.save(request);
        return ResponseEntity.ok("song added successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody SongRequest request) {
        songService.update(id, request);
        return ResponseEntity.ok("song updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.ok("song deleted successfully");
    }
}
