package ru.sber.homeproject.CarRental.carrental.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sber.homeproject.CarRental.carrental.dto.RoleDTO;
import ru.sber.homeproject.CarRental.carrental.dto.UserDTO;
import ru.sber.homeproject.CarRental.carrental.mapper.UserMapper;
import ru.sber.homeproject.CarRental.carrental.model.User;
import ru.sber.homeproject.CarRental.carrental.repository.UserRepository;

import java.time.LocalDate;

@Service
public class UserService extends GenericService<User, UserDTO> {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    protected UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(userRepository, userMapper);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDTO getUserByLogin(final String login) {
        return genericMapper.toDTO(((UserRepository) genericRepository).findUserByLogin(login));
    }

    public UserDTO getUserByEmail(final String email) {
        return genericMapper.toDTO(((UserRepository) genericRepository).findUserByEmail(email));
    }
        @Override
        public UserDTO create(UserDTO userDTO) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(1L);
            userDTO.setRole(roleDTO);
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            return genericMapper.toDTO(genericRepository.save(genericMapper.toEntity(userDTO)));
        }
    }