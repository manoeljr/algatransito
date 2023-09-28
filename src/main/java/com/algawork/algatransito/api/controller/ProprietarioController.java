package com.algawork.algatransito.api.controller;


import com.algawork.algatransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("proprietarios")
public class ProprietarioController {

    @GetMapping
    public List<Proprietario> listar() {
        var proprietario = new Proprietario();
        proprietario.setId(1L);
        proprietario.setNome("João");
        proprietario.setTelefone("34 99999-1111");
        proprietario.setEmail("joaodascouver@algaworks.com");

        var proprietario1 = new Proprietario();
        proprietario1.setId(2L);
        proprietario1.setNome("Maria");
        proprietario1.setTelefone("11 98888-1111");
        proprietario1.setEmail("mariadasilva@algaworks.com");

        return Arrays.asList(proprietario, proprietario1);
    }
}
