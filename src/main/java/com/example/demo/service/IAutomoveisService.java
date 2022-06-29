package com.example.demo.service;

import com.example.demo.model.Automovel;

import java.util.List;

public interface IAutomoveisService {
    Boolean inserir(Automovel automovel);
    List<Automovel> getAutomoveis();
}
