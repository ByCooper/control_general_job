package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.model.User;

public interface UserService {
    void getChangePassword(NewPasswordDTO newPasswordDTO, Authentication authentication);
    User getInfoAboutUser(Authentication authentication);
    UpdateUserDTO getUpdateInfoAboutUser(UpdateUserDTO updateUserDTO, Authentication authentication);
}
