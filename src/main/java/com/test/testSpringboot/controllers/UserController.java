package com.test.testSpringboot.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.test.testSpringboot.models.entities.PhoneEntity;
import com.test.testSpringboot.models.entities.UserEntity;
import com.test.testSpringboot.services.userServices.UserService;
import com.test.testSpringboot.util.CheckUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @JsonView(UserEntity.UserInfoBasic.class)
    public List<UserEntity> getAll(){

        return this.userService.findAll();
    }
    @GetMapping("/{user_id}")
    public UserEntity getUser(@PathVariable(name = "user_id") long userId){

        return this.userService.find(userId);
    }
    @PostMapping("/")
    @JsonView(UserEntity.UserInfoBasic.class)
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity postUser(@RequestBody UserEntity newUser){
        CheckUserController.checkUserPost(newUser);
        return this.userService.post(newUser);
    }
    @PutMapping("/{user_id}/phones")
    public  List<PhoneEntity> putUser(@PathVariable(name = "user_id") long userId, @RequestBody List<PhoneEntity> phones){
        CheckUserController.checkPhoneList(phones);
        return this.userService.put(userId,phones.stream().toList());
    }
}
