package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Pedido;
import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private RequerenteService requerenteService;

	@Autowired
	private UsuarioService usuarioService;

	public Collection<Pedido> obterLista(){
		
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
	public Collection<Pedido> obterLista(Usuario usuario){
		
		List<Pedido> lista = pedidoRepository.obterLista(usuario.getId());
		
		if(lista.isEmpty()) {
			return Collections.emptyList();
		}
		
		return lista;
	}

	public void incluir(Pedido pedido) {
		Requerente incluir = requerenteService.incluir(pedido.getRequerente());
		Usuario usuario = usuarioService.incluir(new Usuario());
		pedido.setData(LocalDateTime.now());
		pedido.setUsuario(usuario);
		pedido.setRequerente(incluir);
		pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {

		pedidoRepository.deleteById(id);
	}	
}