package com.controledeinvestimento.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String referencia;

    @NotNull
    private BigDecimal valor;

    private BigDecimal valorComJuros;

    private BigDecimal frete;

    private String forma1;

    private String forma2;

    @Column(length = 2000)
    private String obs;

    // Para simplicidade, armazenamos apenas o nome do fornecedor
    private String fornecedor;

    private OffsetDateTime criadoEm = OffsetDateTime.now();
}
