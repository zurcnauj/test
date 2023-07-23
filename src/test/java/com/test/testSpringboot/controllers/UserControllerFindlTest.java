package com.test.testSpringboot.controllers;

import com.google.gson.Gson;
import com.test.testSpringboot.__config.UserControllerTestConfig;
import com.test.testSpringboot.models.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.test.testSpringboot.__config.UserControllerTestConfig.USER_ENTITY;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(UserControllerTestConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerFindlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll_200() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/1")
            .header("Authorization", "token")
        )
        .andExpect(status().is(200)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
        UserEntity userEntity = new Gson().fromJson(responseBody,UserEntity.class);
        assertTrue(userEntity != null);
        assertTrue(USER_ENTITY.getId()==userEntity.getId());
        assertTrue(USER_ENTITY.getEmail().equals(userEntity.getEmail()));
    }
    @Test
    void getAll_204() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/2")
            .header("Authorization", "token")
        )
        .andExpect(status().is(204)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
    }
    @Test
    void getAll_401NoToken() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/1")
        )
        .andExpect(status().is(401)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
    }
    @Test
    void getAll_401InvalidToken() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/1")
            .header("Authorization", "pato")
        )
        .andExpect(status().is(401)).andReturn();
    }
}