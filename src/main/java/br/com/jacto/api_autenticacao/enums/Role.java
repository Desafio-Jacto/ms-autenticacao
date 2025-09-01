package br.com.jacto.api_autenticacao.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    TECNICO,
    CLIENTE;

    @Override
    public String getAuthority() {
        return name();
    }
}
