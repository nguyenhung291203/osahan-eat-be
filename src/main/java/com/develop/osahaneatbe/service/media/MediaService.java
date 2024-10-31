package com.develop.osahaneatbe.service.media;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface MediaService {
    String uploadImage(MultipartFile file) throws IOException;

    Resource loadImage(String fileName) throws MalformedURLException;
}
