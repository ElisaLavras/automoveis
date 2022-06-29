package com.example.demo.controller;

import com.example.demo.model.Automovel;
import com.example.demo.service.impl.AutomoveisService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutomoveisControllerTest {
    @InjectMocks
    private AutomoveisController controller;

    @Mock
    private AutomoveisService service;

    private Automovel automovel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        automovel = new Automovel();
        automovel.setId(1);
        automovel.setMarca("Ford");
        automovel.setModelo("Ka");
        automovel.setValor(45.00);
        automovel.setDataCadastro(LocalDate.now());
    }

    @Test
    public void inserirTest(){
        Mockito.when(service.inserir(automovel)).thenReturn(true);
        Assert.assertTrue(controller.inserir(automovel).hasBody());
    }

    @Test
    public void getAutomoveisTest(){
        List<Automovel> automoveis = new ArrayList<>();
        automoveis.add(automovel);

        Mockito.when(service.getAutomoveis()).thenReturn(automoveis);
        ResponseEntity<List<Automovel>> automoveisTested = controller.getAutomovel();
        Assert.assertEquals(automoveisTested.getBody(),automoveis);
    }


}
