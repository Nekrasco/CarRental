package ru.sber.homeproject.CarRental.carrental.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import ru.sber.homeproject.CarRental.carrental.service.userdetails.CustomUserDetailsService;

import java.util.Arrays;
import java.util.List;

import static ru.sber.homeproject.CarRental.carrental.constans.UserRolesConstants.ADMIN;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    private final List<String> RESOURCES_WHITE_LIST = List.of("/resources/**", "/js/**", "/css/**", "/");
    private final List<String> CARS_WHITE_LIST = List.of("/cars");
    private final List<String> CARS_PERMISSION_LIST = List.of("/films/add", "/films/update", "/films/delete");
    private final List<String> USERS_WHITE_LIST = List.of("/login", "/users/registration", "/users/remember-password", "/users/change-password");


    public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder,
                             CustomUserDetailsService customUserDetailsService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public HttpFirewall httpFirewall(){
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedPercent(true);
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
        firewall.setAllowedHttpMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
        return firewall;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                //настройка http запрос кому куда можно/нельзя
                .authorizeHttpRequests((request) -> request
                        .requestMatchers(RESOURCES_WHITE_LIST.toArray(String[]::new)).permitAll()
                        .requestMatchers(CARS_WHITE_LIST.toArray(String[]::new)).permitAll()
                        .requestMatchers(USERS_WHITE_LIST.toArray(String[]::new)).permitAll()
                        .requestMatchers(CARS_PERMISSION_LIST.toArray(String[]::new)).hasAnyRole(ADMIN)
                        .anyRequest().authenticated()
                )
                //настройка для входа в систему
                .formLogin((form) -> form
                        .loginPage("/login")
                        //перенаправление на главную страницу после успешной авторизации
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}

