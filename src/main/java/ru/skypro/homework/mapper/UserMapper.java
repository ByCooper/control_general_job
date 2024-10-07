package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.RegisterDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.model.User;

@Mapper
public interface UserMapper {
    User registretDTOToUser(RegisterDTO registerDTO);
    User newPasswordToUser(NewPasswordDTO newPasswordDTO);
    User updateUserDTOToUser(UpdateUserDTO updateUserDTO);
    UpdateUserDTO userToUpdateUserDTO(User user);

}
