package com.algawork.algatransito.api.controller;


import com.algawork.algatransito.domain.exception.NegocioException;
import com.algawork.algatransito.domain.model.Proprietario;
import com.algawork.algatransito.domain.repository.ProprietarioRepository;
import com.algawork.algatransito.domain.service.RegistroProprietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("proprietarios")
public class ProprietarioController {

    private RegistroProprietarioService registroProprietarioService;
    private ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<Proprietario> listar() {
        return registroProprietarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> proprietarioPorId(@PathVariable Long id) {
        return registroProprietarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!proprietarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        registroProprietarioService.destroy(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario cadastrar(@Valid @RequestBody Proprietario proprietario) {
        return registroProprietarioService.add(proprietario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> alterar(@PathVariable Long id, @Valid @RequestBody Proprietario proprietario) {
        if (!proprietarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proprietario.setId(id);
        return ResponseEntity.ok(registroProprietarioService.add(proprietario));
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar(NegocioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
