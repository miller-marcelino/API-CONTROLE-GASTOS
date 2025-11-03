package com.controledeinvestimento.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer mes; // 1-12

    @NotNull
    private Integer ano;

    @NotNull
    private BigDecimal valor;

    private OffsetDateTime criadoEm = OffsetDateTime.now();
}
