package com.github.danieltsuzuki.mscartoes.application;

import com.github.danieltsuzuki.mscartoes.application.representation.CartaoSaveRequest;
import com.github.danieltsuzuki.mscartoes.application.representation.CartoesPorClienteResponse;
import com.github.danieltsuzuki.mscartoes.domain.Cartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request){
        var cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        var listaCartoes = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(listaCartoes);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        var listaCartoesCliente = clienteCartaoService.listCartoesByCpf(cpf)
                .stream().map(CartoesPorClienteResponse::fromModel).collect(Collectors.toList());

        return ResponseEntity.ok(listaCartoesCliente);
    }

}
