package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Collection<Usuario> obterLista(){
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public Usuario incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
        System.out.println("[Users] Inclusão realizada com sucesso: " + usuario);
        return usuario;
    }

    public void excluir(String email) {
        usuarioRepository.deleteById(usuarioRepository.findByEmail(email).getId());
    }

    public Usuario validar(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario != null) {
            if(senha.equalsIgnoreCase(usuario.getSenha())) {
                return usuario;
            }
        }

        return null;
    }
}
