package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.model.Ad;

import java.util.List;

@Mapper
public interface AdsMapper {
    Ad createOrUpdateAdDTOToAd(CreateOrUpdateAdDTO createOrUpdateAdDTO);
    AdsDTO AdToAdsDTO(List<Ad> ads);
}
