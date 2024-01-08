package com.nace.excercise.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nace.excercise.dto.NaceDataDto;
import com.nace.excercise.repository.NaceDataRepository;
import com.nace.excercise.service.NaceDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NaceController naceController;

    @Autowired
    private NaceDataService naceDataService;

    @Autowired
    private NaceDataRepository naceDataRepository;

    @BeforeEach
    void setUp() {
        naceDataRepository.deleteAll();
    }

    @Test
    void createShouldReturn() throws Exception {

        MvcResult result = mockMvc.perform(post("/nace/create")

                        .content(asJsonString(getRequest()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.parent").value("Parent"))
                .andReturn();
    }

    @Test
    void orderNumberShouldRetrieve() throws Exception {

        NaceDataDto request = getRequest();
        request.setOrderNumber(5678L);
        final String body = asJsonString(request);

        mockMvc.perform(post("/nace/create")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.parent").value("Parent"));


        mockMvc.perform(get("/nace/get/5678")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parent").value("Parent"));
    }

    @Test
    void createshouldFailIfNotValid() throws Exception {
        NaceDataDto request = getRequest();
        request.setCode(null);

        String body = asJsonString(request);

       mockMvc.perform(post("/nace/create")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("mandatory")))
                .andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private NaceDataDto getRequest() {
        NaceDataDto dto = new NaceDataDto();
        dto.setCode("647687");
        dto.setRulings("Rulings");
        dto.setLevel("Level");
        dto.setParent("Parent");
        dto.setOrderNumber(2435678L);
        dto.setThisItemAlsoIncludes("This also include");
        dto.setThisItemExcludes("This Exclude ...");
        dto.setThisItemIncludes("This Include ...");
        dto.setDescription("Description");
        dto.setReferenceTpIsicRev4("RefeToIsic");

        return dto;
    }

}
