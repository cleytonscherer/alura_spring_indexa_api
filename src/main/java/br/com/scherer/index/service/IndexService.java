package br.com.scherer.index.service;

import br.com.scherer.index.domain.Contato;
import br.com.scherer.index.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexRepository repository;

    public List<Contato> listarTodos() {
        return repository.findAll();
    }

    public Contato cadastrar(Contato contato) {
        return repository.save(contato);
    }

    public Contato buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }

    public void excluir(Contato contato) {
        repository.delete(contato);
    }
}
