package com.flafortune.eventapp.event;

import com.flafortune.eventapp.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@Sql("/insert_events.sql")
class EventControllerTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getEvents() {
    }

    @Test
    void eventsAreProperlyFetched() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/events")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("event 1"));
    }

    @Test
    void eventsAreProperlyFoundById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("event 1"));
    }

    @Test
    void notFoundEventReturn404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/{id}", 999).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("The specified resource could not be found."));
    }

    @Test
    void eventsAreProperlyCreated() throws Exception {

        Event eventRequest = new Event();
        eventRequest.setName("Created event");
        eventRequest.setDescription("Created event");
        eventRequest.setBeginTimestamp(Instant.parse("2024-01-01T16:00:00Z").getEpochSecond());
        eventRequest.setEndTimestamp(Instant.parse("2024-01-01T18:00:00Z").getEpochSecond());

        String json = new ObjectMapper().writeValueAsString(eventRequest);


        mockMvc.perform(MockMvcRequestBuilders.post("/events")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void eventAreValidated() throws Exception {

        String request = "{" +
                "\"id\":null," +
                "\"name\":\"  \"," +
                "\"endTimestamp\":1704132000" +
                "}";


        mockMvc.perform(MockMvcRequestBuilders.post("/events")
                        .content(request)
                        .content(request)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors", hasSize(3)))
                .andExpect(jsonPath("$.errors", hasItem("Description is required.")))
                .andExpect(jsonPath("$.errors", hasItem("Name is required.")))
                .andExpect(jsonPath("$.errors", hasItem("Begin timestamp is required.")));

    }

}