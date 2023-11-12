package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.Pedido;
import br.edu.infnet.application.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<Pedido> incluir(@RequestBody Pedido pedido) throws URISyntaxException {
		Pedido pedidoSalvo = pedidoService.incluir(pedido);

		return ResponseEntity.created(new URI("/pedido/" + pedidoSalvo.getId())).body(pedidoSalvo);
	}


	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> excluir(@PathVariable("codigo") int codigo) {
		boolean wasDeleted = pedidoService.excluir(codigo);

		return wasDeleted ? ResponseEntity.ok("Excluido") :  ResponseEntity.badRequest().body("Nao foi localizado");
	}

	@PutMapping(value = "/update/{codigo}")
	public ResponseEntity<?> atualizarPedido(@RequestBody Pedido pedido, @PathVariable("codigo") int codigo) throws Exception {
		Pedido savedPedido = pedidoService.atualizarPedido(pedido, codigo);

		return savedPedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.badRequest().body("Nao foi localizado");
	}

	@GetMapping("/find-all")
	public Collection<Pedido> obterLista(){
		return pedidoService.obterLista();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> obterPorId(@PathVariable("codigo") int codigo){
		Pedido pedido = pedidoService.obterPorId(codigo);
		return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.badRequest().body("Nao foi localizado");
	}



}