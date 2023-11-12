package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.produtos.Televisao;
import br.edu.infnet.application.model.repository.TelevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TelevisaoService {
	
	@Autowired
	private TelevisaoRepository televisaoRepository;

	public Televisao incluir(Televisao televisao) {
		return televisaoRepository.save(televisao);
	}

	public boolean excluir(Integer id) {
		Optional<Televisao> byId = televisaoRepository.findById(id);
		if (byId.isPresent()) {
			televisaoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Collection<Televisao> obterLista(){
		return (Collection<Televisao>) televisaoRepository.findAll();
	}

	public Televisao obterPorId(int codigo) {
		Optional<Televisao> byId = televisaoRepository.findById(codigo);
		return byId.orElse(null);
	}

	public Televisao atualizarTelevisao(Televisao televisao, int codigo) throws Exception {
		Optional<Televisao> televisaoOptional = televisaoRepository.findById(codigo);
		if (televisaoOptional.isPresent()) {
			televisao.setId(codigo);
			return televisaoRepository.save(televisao);
		} else {
			return null;
		}

	}	
}