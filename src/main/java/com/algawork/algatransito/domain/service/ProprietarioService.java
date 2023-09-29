package com.algawork.algatransito.domain.service;

import com.algawork.algatransito.domain.model.Proprietario;

import java.util.List;

public interface ProprietarioService {
    List<Proprietario> findAll();
    Proprietario proprietarioPorId(Long id);
    Proprietario cadastrar(Proprietario proprietario);
    void deletar(Long id);
    Proprietario alterar(Proprietario proprietario);
}
