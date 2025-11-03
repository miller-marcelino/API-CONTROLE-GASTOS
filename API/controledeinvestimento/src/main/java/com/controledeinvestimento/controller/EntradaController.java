package com.controledeinvestimento.controller;

import com.controledeinvestimento.domain.Entrada;
import com.controledeinvestimento.service.EntradaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
public class EntradaController {

    private final EntradaService service;

    public EntradaController(EntradaService service) { this.service = service; }

    @GetMapping
    public List<Entrada> listar(@RequestParam(value = "mes", required = false) Integer mes,
                                @RequestParam(value = "ano", required = false) Integer ano,
                                @RequestParam(value = "valor", required = false) BigDecimal valor){
        return service.listar(mes, ano, valor);
    }

    @PostMapping
    public ResponseEntity<Entrada> criar(@Valid @RequestBody Entrada e){
        Entrada salvo = service.salvar(e);
        return ResponseEntity.created(URI.create("/api/entradas/" + salvo.getId())).body(salvo);
    }
}
