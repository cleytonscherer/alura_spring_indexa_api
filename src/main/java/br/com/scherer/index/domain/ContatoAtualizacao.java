package br.com.scherer.index.domain;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContatoAtualizacao(
        @NotNull(message = "ID do Contato deve ser informado")
        Long        id,
        String      nome,
        byte[]      avatar,
        String      telefone,
        String      email,
        LocalDate   aniversario,
        String      redes,
        String      observacoes
) {
}
