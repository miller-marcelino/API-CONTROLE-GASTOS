package com.controledeinvestimento.service;

import com.controledeinvestimento.domain.Entrada;
import com.controledeinvestimento.repository.EntradaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EntradaService {
    private final EntradaRepository repo;

    public EntradaService(EntradaRepository repo) { this.repo = repo; }

    public Entrada salvar(Entrada e){
        return repo.save(e);
    }

    public List<Entrada> listar(Integer mes, Integer ano, BigDecimal valor){
        if(mes != null && ano != null && valor == null){
            return repo.findByMesAndAno(mes, ano);
        }
        if(mes != null && ano == null && valor == null){
            return repo.findByMes(mes);
        }
        if(mes == null && ano != null && valor == null){
            return repo.findByAno(ano);
        }
        if(valor != null && mes == null && ano == null){
            return repo.findByValor(valor);
        }
        return repo.findAll();
    }
}
