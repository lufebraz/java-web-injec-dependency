package br.edu.infnet.application.controller;

import br.edu.infnet.application.model.domain.Pedido;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.service.PedidoService;
import br.edu.infnet.application.model.service.ProdutoService;
import br.edu.infnet.application.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private RequerenteService requerenteService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/pedido")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("requerentes", requerenteService.obterLista(usuario));

		model.addAttribute("produtos", produtoService.obterLista(usuario));
		
		return "pedido/cadastro";
	}
	
	@GetMapping(value = "/pedido/lista")
	public String telaLista(Model model) {
		model.addAttribute("pedidoList", pedidoService.obterLista());

		return "pedido/lista";
	}
	
	@PostMapping(value = "/pedido/incluir")
	public String incluir(Pedido pedido, @SessionAttribute("user") Usuario usuario) {
		
//		pedido.setUsuario(usuario);

		pedidoService.incluir(pedido);
		
		return "redirect:/pedido/lista";
	}

	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		pedidoService.excluir(id);
		
		return "redirect:/pedido/lista";
	}
}