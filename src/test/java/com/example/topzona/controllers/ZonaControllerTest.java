package com.example.topzona.controllers;

import com.example.topzona.TestTopZonaApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.topzona.controllers.ZonaController.API_REQUISITES;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = TestTopZonaApplication.class)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class ZonaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Find Requisites")
    void findRequisitesByName() throws Exception {
        String json = "[{\"id\":\"27065ac3-5968-4802-be9f-e5323d2144c9\",\"state\":\"Москва\",\"region\":\"Москва\",\"city\":\"Москва\",\"address\":\"ул. Матросская Тишина, 18\",\"name\":\"СИЗО № 1\"}]";

        this.mockMvc.perform(get("/zona" + API_REQUISITES + "/name"))
                .andExpectAll(
                        status().isOk(),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        content().json(json));

    }
}