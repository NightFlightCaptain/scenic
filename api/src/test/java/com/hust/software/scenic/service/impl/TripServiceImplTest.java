package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.ScenicApplication;
import com.hust.software.scenic.service.TripService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = ScenicApplication.class)
@AutoConfigureMockMvc
class TripServiceImplTest {

    @Autowired
    private TripService tripService;
    @Test
    void addMainTrip() {

    }

    @Test
    void getMainTrip() {
        System.out.println(tripService.getMainTrip(1));
    }
}