package br.com.jacto.api_autenticacao.autenticacao.controller;

import br.com.jacto.api_autenticacao.autenticacao.dto.LoginRequest;
import br.com.jacto.api_autenticacao.autenticacao.dto.DadosTokenJWT;
import br.com.jacto.api_autenticacao.autenticacao.service.TokenService;
import br.com.jacto.api_autenticacao.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticação", description = "Endpoints de login e JWT")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping
    @Operation(summary = "Realiza o login e gera um token JWT",
            description = "Este endpoint valida as credenciais do usuário (email e senha) e, se o login for bem-sucedido, retorna um token JWT para acesso aos endpoints protegidos.")
    @ApiResponse(responseCode = "200", description = "Login bem-sucedido. Retorna o token JWT.")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas. O login falhou.")
    public ResponseEntity efetuarLogin(@RequestBody LoginRequest dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = service.generateToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
