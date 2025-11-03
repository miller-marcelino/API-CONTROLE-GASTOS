package com.controledeinvestimento.service;

import com.controledeinvestimento.domain.Fornecedor;
import com.controledeinvestimento.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    private final FornecedorRepository repo;

    public FornecedorService(FornecedorRepository repo) { this.repo = repo; }

    public Fornecedor salvar(Fornecedor f){
        return repo.save(f);
    }

    public List<Fornecedor> listar(String q){
        if(q == null || q.isBlank()) return repo.findAll();
        return repo.findByNomeContainingIgnoreCaseOrCnpjContainingIgnoreCaseOrTelefoneContainingIgnoreCase(q, q, q);
    }
}
