package br.com.jacto.api_autenticacao.usuario.dto;

import br.com.jacto.api_autenticacao.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroUsuarioDTO(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String senha,
        @NotNull
        Role role
) {}
