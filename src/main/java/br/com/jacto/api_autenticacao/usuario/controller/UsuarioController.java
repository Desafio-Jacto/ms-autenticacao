package br.com.jacto.api_autenticacao.usuario.controller;

import br.com.jacto.api_autenticacao.usuario.dto.RegistroUsuarioDTO;
import br.com.jacto.api_autenticacao.usuario.model.Usuario;
import br.com.jacto.api_autenticacao.usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Endpoints para o gerenciamento de usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Cadastra um novo usuário",
            description = "Cria um novo usuário com perfil de Técnico ou Cliente.")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso. Retorna os dados do novo usuário.")
    @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos.")
    @ApiResponse(responseCode = "409", description = "E-mail já cadastrado.")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid RegistroUsuarioDTO dados) {
        Usuario novoUsuario = usuarioService.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
