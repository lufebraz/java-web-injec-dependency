package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Televisao;
import br.edu.infnet.application.model.service.TelevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TelevisaoController {

    @Autowired
    private TelevisaoService televisaoService;


    public Collection<Televisao> obterLista(){
        return televisaoService.obterLista();
    }

    public void incluir(Televisao televisao) {
        televisaoService.incluir(televisao);
        System.out.println("[Televisao] Inclusão realizada com sucesso: " + televisao);
    }

    public void excluir(int codigo) {
        televisaoService.excluir(codigo);
    }

    @GetMapping(value = "/televisao/lista")
    public String telaLista(Model model) {

        model.addAttribute("tvList", obterLista());

        return "televisao/lista";
    }

    @GetMapping(value = "/televisao/{codigo}/excluir")
    public String exclusao(@PathVariable int codigo) {

        excluir(codigo);

        return "redirect:/televisao/lista";
    }
    
    
}
