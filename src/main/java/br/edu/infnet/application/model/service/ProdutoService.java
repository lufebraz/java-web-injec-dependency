package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Produto;
import br.edu.infnet.application.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto incluir(Produto produto) {
		return produtoRepository.save(produto);
	}

	public boolean excluir(Integer id) {
		Optional<Produto> byId = produtoRepository.findById(id);
		if (byId.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}

	public Produto obterPorId(int codigo) {
		Optional<Produto> byId = produtoRepository.findById(codigo);
		return byId.orElse(null);
	}

	public Produto atualizarProduto(Produto produto, int codigo) throws Exception {
		Optional<Produto> produtoOptional = produtoRepository.findById(codigo);
		if (produtoOptional.isPresent()) {
			produto.setId(codigo);
			return produtoRepository.save(produto);
		} else {
			return null;
		}

	}
}