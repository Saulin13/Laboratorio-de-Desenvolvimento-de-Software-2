package com.labs.aluguel.dto;

import com.labs.aluguel.entity.Emprego;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

public record ClienteDTO(
        @NotBlank @Size(min = 3, max = 120) String nome,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotBlank @Size(min = 5, max = 20) String rg,
        @NotBlank @Size(min = 5, max = 200) String endereco,
        @NotBlank @Size(min = 2, max = 80) String profissao,
        @Size(max = 3) @Valid List<Emprego> empregos
) {}
