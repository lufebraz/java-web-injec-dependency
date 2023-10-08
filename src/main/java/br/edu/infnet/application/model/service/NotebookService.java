package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Notebook;
import br.edu.infnet.application.model.domain.Usuario;
import br.edu.infnet.application.model.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NotebookService {
	
	@Autowired
	private NotebookRepository notebookRepository;

	public Collection<Notebook> obterLista(){
		
		return (Collection<Notebook>) notebookRepository.findAll();
	}
	
	public Collection<Notebook> obterLista(Usuario usuario){
		
		return (Collection<Notebook>) notebookRepository.obterLista(usuario.getId());
	}

	public void incluir(Notebook notebook) {

		notebookRepository.save(notebook);
	}
	
	public void excluir(Integer id) {

		notebookRepository.deleteById(id);
	}	
}