package br.com.scherer.index.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;

import java.time.LocalDate;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  nome;
    private String  telefone;
    private String  email;
    private LocalDate   aniversario;
    private String  redes;
    private String  observacoes;

    public Contato() {
    }

    public Contato(ContatoCadastro dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.aniversario = dto.aniversario();
        this.redes = dto.redes();
        this.observacoes = dto.observacoes();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public String getRedes() {
        return redes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void atualizar(@Valid ContatoAtualizacao dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.aniversario() != null) {
            this.aniversario = dados.aniversario();
        }
        if (dados.redes() != null) {
            this.redes = dados.redes();
        }
        if (dados.observacoes() != null) {
            this.observacoes = dados.observacoes();;
        }
    }
}
