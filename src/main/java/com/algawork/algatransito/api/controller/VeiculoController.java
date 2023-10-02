package com.algawork.algatransito.api.controller;


import com.algawork.algatransito.domain.exception.NegocioException;
import com.algawork.algatransito.domain.model.Veiculo;
import com.algawork.algatransito.domain.repository.VeiculoRepository;
import com.algawork.algatransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    private final RegistroVeiculoService registroVeiculoService;
    private final VeiculoRepository veiculoRepository;

    public VeiculoController(RegistroVeiculoService registroVeiculoService, VeiculoRepository veiculoRepository) {
        this.registroVeiculoService = registroVeiculoService;
        this.veiculoRepository = veiculoRepository;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return registroVeiculoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> veiculoPorId(@PathVariable Long id) {
        return registroVeiculoService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        registroVeiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return registroVeiculoService.cadastrar(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> alterar(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        veiculo.setId(id);
        return ResponseEntity.ok(registroVeiculoService.cadastrar(veiculo));
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar(NegocioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
