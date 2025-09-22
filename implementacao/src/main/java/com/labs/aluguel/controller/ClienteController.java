package com.labs.aluguel.controller;

import com.labs.aluguel.dto.ClienteDTO;
import com.labs.aluguel.entity.Cliente;
import com.labs.aluguel.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "CRUD de clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Cria um novo cliente")
    public ResponseEntity<Cliente> criar(@Valid @RequestBody ClienteDTO dto) {
        Cliente salvo = service.criar(dto);
        return ResponseEntity.created(URI.create("/api/clientes/" + salvo.getId())).body(salvo);
    }

    @GetMapping
    @Operation(summary = "Lista todos os clientes")
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um cliente pelo ID")
    public Cliente buscar(
            @Parameter(description = "ID do cliente", example = "1", required = true)
            @PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um cliente pelo ID")
    public Cliente atualizar(
            @Parameter(description = "ID do cliente", example = "1", required = true)
            @PathVariable("id") Long id,
            @Valid @RequestBody ClienteDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um cliente pelo ID")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do cliente", example = "1", required = true)
            @PathVariable("id") Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
