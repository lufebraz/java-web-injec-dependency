package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/requerente")
public class RequerenteController {

    @Autowired
    private RequerenteService requerenteService;

    @PostMapping
    public ResponseEntity<Requerente> incluir(@RequestBody Requerente requerente) throws URISyntaxException {
        Requerente requerenteSalvo = requerenteService.incluir(requerente);

        return ResponseEntity.created(new URI("/requerente/" + requerenteSalvo.getId())).body(requerenteSalvo);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> excluir(@PathVariable("codigo") int codigo) {
        boolean wasDeleted = requerenteService.excluir(codigo);

        return wasDeleted ? ResponseEntity.ok("Excluido") :  ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @PutMapping(value = "/update/{codigo}")
    public ResponseEntity<?> atualizarRequerente(@RequestBody Requerente requerente, @PathVariable("codigo") int codigo) throws Exception {
        Requerente savedRequerente = requerenteService.atualizarRequerente(requerente, codigo);

        return savedRequerente != null ? ResponseEntity.ok(requerente) : ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @GetMapping("/find-all")
    public Collection<Requerente> obterLista(){
        return requerenteService.obterLista();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> obterPorId(@PathVariable("codigo") int codigo){
        Requerente requerente = requerenteService.obterPorId(codigo);
        return requerente != null ? ResponseEntity.ok(requerente) : ResponseEntity.badRequest().body("Nao foi localizado");
    }

}
