package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Celular;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CelularService {
	
	@Autowired
	private CelularRepository celularRepository;

	public Collection<Celular> obterLista(){
		
		return (Collection<Celular>) celularRepository.findAll();
	}
	
	public Collection<Celular> obterLista(Usuario usuario){
		
		return (Collection<Celular>) celularRepository.obterLista(usuario.getId());
	}

	public void incluir(Celular celular) {

		celularRepository.save(celular);
	}
	
	public void excluir(Integer id) {

		celularRepository.deleteById(id);
	}	
}