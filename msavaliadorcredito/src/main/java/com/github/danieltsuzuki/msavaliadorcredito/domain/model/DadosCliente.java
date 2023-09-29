package com.github.danieltsuzuki.msavaliadorcredito.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DadosCliente {

    private Long id;
    private String nome;

}
