package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Celular;
import br.edu.infnet.application.model.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CelularController {

    @Autowired
    private CelularService celularService;

    public Collection<Celular> obterLista(){
        return celularService.obterLista();
    }

    public void incluir(Celular celular) {
        celularService.incluir(celular);

        System.out.println("[Celular] Inclusão realizada com sucesso: " + celular);
    }

    public void excluir(int codigo) {
        celularService.excluir(codigo);
    }

    @GetMapping(value = "/celular/lista")
    public String telaLista(Model model) {

        model.addAttribute("celList", obterLista());

        return "celular/lista";
    }

    @GetMapping(value = "/celular/{codigo}/excluir")
    public String exclusao(@PathVariable int codigo) {

        excluir(codigo);

        return "redirect:/celular/lista";
    }
    
    
}
