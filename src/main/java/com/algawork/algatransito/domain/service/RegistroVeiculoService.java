package com.algawork.algatransito.domain.service;

import com.algawork.algatransito.domain.model.Veiculo;

import java.util.List;
import java.util.Optional;

public interface RegistroVeiculoService {
    Veiculo cadastrar(Veiculo veiculo);
    void deletar(Long veiculoId);
    List<Veiculo> listar();
    Optional<Veiculo> listarPorId(Long id);
}
