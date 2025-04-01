package br.com.scherer.index.domain;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ContatoCadastro(
        @NotBlank(message = "Nome do contato deve ser informado")
        String      nome,
        @NotBlank
        byte[]      avatar,
        @NotBlank(message = "Telefone do contato deve ser informado")
        String      telefone,
        @NotBlank(message = "Endereço de e-mail do contato deve ser informado")
        String      email,
        LocalDate   aniversario,
        String      redes,
        String      observacoes
) {
}
