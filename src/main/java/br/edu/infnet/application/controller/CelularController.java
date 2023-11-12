package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Celular;
import br.edu.infnet.application.model.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/celular")
public class CelularController {

    @Autowired
    private CelularService celularService;

    @PostMapping
    public ResponseEntity<Celular> incluir(@RequestBody Celular celular) throws URISyntaxException {
        Celular celularSalvo = celularService.incluir(celular);

        return ResponseEntity.created(new URI("/celular/" + celularSalvo.getId())).body(celularSalvo);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> excluir(@PathVariable("codigo") int codigo) {
        boolean wasDeleted = celularService.excluir(codigo);

        return wasDeleted ? ResponseEntity.ok("Excluido") :  ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @PutMapping(value = "/update/{codigo}")
    public ResponseEntity<?> atualizarCelular(@RequestBody Celular celular, @PathVariable("codigo") int codigo) throws Exception {
        Celular savedCelular = celularService.atualizarCelular(celular, codigo);

        return savedCelular != null ? ResponseEntity.ok(celular) : ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @GetMapping("/find-all")
    public Collection<Celular> obterLista(){
        return celularService.obterLista();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> obterPorId(@PathVariable("codigo") int codigo){
        Celular celular = celularService.obterPorId(codigo);
        return celular != null ? ResponseEntity.ok(celular) : ResponseEntity.badRequest().body("Nao foi localizado");
    }
    
    
}
