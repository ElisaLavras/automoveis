package com.example.demo.repository;

import com.example.demo.model.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutomovelRepositoy extends JpaRepository<Automovel,Integer> {
    Automovel findByModelo(String modelo);
}
