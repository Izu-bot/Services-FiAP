package br.com.fiap.auth.dto;

import br.com.fiap.auth.model.UsuarioRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistrarDto(
        Long id,

        @NotNull
        @NotBlank(message = "O email não pode ser vazio")
        String email,

        @NotNull
        @NotBlank(message = "A senha não pode ser nulo")
        @Size(min = 6, max = 12, message = "A senha deve possuir entre 6 a 12 caracteres")
        String senha,

        UsuarioRole role
) {
}
