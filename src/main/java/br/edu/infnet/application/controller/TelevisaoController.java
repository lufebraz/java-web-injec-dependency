package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.produtos.Televisao;
import br.edu.infnet.application.model.service.TelevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/televisao")
public class TelevisaoController {

    @Autowired
    private TelevisaoService televisaoService;

    @PostMapping
    public ResponseEntity<Televisao> incluir(@RequestBody Televisao televisao) throws URISyntaxException {
        Televisao televisaoSalvo = televisaoService.incluir(televisao);

        return ResponseEntity.created(new URI("/televisao/" + televisaoSalvo.getId())).body(televisaoSalvo);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> excluir(@PathVariable("codigo") int codigo) {
        boolean wasDeleted = televisaoService.excluir(codigo);

        return wasDeleted ? ResponseEntity.ok("Excluido") :  ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @PutMapping(value = "/update/{codigo}")
    public ResponseEntity<?> atualizarTelevisao(@RequestBody Televisao televisao, @PathVariable("codigo") int codigo) throws Exception {
        Televisao savedTelevisao = televisaoService.atualizarTelevisao(televisao, codigo);

        return savedTelevisao != null ? ResponseEntity.ok(televisao) : ResponseEntity.badRequest().body("Nao foi localizado");
    }

    @GetMapping("/find-all")
    public Collection<Televisao> obterLista(){
        return televisaoService.obterLista();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> obterPorId(@PathVariable("codigo") int codigo){
        Televisao televisao = televisaoService.obterPorId(codigo);
        return televisao != null ? ResponseEntity.ok(televisao) : ResponseEntity.badRequest().body("Nao foi localizado");
    }

    
    
}
