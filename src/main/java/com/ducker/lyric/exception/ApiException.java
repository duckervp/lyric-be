package com.ducker.lyric.exception;

import com.ducker.lyric.base.ApiCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class ApiException extends RuntimeException {

    private final ApiCode errorCode;

    public ApiException(ApiCode errorCode) {
        this.errorCode = errorCode;
    }

}
