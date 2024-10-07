package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.model.Ad;

public interface AdService {
    AdsDTO getAllAds(Authentication authentication);
    Ad getCreateAd(CreateOrUpdateAdDTO property, MultipartFile image, Authentication authentication);
    Ad getInfoAboutAd(Integer id, Authentication authentication);
    void getDeleteAd(Integer id, Authentication authentication);
    Ad getUpdateInfoAd(Integer id, CreateOrUpdateAdDTO ad, Authentication authentication);
    AdsDTO getAllMyAds(Authentication authentication);


}
