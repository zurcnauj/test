package com.test.testSpringboot.util;

import com.test.testSpringboot.exceptions.InvalidUserException;
import com.test.testSpringboot.models.entities.PhoneEntity;
import com.test.testSpringboot.models.entities.UserEntity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUserController {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void checkUserPost(UserEntity userEntity){
        if(
            userEntity.getEmail()== null || userEntity.getEmail().isEmpty() ||
            userEntity.getName()==null   || userEntity.getName().isEmpty()
        )
            throw new InvalidUserException(InvalidUserException.INVALID_FIELDS);
        Matcher matcher = PATTERN.matcher(userEntity.getEmail());
        if(!matcher.matches())
            throw new InvalidUserException(InvalidUserException.INVALID_EMAIL);
    }

    public static void checkPhoneList(List<PhoneEntity> phones){
        if(phones == null || phones.isEmpty())
            throw new InvalidUserException(InvalidUserException.INVALID_PHONES_LIST);
    }
    private CheckUserController(){}
}
