package jeka.tsen.ExpenseTracker.service.User;

import jeka.tsen.ExpenseTracker.dto.UserRequestDTO;
import jeka.tsen.ExpenseTracker.dto.UserResponseDTO;
import jeka.tsen.ExpenseTracker.exception.ResourceNotFoundException;
import jeka.tsen.ExpenseTracker.mapper.UserMapper;
import jeka.tsen.ExpenseTracker.model.User;
import jeka.tsen.ExpenseTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found" +id));
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = UserMapper.fromDto(dto);
        User userSaved = userRepository.save(user);
        return UserMapper.toDto(userSaved);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
