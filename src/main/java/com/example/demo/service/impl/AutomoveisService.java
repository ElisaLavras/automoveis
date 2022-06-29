package com.example.demo.service.impl;

import com.example.demo.exception.AutomovelExisteException;
import lombok.AllArgsConstructor;
import com.example.demo.model.Automovel;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.IAutomovelRepositoy;
import com.example.demo.service.IAutomoveisService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutomoveisService implements IAutomoveisService {

    @Autowired
    private IAutomovelRepositoy repositoy;
    @Override
    public Boolean inserir(Automovel automovel) {
        if(Optional.ofNullable(repositoy.findByModelo(automovel.getModelo())).isPresent())
            throw new AutomovelExisteException(automovel.getModelo()+" ja está cadastrado.");
        repositoy.save(automovel);
        return true;
    }

    @Override
    public List<Automovel> getAutomoveis() {
        return repositoy.findAll();
    }
}
