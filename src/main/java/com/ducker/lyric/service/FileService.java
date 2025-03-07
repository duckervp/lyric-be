package com.ducker.lyric.service;

import com.ducker.lyric.dto.response.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileUploadResponse uploadFile(MultipartFile file);

    void deleteFile(String url);
}
