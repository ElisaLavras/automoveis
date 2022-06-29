package com.example.demo.service;

import com.example.demo.exception.AutomovelExisteException;
import com.example.demo.model.Automovel;
import com.example.demo.repository.IAutomovelRepositoy;
import com.example.demo.service.impl.AutomoveisService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutomoveisServiceTest {
    @InjectMocks
    private AutomoveisService service;

    @Mock
    private IAutomovelRepositoy repositoy;

    private Automovel automovel1;

    private Automovel automovel2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        automovel1 = new Automovel();
        automovel1.setId(1);
        automovel1.setMarca("Ford");
        automovel1.setModelo("Ka");
        automovel1.setValor(45.00);
        automovel1.setDataCadastro(LocalDate.now());
    }

    @Test
    public void inserirTest(){
        Mockito.when(repositoy.findByModelo(automovel1.getModelo())).thenReturn(null);
        Mockito.when(repositoy.save(automovel1)).thenReturn(automovel1);
        Assert.assertTrue(service.inserir(automovel1));
    }

    @Test
    public void inserirErrorTest(){
        Mockito.when(repositoy.findByModelo(automovel1.getModelo())).thenReturn(automovel1);
        Mockito.when(repositoy.save(automovel1)).thenReturn(automovel1);
        Assert.assertThrows(AutomovelExisteException.class,() -> service.inserir(automovel1));
    }


    @Test
    public void getAutomoveisTest(){
        List<Automovel> automoveis = new ArrayList<>();
        automoveis.add(automovel1);

        Mockito.when(repositoy.findAll()).thenReturn(automoveis);
        List<Automovel> automoveisTested = service.getAutomoveis();
        Assert.assertEquals(automoveisTested,automoveis);
    }
}
