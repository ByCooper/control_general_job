package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class ExtendedAdDTO {
    private Integer pk; //id объявления
    private String authorFirstName;
    private String authorLastName;
    private String description; //описание объявления
    private String email; //логин автора объявления
    private String image; //ссылка на картинку объявления
    private String phone;
    private int price;
    private String title; //заголовок объявления
}
