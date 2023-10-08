package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Pedido;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

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

		pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {

		pedidoRepository.deleteById(id);
	}	
}