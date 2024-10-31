package com.develop.osahaneatbe.service.media;

import com.develop.osahaneatbe.constant.code.MediaConstant;
import com.develop.osahaneatbe.constant.error.MediaErrorCode;
import com.develop.osahaneatbe.constant.message.MediaErrorMessage;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MediaServiceImpl implements MediaService {
    @Value("${upload.max-file-size}")
    Long maxFileSize;
    @Value("${upload.path}")
    String uploadPath;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            Map<String, String> error = Map.of("file", MediaErrorMessage.IMAGE_EMPTY);
            throw new ValidateException(error);
        }
        String contentType = file.getContentType();
        if (contentType == null || !MediaConstant.SUPPORTED_IMAGE_FORMATS.contains(contentType)) {
            Map<String, String> error = Map.of("file", MediaErrorMessage.INVALID_IMAGE_FORMAT);
            throw new ValidateException(error);
        }

        if (file.getSize() > maxFileSize) {
            Map<String, String> error = Map.of("file", MediaErrorMessage.IMAGE_TOO_LARGE);
            throw new ValidateException(error);
        }

        Path uploadDir = Paths.get(uploadPath);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = uploadDir.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        return fileName;
    }

    @Override
    public Resource loadImage(String fileName) throws MalformedURLException {
        Path filePath = Paths.get(uploadPath).resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        }
        throw new ApiException(MediaErrorCode.IMAGE_LOAD_FAILED);

    }
}
