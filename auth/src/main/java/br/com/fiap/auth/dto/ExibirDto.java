package br.com.fiap.auth.dto;

import br.com.fiap.auth.model.Usuario;
import br.com.fiap.auth.model.UsuarioRole;

public record ExibirDto(
        Long id,
        String email,
        UsuarioRole role
) {
    public ExibirDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getUsuarioRole()
        );
    }
}
