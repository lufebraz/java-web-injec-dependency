package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Celular;
import br.edu.infnet.application.model.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CelularService {

	@Autowired
	private CelularRepository celularRepository;

	public Celular incluir(Celular celular) {
		return celularRepository.save(celular);
	}

	public boolean excluir(Integer id) {
		Optional<Celular> byId = celularRepository.findById(id);
		if (byId.isPresent()) {
			celularRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Collection<Celular> obterLista(){
		return (Collection<Celular>) celularRepository.findAll();
	}

	public Celular obterPorId(int codigo) {
		Optional<Celular> byId = celularRepository.findById(codigo);
        return byId.orElse(null);
	}

	public Celular atualizarCelular(Celular celular, int codigo) throws Exception {
		Optional<Celular> celularOptional = celularRepository.findById(codigo);
		if (celularOptional.isPresent()) {
			celular.setId(codigo);
			return celularRepository.save(celular);
		} else {
			return null;
		}

	}
}