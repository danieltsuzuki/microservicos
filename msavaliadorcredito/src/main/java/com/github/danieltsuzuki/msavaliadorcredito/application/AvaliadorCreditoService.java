package com.github.danieltsuzuki.msavaliadorcredito.application;

import com.github.danieltsuzuki.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {


    public SituacaoCliente obterSituacaoCliente(String cpf){
        //obter dadosCliente -MsClientes
        //obter cartoes do cliente -MsCartoes
    }

}
