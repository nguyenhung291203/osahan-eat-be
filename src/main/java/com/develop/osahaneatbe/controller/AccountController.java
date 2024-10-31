package com.develop.osahaneatbe.controller;

import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.service.account.AccountService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/accounts")
@RequiredArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;
    @PostMapping("/upload-image/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable @Valid String id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.ok(accountService.uploadImage(file, id)));
    }
}
