package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Notebook;
import br.edu.infnet.application.model.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class NotebookService {
	
	@Autowired
	private NotebookRepository notebookRepository;

	public Notebook incluir(Notebook notebook) {
		return notebookRepository.save(notebook);
	}

	public boolean excluir(Integer id) {
		Optional<Notebook> byId = notebookRepository.findById(id);
		if (byId.isPresent()) {
			notebookRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Collection<Notebook> obterLista(){
		return (Collection<Notebook>) notebookRepository.findAll();
	}

	public Notebook obterPorId(int codigo) {
		Optional<Notebook> byId = notebookRepository.findById(codigo);
		return byId.orElse(null);
	}

	public Notebook atualizarNotebook(Notebook notebook, int codigo) throws Exception {
		Optional<Notebook> notebookOptional = notebookRepository.findById(codigo);
		if (notebookOptional.isPresent()) {
			notebook.setId(codigo);
			return notebookRepository.save(notebook);
		} else {
			return null;
		}

	}
}