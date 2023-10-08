package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Televisao;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.TelevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TelevisaoService {
	
	@Autowired
	private TelevisaoRepository televisaoRepository;

	public Collection<Televisao> obterLista(){
		
		return (Collection<Televisao>) televisaoRepository.findAll();
	}
	
	public Collection<Televisao> obterLista(Usuario usuario){
		
		return (Collection<Televisao>) televisaoRepository.obterLista(usuario.getId());
	}

	public void incluir(Televisao televisao) {

		televisaoRepository.save(televisao);
	}
	
	public void excluir(Integer id) {

		televisaoRepository.deleteById(id);
	}	
}