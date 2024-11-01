package com.develop.osahaneatbe.service.account;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.constant.error.ProfileErrorCode;
import com.develop.osahaneatbe.dto.response.AccountInfoResponse;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Profile;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.mapper.AccountMapper;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.repository.ProfileRepository;
import com.develop.osahaneatbe.service.media.MediaService;
import com.develop.osahaneatbe.service.token.TokenService;
import com.develop.osahaneatbe.utils.SecurityUtils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    ProfileRepository profileRepository;
    AccountMapper accountMapper;
    MediaService mediaService;
    TokenService tokenService;

    private Profile getProfileById(String id) {
        return profileRepository.findById(id).orElseThrow(() -> new ApiException(ProfileErrorCode.PROFILE_NOT_FOUND));
    }

    @Override
    public List<AccountInfoResponse> getAllAccounts() {
        return List.of();
    }

    @Override
    public AccountInfoResponse getAccountInfo(HttpServletRequest request) {
        Account account = SecurityUtils.getAccount();
        if (account == null) {
            throw new ApiException(AccountErrorCode.ACCOUNT_NOT_EXISTED);
        }
        Profile profile = getProfileById(account.getId());
        return accountMapper.toAccountInfoResponse(account, profile);
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile file, String id) throws IOException {
        Profile profile = getProfileById(id);
        String avatar = profile.getAvatar();
        if (avatar != null) {
            mediaService.deleteImage(avatar);
        }
        String fileName = mediaService.uploadImage(file);
        profile.setAvatar(fileName);
        profileRepository.save(profile);
        return Map.of();
    }
}
