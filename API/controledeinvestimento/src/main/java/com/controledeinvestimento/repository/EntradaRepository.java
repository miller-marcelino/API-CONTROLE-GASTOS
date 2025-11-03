package com.controledeinvestimento.repository;

import com.controledeinvestimento.domain.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    List<Entrada> findByMes(Integer mes);
    List<Entrada> findByAno(Integer ano);
    List<Entrada> findByValor(java.math.BigDecimal valor);
    List<Entrada> findByMesAndAno(Integer mes, Integer ano);
}
