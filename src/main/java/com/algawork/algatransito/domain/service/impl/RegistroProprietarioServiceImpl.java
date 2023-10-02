package com.algawork.algatransito.domain.service.impl;

import com.algawork.algatransito.domain.exception.NegocioException;
import com.algawork.algatransito.domain.model.Proprietario;
import com.algawork.algatransito.domain.repository.ProprietarioRepository;
import com.algawork.algatransito.domain.service.RegistroProprietarioService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Component
public class RegistroProprietarioServiceImpl implements RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public RegistroProprietarioServiceImpl(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    public Proprietario buscar(Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId).orElseThrow(() -> new NegocioException("Proprietario não encontrado."));
    }

    @Transactional
    public Proprietario add(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p ->!p.equals(proprietario))
                .isPresent();
        if (emailEmUso) {
            throw new NegocioException("Já existe um proprietario cadastrado com este e-mail.");
        }
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void destroy(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

    public List<Proprietario> findAll() {
        return proprietarioRepository.findAll();
    }

    @Override
    public Optional<Proprietario> findById(Long id) {
        return proprietarioRepository.findById(id);
    }

}
