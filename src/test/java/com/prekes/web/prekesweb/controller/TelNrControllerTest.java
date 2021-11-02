package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.service.SaskaitaService;
import com.prekes.web.prekesweb.service.TelNrService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TelNrController.class)
public class TelNrControllerTest {
    @MockBean
    TelNrService telnrService;
    @MockBean
    SaskaitaService saskaitaService;
    @InjectMocks
    TelNrController telNrController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShowTelNrListView() throws Exception {
        List<TelNr> telnrList = new ArrayList<>();
        TelNr telnr1 = new TelNr(1, "+3701", 1);
        TelNr telnr2 = new TelNr(2, "+3702", 1);
        telnrList.add(telnr1);
        telnrList.add(telnr2);
        when(telnrService.findAll()).thenReturn(telnrList);
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/list-telnr")
                .accept(MediaType.TEXT_HTML);
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("list-telnr"))
                .andReturn();
    }

    @Test
    void showAddPage() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/add-telnr")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("telnr", new TelNr());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("telnr"));
    }

    @Test
    void testAdd() throws Exception {
        when(telnrService.add(Mockito.any(TelNr.class))).thenReturn(new TelNr(1, "+3701", 1));
        RequestBuilder rb = MockMvcRequestBuilders
                .post("/add-telnr")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("telNr", "+3701")
                .param("userId", "3")
                .flashAttr("telnr", new TelNr());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/list-telnr"));
        verify(telnrService).add(Mockito.any(TelNr.class));
    }

    @Test
    void testShowUpdatePage() throws Exception {
        when(telnrService.findById(Mockito.anyInt())).thenReturn(new TelNr(1, "+3701", 1));
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/update-telnr/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("telnr", new TelNr());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("telnr"));
    }

    @Test
    void testUpdate() throws Exception {
        when(telnrService.findById(Mockito.anyInt())).thenReturn(new TelNr(1, "+3701", 1));
        RequestBuilder rb = MockMvcRequestBuilders
                .post("/update-telnr/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("telNr", "+3701")
                .param("userId", "3")
                .flashAttr("telnr", new TelNr());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/list-telnr"));
        verify(telnrService).update(Mockito.any(TelNr.class));
    }

    @Test
    void testDeleteByTelNr() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/delete-telnr/0")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/list-telnr"));
        verify(telnrService).deleteById(Mockito.anyInt());
    }
}