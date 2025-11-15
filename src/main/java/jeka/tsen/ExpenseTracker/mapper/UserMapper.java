package jeka.tsen.ExpenseTracker.mapper;

import jeka.tsen.ExpenseTracker.dto.User.UserRequestDTO;
import jeka.tsen.ExpenseTracker.dto.User.UserResponseDTO;
import jeka.tsen.ExpenseTracker.model.User;

public class UserMapper {

    public static User fromDto(UserRequestDTO dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static UserResponseDTO toDto (User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
