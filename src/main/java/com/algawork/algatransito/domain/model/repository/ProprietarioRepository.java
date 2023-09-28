package com.algawork.algatransito.domain.model.repository;

import com.algawork.algatransito.domain.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
}
