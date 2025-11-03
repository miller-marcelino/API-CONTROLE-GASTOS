package com.controledeinvestimento.controller;

import com.controledeinvestimento.domain.Despesa;
import com.controledeinvestimento.service.DespesaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/despesas")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) { this.service = service; }

    @GetMapping
    public List<Despesa> listar(@RequestParam(value = "q", required = false) String q){
        return service.listar(q);
    }

    @PostMapping
    public ResponseEntity<Despesa> criar(@Valid @RequestBody Despesa d){
        Despesa salvo = service.salvar(d);
        return ResponseEntity.created(URI.create("/api/despesas/" + salvo.getId())).body(salvo);
    }
}
