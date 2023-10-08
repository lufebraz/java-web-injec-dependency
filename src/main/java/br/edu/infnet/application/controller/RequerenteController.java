package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequerenteController {

    @Autowired
    private RequerenteService requerenteService;

    @GetMapping(value = "/requerente/lista")
    public String telaLista(Model model) {

        model.addAttribute("listaRequerente", requerenteService.obterLista());

        return "requerente/lista";
    }

    @GetMapping(value = "/requerente/cadastro")
    public String telaCadastro() {

        return "requerente/cadastro";
    }

    @PostMapping(value = "/requerente/incluir")
    public String incluir(Requerente requerente) {

        requerenteService.incluir(requerente);

        return "redirect:/requerente/lista";
    }

    @GetMapping(value = "/requerente/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        requerenteService.excluir(id);

        return "redirect:/requerente/lista";
    }
    
    
}
