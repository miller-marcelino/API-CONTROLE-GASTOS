package com.controledeinvestimento.controller;

import com.controledeinvestimento.domain.Fornecedor;
import com.controledeinvestimento.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fornecedor> listar(@RequestParam(value = "q", required = false) String q){
        return service.listar(q);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criar(@Valid @RequestBody Fornecedor f){
        Fornecedor salvo = service.salvar(f);
        return ResponseEntity.created(URI.create("/api/fornecedores/" + salvo.getId())).body(salvo);
    }
}
