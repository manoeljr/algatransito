package com.algawork.algatransito.domain.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veiculo {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Proprietario proprietario;
    private String marca;
    private String modelo;
    private String placa;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataApreensao;
}