package com.algawork.algatransito.domain.service.impl;

import com.algawork.algatransito.domain.exception.NegocioException;
import com.algawork.algatransito.domain.model.Proprietario;
import com.algawork.algatransito.domain.model.StatusVeiculo;
import com.algawork.algatransito.domain.model.Veiculo;
import com.algawork.algatransito.domain.repository.ProprietarioRepository;
import com.algawork.algatransito.domain.repository.VeiculoRepository;
import com.algawork.algatransito.domain.service.RegistroProprietarioService;
import com.algawork.algatransito.domain.service.RegistroVeiculoService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class RegistroVeiculoServiceImpl implements RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioServiceImpl registroProprietarioServiceImpl;

    public RegistroVeiculoServiceImpl(VeiculoRepository veiculoRepository, RegistroProprietarioServiceImpl registroProprietarioServiceImpl) {
        this.veiculoRepository = veiculoRepository;
        this.registroProprietarioServiceImpl = registroProprietarioServiceImpl;
    }

    @Override
    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {
        if (novoVeiculo.getId() != null) {
            throw new NegocioException("Veiculo a ser cadastrado não deve possuir um código.");
        }
        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo -> !veiculo.equals(novoVeiculo))
                .isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veiculo cadastrado com está placa.");
        }

        Proprietario proprietario = registroProprietarioServiceImpl.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());

        return veiculoRepository.save(novoVeiculo);
    }

    @Override
    @Transactional
    public void deletar(Long veiculoId) {
        var veiculo = veiculoRepository.getReferenceById(veiculoId);
        veiculoRepository.delete(veiculo);
    }

    @Override
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @Override
    public Optional<Veiculo> listarPorId(Long id) {
        return veiculoRepository.findById(id);
    }
}
