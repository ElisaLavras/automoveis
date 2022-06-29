package com.example.demo.controller;

import com.example.demo.exception.AutomovelExisteException;
import lombok.AllArgsConstructor;
import com.example.demo.model.Automovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.IAutomoveisService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AutomoveisController {
    @Autowired
    private IAutomoveisService service;

    @PostMapping("/automovel")
    @ExceptionHandler(value = AutomovelExisteException.class)
    public ResponseEntity inserir(@RequestBody Automovel automovel){
        return new ResponseEntity<>(service.inserir(automovel), HttpStatus.CREATED);
    }

    @GetMapping("/automoveis")
    public ResponseEntity<List<Automovel>> getAutomovel(){
        return new ResponseEntity<>(service.getAutomoveis(), HttpStatus.OK);
    }
}
