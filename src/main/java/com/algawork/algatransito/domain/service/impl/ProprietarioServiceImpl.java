package com.algawork.algatransito.domain.service.impl;

import com.algawork.algatransito.domain.model.Proprietario;
import com.algawork.algatransito.domain.repository.ProprietarioRepository;
import com.algawork.algatransito.domain.service.ProprietarioService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProprietarioServiceImpl implements ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioServiceImpl(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }
    @Override
    public List<Proprietario> findAll() {
        return proprietarioRepository.findAll();
    }

    @Override
    public Proprietario proprietarioPorId(Long id) {
        return proprietarioRepository.findById(id).orElse(null);
    }

    @Override
    public Proprietario cadastrar(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @Override
    public void deletar(Long id) {
        proprietarioRepository.deleteById(id);
    }

    @Override
    public Proprietario alterar(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }
}
