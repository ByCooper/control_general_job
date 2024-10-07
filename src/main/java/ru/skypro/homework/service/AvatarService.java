package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {
    String updateAvatar(MultipartFile avatar, Authentication authentication);
}
