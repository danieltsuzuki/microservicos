package com.github.danieltsuzuki.mscartoes.application;

import com.github.danieltsuzuki.mscartoes.domain.ClienteCartao;
import com.github.danieltsuzuki.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
