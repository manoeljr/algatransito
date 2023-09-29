package com.algawork.algatransito.api.controller;


import com.algawork.algatransito.domain.model.Proprietario;
import com.algawork.algatransito.domain.service.ProprietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("proprietarios")
public class ProprietarioController {

    private ProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> listar() {
        return proprietarioService.findAll();
    }

    @GetMapping("/{id}")
    public Proprietario proprietarioPorId(@PathVariable Long id) {
        return proprietarioService.proprietarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        proprietarioService.deletar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario cadastrar(@Valid @RequestBody Proprietario proprietario) {
        return proprietarioService.cadastrar(proprietario);
    }

    @PutMapping("/{id}")
    public Proprietario alterar(@PathVariable Long id, @RequestBody Proprietario proprietario) {
        proprietario.setId(id);
        return proprietarioService.alterar(proprietario);
    }
}
