package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.service.SaskaitaService;
import com.prekes.web.prekesweb.service.TelNrService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TelNrRestController.class)
public class TelNrRestControllerTest {
    @MockBean
    TelNrService telnrService;
    @MockBean
    SaskaitaService saskaitaService;
    @InjectMocks
    TelNrController telNrController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testTelNrAllJson() throws Exception {
        List<TelNr> telnrList = new ArrayList<>();
        TelNr telnr1 = new TelNr(1, "+3701", 1);
        TelNr telnr2 = new TelNr(2, "+3702", 1);
        telnrList.add(telnr1);
        telnrList.add(telnr2);
        when(telnrService.findAll()).thenReturn(telnrList);
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/numbers")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String expected = "["
                + "{\"id\":1,\"telNr\":\"+3701\",\"userId\":1},"
                + "{\"id\":2,\"telNr\":\"+3702\",\"userId\":1}"
                + "]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    void testTelNrById() throws Exception {
        TelNr telNr = new TelNr(1, "3701", 1);
        when(telnrService.findById(telNr.getId())).thenReturn(telNr);
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/numbers/" + telNr.getId())
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String expected = "{\"id\":1,\"telNr\":\"3701\",\"userId\":1}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    void testAddTelNr() throws Exception {
        TelNr telNr = new TelNr(1, "+3701", 1);
        when(telnrService.add(Mockito.any(TelNr.class))).thenReturn(telNr);
        String telNrJson = "{\"id\":1,\"telNr\":\"3701\",\"userId\":1}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/numbers")
                .accept(MediaType.APPLICATION_JSON)
                .content(telNrJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals("http://localhost/numbers/" + telNr.getId(), response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    void testDeleteTelNrById() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/numbers/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}