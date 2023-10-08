package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Notebook;
import br.edu.infnet.application.model.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    public Collection<Notebook> obterLista(){
        return notebookService.obterLista();
    }

    public void incluir(Notebook notebook) {
        notebookService.incluir(notebook);
        System.out.println("[Notebook] Inclusão realizada com sucesso: " + notebook);
    }

    public void excluir(int codigo) {
        notebookService.excluir(codigo);
    }

    @GetMapping(value = "/notebook/lista")
    public String telaLista(Model model) {

        model.addAttribute("listaNotebook", obterLista());

        return "notebook/lista";
    }
    @GetMapping(value = "/notebook/cadastro")
    public String telaCadastro() {

        return "notebook/cadastro";
    }
    @GetMapping(value = "/notebook/{codigo}/excluir")
    public String exclusao(@PathVariable int codigo) {

        excluir(codigo);

        return "redirect:/notebook/lista";
    }
    
    
}
