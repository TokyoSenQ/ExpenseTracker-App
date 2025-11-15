package jeka.tsen.ExpenseTracker.service.User;

import jeka.tsen.ExpenseTracker.dto.User.UserRequestDTO;
import jeka.tsen.ExpenseTracker.dto.User.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserResponseDTO getUserById(UUID id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO createUser(UserRequestDTO dto);
    void deleteUser(UUID id);
}
