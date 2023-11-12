package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Notebook;
import br.edu.infnet.application.model.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/notebook")
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    @PostMapping
    public ResponseEntity<Notebook> incluir(@RequestBody Notebook notebook) throws URISyntaxException {
        Notebook notebookSalvo = notebookService.incluir(notebook);

        return ResponseEntity.created(new URI("/notebook/" + notebookSalvo.getId())).body(notebookSalvo);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> excluir(@PathVariable("codigo") int codigo) {
        boolean wasDeleted = notebookService.excluir(codigo);

        return wasDeleted ? ResponseEntity.ok("Excluido") :  ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @PutMapping(value = "/update/{codigo}")
    public ResponseEntity<?> atualizarNotebook(@RequestBody Notebook notebook, @PathVariable("codigo") int codigo) throws Exception {
        Notebook savedNotebook = notebookService.atualizarNotebook(notebook, codigo);

        return savedNotebook != null ? ResponseEntity.ok(notebook) : ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @GetMapping("/find-all")
    public Collection<Notebook> obterLista(){
        return notebookService.obterLista();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> obterPorId(@PathVariable("codigo") int codigo){
        Notebook notebook = notebookService.obterPorId(codigo);
        return notebook != null ? ResponseEntity.ok(notebook) : ResponseEntity.badRequest().body("Nao foi localizado");
    }


}
