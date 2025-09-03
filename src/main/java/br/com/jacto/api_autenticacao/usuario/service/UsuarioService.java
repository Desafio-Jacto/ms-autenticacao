package br.com.jacto.api_autenticacao.usuario.service;

import br.com.jacto.api_autenticacao.infra.exceptions.EmailJaCadastradoException;
import br.com.jacto.api_autenticacao.usuario.dto.request.RegistroUsuarioDTO;
import br.com.jacto.api_autenticacao.usuario.model.Usuario;
import br.com.jacto.api_autenticacao.usuario.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(RegistroUsuarioDTO dados) {
        if (usuarioRepository.findByEmail(dados.email()).isPresent()) {
            throw new EmailJaCadastradoException("E-mail já cadastrado.");
        }

        String senhaHash = passwordEncoder.encode(dados.senha());
        Usuario novoUsuario = new Usuario(
                dados.nome(),
                dados.email(),
                senhaHash,
                dados.role()
        );
        return usuarioRepository.save(novoUsuario);
    }
}
