package com.controledeinvestimento.repository;

import com.controledeinvestimento.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findByNomeContainingIgnoreCaseOrCnpjContainingIgnoreCaseOrTelefoneContainingIgnoreCase(String n, String c, String t);
}
