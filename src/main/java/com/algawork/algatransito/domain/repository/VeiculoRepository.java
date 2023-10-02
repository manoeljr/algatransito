package com.algawork.algatransito.domain.repository;

import com.algawork.algatransito.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
