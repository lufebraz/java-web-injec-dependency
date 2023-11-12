package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Pedido;
import br.edu.infnet.application.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido incluir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public boolean excluir(Integer id) {
		Optional<Pedido> byId = pedidoRepository.findById(id);
		if (byId.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Collection<Pedido> obterLista(){
		return (Collection<Pedido>) pedidoRepository.findAll();
	}

	public Pedido obterPorId(int codigo) {
		Optional<Pedido> byId = pedidoRepository.findById(codigo);
		return byId.orElse(null);
	}

	public Pedido atualizarPedido(Pedido pedido, int codigo) throws Exception {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(codigo);
		if (pedidoOptional.isPresent()) {
			pedido.setId(codigo);
			return pedidoRepository.save(pedido);
		} else {
			return null;
		}

	}
}