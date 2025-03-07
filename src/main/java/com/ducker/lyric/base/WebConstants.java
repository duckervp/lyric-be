package com.ducker.lyric.base;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WebConstants {
    public static final String API_BASE_PREFIX_V1 = "/api/v1";
    public static final String API_AUTH_PREFIX_V1 = API_BASE_PREFIX_V1 + "/auth";
    public static final String API_USER_PREFIX_V1 = API_BASE_PREFIX_V1 + "/user";
    public static final String API_SONG_PREFIX_V1 = API_BASE_PREFIX_V1 + "/song";
    public static final String API_ARTIST_PREFIX_V1 = API_BASE_PREFIX_V1 + "/artist";
    public static final String API_FILE_PREFIX_V1 = API_BASE_PREFIX_V1 + "/file";


    public static final String UPLOADED_FILE_PREFIX = "/uploads";
}
