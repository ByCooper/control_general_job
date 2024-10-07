package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String addImage(Integer id, MultipartFile image, Authentication authentication);
}
