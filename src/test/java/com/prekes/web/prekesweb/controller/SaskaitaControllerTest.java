package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Saskaita;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = SaskaitaController.class)
public class SaskaitaControllerTest {
    @MockBean
    SaskaitaService saskaitaService;
    @MockBean
    TelNrService telNrService;
    @InjectMocks
    SaskaitaController saskaitaController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShowSaskaitaListView() throws Exception {
        List<Saskaita> saskaitaList = new ArrayList<>();
        Saskaita saskaita1 = new Saskaita(1, 1, 3, BigDecimal.TEN);
        Saskaita saskaita2 = new Saskaita(2, 2, 5, BigDecimal.TEN);
        saskaitaList.add(saskaita1);
        saskaitaList.add(saskaita2);
        TelNr telNr1 = new TelNr(1, "+3700", 1);
        TelNr telNr2 = new TelNr(2, "+3701", 5);
        when(saskaitaService.findAll()).thenReturn(saskaitaList);
        when(telNrService.findById(Mockito.anyInt())).thenReturn(telNr1).thenReturn(telNr2);
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/list-saskaita")
                .accept(MediaType.TEXT_HTML);
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("list-saskaita"))
                .andReturn();
    }

    @Test
    void showAddPage() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/add-saskaita")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("saskaita", new Saskaita());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("saskaita"));
    }

    @Test
    void testAdd() throws Exception {
        when(saskaitaService.add(Mockito.any(Saskaita.class))).thenReturn(new Saskaita(1, 1, 3, BigDecimal.TEN));
        RequestBuilder rb = MockMvcRequestBuilders
                .post("/add-saskaita")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("telNrId", "1")
                .param("menuo", "3")
                .param("suma", "10")
                .flashAttr("saskaita", new Saskaita());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/list-saskaita"));
        verify(saskaitaService).add(Mockito.any(Saskaita.class));
    }

    @Test
    void testShowUpdatePage() throws Exception {
        when(saskaitaService.findById(Mockito.anyInt())).thenReturn(new Saskaita(1, 1, 3, BigDecimal.TEN));
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/update-saskaita/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .flashAttr("saskaita", new Saskaita());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("saskaita"));
    }

    @Test
    void testUpdate() throws Exception {
        when(saskaitaService.findById(Mockito.anyInt())).thenReturn(new Saskaita(1, 1, 3, BigDecimal.TEN));
        RequestBuilder rb = MockMvcRequestBuilders
                .post("/update-saskaita/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("telNrId", "1")
                .param("menuo", "3")
                .param("suma", "10")
                .flashAttr("saskaita", new Saskaita());
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/list-saskaita"));
        verify(saskaitaService).update(Mockito.any(Saskaita.class));
    }

    @Test
    void testDeleteByTelNr() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders
                .get("/delete-saskaita/0")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/list-saskaita"));
        verify(saskaitaService).deleteByTelNr(Mockito.anyInt());
    }
}