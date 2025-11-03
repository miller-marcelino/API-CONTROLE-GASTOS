package com.controledeinvestimento.service;

import com.controledeinvestimento.domain.Despesa;
import com.controledeinvestimento.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {
    private final DespesaRepository repo;

    public DespesaService(DespesaRepository repo) { this.repo = repo; }

    public Despesa salvar(Despesa d){
        return repo.save(d);
    }

    public List<Despesa> listar(String q){
        if(q == null || q.isBlank()) return repo.findAll();
        return repo.findByReferenciaContainingIgnoreCaseOrFornecedorContainingIgnoreCase(q, q);
    }
}
