package com.develop.osahaneatbe.service.account;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.response.AccountInfoResponse;

public interface AccountService {

    List<AccountInfoResponse> getAllAccounts();

    AccountInfoResponse getAccountInfo(HttpServletRequest request);

    Map<String, String> uploadImage(MultipartFile file, String id) throws IOException;
}
