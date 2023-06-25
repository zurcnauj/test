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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(UserControllerTestConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerGetAllTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll_200() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/")
            .header("Authorization", "token")
        )
        .andExpect(status().is(200)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
        List<UserEntity> list = new Gson().fromJson(responseBody,List.class);
        assertTrue(list != null);
        assertTrue(list.size() == 1);
    }

    @Test
    void getAll_401NoToken() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/")
        )
        .andExpect(status().is(401)).andReturn();
        String responseBody = result.getResponse().getContentAsString();
    }

    @Test
    void getAll_401InvalidToken() throws Exception  {
        MvcResult result = this.mockMvc.perform(
            get("/user/")
            .header("Authorization", "pato")
        )
        .andExpect(status().is(401)).andReturn();
    }
}