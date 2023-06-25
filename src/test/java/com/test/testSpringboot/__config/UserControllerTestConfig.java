package com.test.testSpringboot.__config;

import com.test.testSpringboot.exceptions.InvalidUserException;
import com.test.testSpringboot.exceptions.NoContentException;
import com.test.testSpringboot.models.entities.PhoneEntity;
import com.test.testSpringboot.models.entities.UserEntity;
import com.test.testSpringboot.services.userServices.UserService;
import com.test.testSpringboot.util.JwtUtils;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestConfiguration
public class UserControllerTestConfig {

    public static final List<UserEntity> LIST = new ArrayList<>();
    public static final UserEntity USER_ENTITY =new UserEntity("Juan", "algo@asdf.com","pass");
    public static final UserEntity USER_ENTITY_REPEAT_EMAiL =new UserEntity("Juan", "repetido@asdf.com","pass");
    public static final UserEntity USER_ENTITY_INVALID_EMAIL =new UserEntity("Juan", "algoasdf.com","pass");

    public static final List<PhoneEntity> LIST_PHONES = new ArrayList<>();
    public static final String TOKEN_VALID = "token";
    public static final String TOKEN_INVALID = "pato";
   static {
       LIST.add(USER_ENTITY);

       LIST_PHONES.add(new PhoneEntity("54","011","30236523"));
       USER_ENTITY.setPhones(LIST_PHONES);
   }

    @Bean
    @Primary
    public JwtUtils getJwtUtils(){
        JwtUtils jwtUtils = mock(JwtUtils.class);
        when(jwtUtils.generateToken()).thenReturn(TOKEN_VALID);

        when(jwtUtils.validateToken(TOKEN_VALID)).thenReturn(true);

        when(jwtUtils.validateToken(TOKEN_INVALID)).thenReturn(false);
        return jwtUtils;
    }

    @Bean
    @Primary
    public UserService getUserService(){
        UserService userService = mock(UserService.class);

        when(userService.findAll()).thenReturn(LIST);
        when(userService.find(1)).thenReturn(USER_ENTITY);
        when(userService.find(2)).thenThrow(new NoContentException(""));
        when(userService.post(argThat(
                userEntity -> userEntity.getEmail().equals(USER_ENTITY.getEmail())
        ))).thenReturn(USER_ENTITY);

        return userService;
    }
}
