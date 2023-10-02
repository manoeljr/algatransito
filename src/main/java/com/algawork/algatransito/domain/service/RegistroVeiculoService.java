package com.algawork.algatransito.domain.service;

import com.algawork.algatransito.domain.model.Veiculo;

import java.util.List;
import java.util.Optional;

public interface RegistroVeiculoService {
    Veiculo add(Veiculo veiculo);
    void destroy(Long veiculoId);
    List<Veiculo> findAll();
    Optional<Veiculo> findById(Long id);
}
