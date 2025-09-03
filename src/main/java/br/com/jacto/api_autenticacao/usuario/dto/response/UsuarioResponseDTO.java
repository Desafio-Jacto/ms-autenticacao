package br.com.jacto.api_autenticacao.usuario.dto.response;

import br.com.jacto.api_autenticacao.enums.Role;
import br.com.jacto.api_autenticacao.usuario.model.Usuario;

public record UsuarioResponseDTO(
        Integer id,
        String nome,
        String email,
        Role role
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
    }
}
