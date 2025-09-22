package com.labs.aluguel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 120)
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos (apenas números).")
    @Column(unique = true, length = 11, nullable = false)
    private String cpf;

    @NotBlank
    @Size(min = 5, max = 20)
    private String rg;

    @NotBlank
    @Size(min = 5, max = 200)
    private String endereco;

    @NotBlank
    @Size(min = 2, max = 80)
    private String profissao;

    // Até 3 empregos (entidade empregadora + rendimento)
    @ElementCollection
    @CollectionTable(name = "cliente_empregos", joinColumns = @JoinColumn(name = "cliente_id"))
    private List<Emprego> empregos = new ArrayList<>();

    @PrePersist @PreUpdate
    private void validarEmpregos() {
        if (empregos != null && empregos.size() > 3) {
            throw new IllegalArgumentException("Máximo de 3 empregos/rendimentos por cliente.");
        }
    }
}
