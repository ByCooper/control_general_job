package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.service.AvatarService;

public class AvatarServiceImpl implements AvatarService {
    @Override
    public String updateAvatar(MultipartFile avatar, Authentication authentication) {
        return "";
    }
}
