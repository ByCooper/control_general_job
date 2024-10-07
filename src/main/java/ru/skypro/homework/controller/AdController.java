package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;

@RestController
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("ads")
public class AdController {

    private final AdService adService;
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<AdsDTO> getAllAds(Authentication authentication) {
        AdsDTO ads = adService.getAllAds(authentication);
        return ResponseEntity.ok(ads);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ad> getCreateAd(@RequestBody CreateOrUpdateAdDTO property, @RequestBody MultipartFile image, Authentication authentication) throws IOException {
        Ad ad = adService.getCreateAd(property, image, authentication);
        return ResponseEntity.ok(ad);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Ad> getInfoAboutAd(@PathVariable Integer id, Authentication authentication) {
        return ResponseEntity.ok(adService.getInfoAboutAd(id, authentication));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> getDeleteAd(@PathVariable Integer id, Authentication authentication) {
        adService.getDeleteAd(id, authentication);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Ad> getUpdateInfoAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAdDTO propertyAdDTO, Authentication authentication) {
        Ad ad = adService.getUpdateInfoAd(id, propertyAdDTO, authentication);
        return ResponseEntity.ok(ad);
    }

    @GetMapping(path = "/me")
    public ResponseEntity<AdsDTO> getAllMyAds(Authentication authentication) {
        return ResponseEntity.ok(adService.getAllMyAds(authentication));
    }

    @PatchMapping(path = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getUpdateImageAd(@PathVariable Integer id, @RequestBody MultipartFile image, Authentication authentication) {
        return ResponseEntity.ok(imageService.addImage(id, image, authentication));
    }
}
