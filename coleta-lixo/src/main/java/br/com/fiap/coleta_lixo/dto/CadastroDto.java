package br.com.fiap.coleta_lixo.dto;

import br.com.fiap.coleta_lixo.model.Coletando;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CadastroDto(
        Long numeroLixeira,
        @NotBlank(message = "O campo de endereço não pode ser vazio!")
        String endereco,
        LocalDate dataColeta,
        Coletando lixeiraCheia,
        Coletando processoColeta
) {
}
