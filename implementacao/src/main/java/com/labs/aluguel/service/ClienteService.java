package com.labs.aluguel.service;

import com.labs.aluguel.dto.ClienteDTO;
import com.labs.aluguel.entity.Cliente;
import com.labs.aluguel.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Cliente criar(ClienteDTO dto) {
        if (repo.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        Cliente c = toEntity(new Cliente(), dto);
        return repo.save(c);
    }

    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente atualizar(Long id, ClienteDTO dto) {
        Cliente existente = buscarPorId(id);
        // CPF não pode ser alterado para outro que já exista
        if (!existente.getCpf().equals(dto.cpf()) && repo.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        Cliente atualizado = toEntity(existente, dto);
        return repo.save(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        Cliente existente = buscarPorId(id);
        repo.delete(existente);
    }

    private Cliente toEntity(Cliente c, ClienteDTO dto) {
        c.setNome(dto.nome());
        c.setCpf(dto.cpf());
        c.setRg(dto.rg());
        c.setEndereco(dto.endereco());
        c.setProfissao(dto.profissao());
        c.setEmpregos(dto.empregos());
        return c;
    }
}
