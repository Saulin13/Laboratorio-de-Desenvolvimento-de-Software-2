package com.labs.aluguel.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Emprego {

    @NotBlank
    @Size(min = 2, max = 120)
    private String entidadeEmpregadora;

    @NotNull
    @PositiveOrZero
    private BigDecimal rendimentoMensal;
}
