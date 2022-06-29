package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "AUTOMOVEL")
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name= "MARCA", length = 100, nullable = false)
    private String marca;

    @Column(name= "MODELO", length = 100, nullable = false)
    private String modelo;

    @Column(name= "VALOR")
    private Double valor;

    @Column(name= "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;
}
