package br.com.scherer.index.domain;

import java.time.LocalDate;

public record ContatoDetalhe(
        Long        id,
        String      nome,
        String      telefone,
        String      email,
        LocalDate aniversario,
        String      redes,
        String      observacoes
) {
    public ContatoDetalhe(Contato contato) {
        this(   contato.getId(),
                contato.getNome(),
                contato.getTelefone(),
                contato.getEmail(),
                contato.getAniversario(),
                contato.getRedes(),
                contato.getObservacoes()
        );

    }
}
