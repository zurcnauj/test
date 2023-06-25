package com.test.testSpringboot.controllers;

import com.google.gson.Gson;
import com.test.testSpringboot.__config.UserControllerTestConfig;
import com.test.testSpringboot.models.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(UserControllerTestConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerPostUserTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll_200() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            post("/user/")
            .header("Authorization", "token")
            .content(new Gson().toJson(UserControllerTestConfig.USER_ENTITY))
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is(201)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
        UserEntity userEntity = new Gson().fromJson(responseBody,UserEntity.class);
    }

    @Test
    void getAll_400InvalidEmail() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            post("/user/")
            .header("Authorization", "token")
            .content(new Gson().toJson(UserControllerTestConfig.USER_ENTITY_INVALID_EMAIL))
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is(400)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
        UserEntity userEntity = new Gson().fromJson(responseBody,UserEntity.class);
    }
    @Test
    void getAll_401NoToken() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            post("/user/")
            .content(new Gson().toJson(UserControllerTestConfig.USER_ENTITY))
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is(401)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
    }

    @Test
    void getAll_401InvalidToken() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            post("/user/")
            .header("Authorization", "pato")
            .content(new Gson().toJson(UserControllerTestConfig.USER_ENTITY))
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is(401)).andReturn();
    }
}