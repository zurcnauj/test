package com.test.testSpringboot.services.userServices;

import com.test.testSpringboot.exceptions.InvalidUserException;
import com.test.testSpringboot.exceptions.NoContentException;
import com.test.testSpringboot.models.entities.PhoneEntity;
import com.test.testSpringboot.models.entities.UserEntity;
import com.test.testSpringboot.repositories.phones.PhoneRepository;
import com.test.testSpringboot.repositories.phones.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public UserEntity find(long userId) {
        UserEntity userEntity = this.userRepository.findById(userId);
        if(userEntity == null) throw new NoContentException("there is no user with that id:" + userId);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {

        return this.userRepository.findAll();
    }

    @Override
    public UserEntity post(UserEntity userEntity) {
        UserEntity toReturn;
        try {
            toReturn =  this.userRepository.save(userEntity);
            for(PhoneEntity phone : userEntity.getPhones()) phone.setUserId(userEntity.getId());
            this.phoneRepository.saveAll(userEntity.getPhones());
            return toReturn;
        }
        catch (DataIntegrityViolationException err){
            throw new InvalidUserException(InvalidUserException.INVALID_EMAIL_IN_USE);
        }
    }

    @Override
    public List<PhoneEntity> put(long userId,List<PhoneEntity> phones) {
        if(!this.userRepository.existsById(userId)){
            throw new InvalidUserException(InvalidUserException.USER_NOT_FOUND);
        }
        for(PhoneEntity phone : phones) phone.setUserId(userId);
        return this.phoneRepository.saveAll(phones);
    }
}
