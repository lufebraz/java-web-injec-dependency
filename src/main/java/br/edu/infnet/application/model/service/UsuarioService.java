package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
    private Map<String, Usuario> userMapping = new HashMap<>();

    public Collection<Usuario> obterLista(){
        return userMapping.values();
    }

    public void incluir(Usuario usuario) {
        userMapping.put(usuario.getEmail(), usuario);
        System.out.println("[Users] Inclusão realizada com sucesso: " + usuario);
    }

    public void excluir(String email) {
        userMapping.remove(email);
    }

    public Usuario validar(String email, String senha) {

        Usuario usuario = userMapping.get(email);

        if(usuario != null) {
            if(senha.equalsIgnoreCase(usuario.getSenha())) {
                return usuario;
            }
        }

        return null;
    }
}
