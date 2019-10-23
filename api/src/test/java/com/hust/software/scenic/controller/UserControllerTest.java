package com.hust.software.scenic.controller;

import com.hust.software.scenic.ScenicApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ScenicApplication.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void addUser() throws Exception {
        RequestBuilder request  = post("http://localhost:8004/user")
                .param("account","normal")
                .param("nickname","normal")
                .param("password","123456");
        MvcResult result =mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getStatus());
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getUser() throws Exception{
        RequestBuilder request = get("http://localhost:8004/login")
                .param("account","normal")
                .param("password","123456");
        MvcResult result = mockMvc.perform(request).andReturn();
        System.out.println(result.getResponse().getStatus());
        System.out.println(result.getResponse().getContentAsString());
    }
}