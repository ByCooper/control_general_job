package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.model.User;
import ru.skypro.homework.service.AvatarService;
import ru.skypro.homework.service.UserService;

import java.io.IOException;

@RestController
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final AvatarService avatarService;

    @PostMapping(path = "/set_password")
    public ResponseEntity<?> getChangePassword(@RequestBody NewPasswordDTO newPasswordDTO, Authentication authentication) {
        userService.getChangePassword(newPasswordDTO, authentication);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/me")
    public ResponseEntity<User> getInfoAboutUser(Authentication authentication) {
        User user = userService.getInfoAboutUser(authentication);
        return ResponseEntity.ok(user);
    }


    @PatchMapping(path = "/me")
    public ResponseEntity<UpdateUserDTO> getUpdateInfoAboutUser(@RequestBody UpdateUserDTO updateUserDTO, Authentication authentication) {
        UpdateUserDTO user = userService.getUpdateInfoAboutUser(updateUserDTO, authentication);
        return ResponseEntity.ok(user);
    }

    @PatchMapping(path = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadUserImage(@RequestBody MultipartFile avatar, Authentication authentication) throws IOException {
        avatarService.updateAvatar(avatar, authentication);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
