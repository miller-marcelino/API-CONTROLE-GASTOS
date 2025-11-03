package com.controledeinvestimento.repository;

import com.controledeinvestimento.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByReferenciaContainingIgnoreCaseOrFornecedorContainingIgnoreCase(String r, String f);
}
