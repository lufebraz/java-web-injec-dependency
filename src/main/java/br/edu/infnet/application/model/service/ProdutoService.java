package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Produto;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Collection<Produto> obterLista(){
		
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public Collection<Produto> obterLista(Usuario usuario){
		
		return (Collection<Produto>) produtoRepository.obterLista(usuario.getId());
	}

	public void incluir(Produto produto) {

		produtoRepository.save(produto);
	}
	
	public void excluir(Integer id) {

		produtoRepository.deleteById(id);
	}	
}