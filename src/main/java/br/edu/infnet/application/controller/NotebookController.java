package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Notebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NotebookController {

    private Map<Integer, Notebook> mapaNotebook = new HashMap<Integer, Notebook>();

    public Collection<Notebook> obterLista(){
        return mapaNotebook.values();
    }

    public void incluir(Notebook nootebook) {
        mapaNotebook.put(nootebook.getCodigo(), nootebook);
        System.out.println("[Notebook] Inclusão realizada com sucesso: " + nootebook);
    }

    public void excluir(int codigo) {
        mapaNotebook.remove(codigo);
    }

    @GetMapping(value = "/nootebook/lista")
    public String telaLista(Model model) {

        model.addAttribute("listaNotebook", obterLista());

        return "nootebook/lista";
    }

    @GetMapping(value = "/nootebook/{codigo}/excluir")
    public String exclusao(@PathVariable int codigo) {

        excluir(codigo);

        return "redirect:/nootebook/lista";
    }
    
    
}
