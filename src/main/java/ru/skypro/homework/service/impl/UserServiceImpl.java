package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public void getChangePassword(NewPasswordDTO newPasswordDTO, Authentication authentication) {
        User user = userRepository.findUserByUsernameIgnoreCase(authentication.getName());
        user = userMapper.newPasswordToUser(newPasswordDTO);
        userRepository.save(user);
    }

    @Override
    public User getInfoAboutUser(Authentication authentication) {
        return userRepository.findUserByUsernameIgnoreCase(authentication.getName());
    }

    @Override
    public UpdateUserDTO getUpdateInfoAboutUser(UpdateUserDTO updateUserDTO, Authentication authentication) {
        User user = userRepository.findUserByUsernameIgnoreCase(authentication.getName());
        user = userMapper.updateUserDTOToUser(updateUserDTO);
        userRepository.save(user);
        return userMapper.userToUpdateUserDTO(user);
    }
}
