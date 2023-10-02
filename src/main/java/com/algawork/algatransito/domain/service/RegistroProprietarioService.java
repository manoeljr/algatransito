package com.algawork.algatransito.domain.service;

import com.algawork.algatransito.domain.model.Proprietario;

import java.util.List;
import java.util.Optional;


public interface RegistroProprietarioService {
    Proprietario add(Proprietario proprietario);
    void destroy(Long proprietarioId);
    List<Proprietario> findAll();
    Optional<Proprietario> findById(Long id);
}
