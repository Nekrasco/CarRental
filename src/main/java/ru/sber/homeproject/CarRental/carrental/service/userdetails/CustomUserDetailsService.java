package ru.sber.homeproject.CarRental.carrental.service.userdetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sber.homeproject.CarRental.carrental.constans.UserRolesConstants;
import ru.sber.homeproject.CarRental.carrental.model.User;
import ru.sber.homeproject.CarRental.carrental.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class  CustomUserDetailsService
        implements UserDetailsService {

    @Value("${spring.security.user.name}")
    private String adminUserName;

    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Value("${spring.security.user.roles}")
    private String adminRole;

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals(adminUserName)) {
            return new CustomUserDetails(null, username, adminPassword, List.of(new SimpleGrantedAuthority("ROLE_" + adminRole)));
        } else {

            User user = userRepository.findUserByLogin(username);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getId() == 1L ? "ROLE_" + UserRolesConstants.USER :
                    "ROLE_" + UserRolesConstants.ADMIN));
            return new CustomUserDetails(user.getId().intValue(), username, user.getPassword(), authorities);
        }
    }
}

