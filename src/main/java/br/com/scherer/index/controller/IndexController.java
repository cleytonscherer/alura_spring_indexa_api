package br.com.scherer.index.controller;

import br.com.scherer.index.domain.Contato;
import br.com.scherer.index.domain.ContatoAtualizacao;
import br.com.scherer.index.domain.ContatoCadastro;
import br.com.scherer.index.domain.ContatoDetalhe;
import br.com.scherer.index.service.IndexService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class IndexController {

    @Autowired
    private IndexService service;

    @GetMapping
    public ResponseEntity<List<Contato>> listarTodos() {
        System.out.println("retorando contato #2");
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDetalhe> listarContato(@PathVariable Long id) {
        Contato contato = service.buscarPorId(id);
        System.out.println("retorando contato #1");
        return ResponseEntity.ok(new ContatoDetalhe(contato));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ContatoDetalhe> cadastrar(
            @RequestBody @Valid ContatoCadastro contatoCadastro,
            UriComponentsBuilder uriBuilder
    ) {
        Contato contato = new Contato(contatoCadastro);
        service.cadastrar(contato);
        var uri = uriBuilder.path("/contatos/{id}").buildAndExpand(contato.getId()).toUri();
        System.out.println("Gravou no banco de dados");
        return ResponseEntity.created(uri).body(new ContatoDetalhe(contato));
    }

    @PutMapping
    //@CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    public ResponseEntity<ContatoDetalhe> atualizar(@RequestBody @Valid ContatoAtualizacao dados) {
        Contato contato = service.buscarPorId(dados.id());
        contato.atualizar(dados);
        return ResponseEntity.ok(new ContatoDetalhe(contato));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Contato contato = service.buscarPorId(id);
        service.excluir(contato);
        return ResponseEntity.noContent().build();

    }

}
