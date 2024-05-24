package br.com.fiap.notificacao.dto;

import br.com.fiap.notificacao.model.ColetaEnum;
import jakarta.validation.constraints.NotBlank;

public record CadastroDto(
        Long id,

        @NotBlank(message = "O campo nome não pode ficar vazio!")
        String nome,
        @NotBlank(message = "O campo endereco não pode ficar vazio!")
        String endereco,

        ColetaEnum diaColetaOrganica,
        ColetaEnum diaColetaPlastico
) {
}
