package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("user")
@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/valida")
    public String validar(Model model, @RequestParam String email, @RequestParam String senha) {

        Usuario user = usuarioService.validar(email, senha);

        if(user != null) {

            model.addAttribute("user", user);

            return "home";
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista(Model model) {

        model.addAttribute("userList", usuarioService.obterLista());

        return "usuario/lista";
    }

    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {

        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {

        usuarioService.incluir(usuario);

        return "redirect:/";
    }

    @GetMapping(value = "/usuario/{email}/excluir")
    public String excluir(@PathVariable String email) {

        usuarioService.excluir(email);

        return "redirect:/usuario/lista";
    }
}
