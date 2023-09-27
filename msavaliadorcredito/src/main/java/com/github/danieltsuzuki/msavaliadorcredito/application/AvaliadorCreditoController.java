package com.github.danieltsuzuki.msavaliadorcredito.application;

import com.github.danieltsuzuki.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String getStatus(){
        return "ok";
    }
    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoCliente> consultaSSituacaoCliente(@RequestParam("cpf") String cpf){
        SituacaoCliente situacaoCliente = avaliadorCcreditoService.obterSituacaoCliente(cpf);
    }

}
