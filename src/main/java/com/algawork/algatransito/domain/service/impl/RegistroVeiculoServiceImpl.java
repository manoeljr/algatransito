package com.algawork.algatransito.domain.service.impl;

import com.algawork.algatransito.domain.model.Veiculo;
import com.algawork.algatransito.domain.repository.VeiculoRepository;
import com.algawork.algatransito.domain.service.RegistroVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@AllArgsConstructor
public class RegistroVeiculoServiceImpl implements RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Override
    public Veiculo add(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void destroy(Long veiculoId) {
        veiculoRepository.findById(veiculoId);
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }
}
