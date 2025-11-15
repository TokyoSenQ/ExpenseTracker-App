package jeka.tsen.ExpenseTracker.service.User;

import jeka.tsen.ExpenseTracker.dto.UserRequestDTO;
import jeka.tsen.ExpenseTracker.dto.UserResponseDTO;
import jeka.tsen.ExpenseTracker.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserResponseDTO getUserById(UUID id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO createUser(UserRequestDTO dto);
    void deleteUser(UUID id);
}
