package com.develop.osahaneatbe.controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.response.AccountInfoResponse;
import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.service.account.AccountService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("${api.prefix}/accounts")
@RequiredArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;

    @PostMapping("/upload-image/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> uploadImage(
            @RequestParam("file") MultipartFile file, @PathVariable @Valid String id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(accountService.uploadImage(file, id)));
    }

    @GetMapping("/me")
    ResponseEntity<ApiResponse<AccountInfoResponse>> getAccountInfo(HttpServletRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(accountService.getAccountInfo(request)));
    }
}
