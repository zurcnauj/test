package com.test.testSpringboot.services.userServices;

import com.test.testSpringboot.models.entities.PhoneEntity;
import com.test.testSpringboot.models.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity find(long userId);
    List<UserEntity> findAll();

    UserEntity post(UserEntity userEntity);

    List<PhoneEntity> put(long userId,List<PhoneEntity> phones);

}
