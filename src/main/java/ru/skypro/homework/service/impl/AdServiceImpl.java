package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    final private UserRepository userRepository;
    final private AdRepository adRepository;
    final private AdsMapper adsMapper;

    @Override
    public AdsDTO getAllAds(Authentication authentication) {
        return adsMapper.AdToAdsDTO(adRepository.findAll());
    }

    @Override
    public Ad getCreateAd(CreateOrUpdateAdDTO property, MultipartFile image, Authentication authentication) {
        return null;
    }

    @Override
    public Ad getInfoAboutAd(Integer id, Authentication authentication) {
        Long ids = Long.valueOf(id);
        return adRepository.findAdById(ids);
    }

    @Override
    public void getDeleteAd(Integer id, Authentication authentication) {
        adRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Ad getUpdateInfoAd(Integer id, CreateOrUpdateAdDTO ad, Authentication authentication) {
        return null;
    }

    @Override
    public AdsDTO getAllMyAds(Authentication authentication) {
        User user = userRepository.findUserByUsernameIgnoreCase(authentication.getName());
        List<Ad> list = adRepository.findAdByUserId(user.getId());
        return adsMapper.AdToAdsDTO(list);
    }
}
