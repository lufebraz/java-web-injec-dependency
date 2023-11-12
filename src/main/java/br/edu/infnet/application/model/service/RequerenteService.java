package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.repository.RequerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RequerenteService {

    @Autowired
    private RequerenteRepository requerenteRepository;

    public Requerente incluir(Requerente requerente) {
        return requerenteRepository.save(requerente);
    }

    public boolean excluir(Integer id) {
        Optional<Requerente> byId = requerenteRepository.findById(id);
        if (byId.isPresent()) {
            requerenteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Collection<Requerente> obterLista(){
        return (Collection<Requerente>) requerenteRepository.findAll();
    }

    public Requerente obterPorId(int codigo) {
        Optional<Requerente> byId = requerenteRepository.findById(codigo);
        return byId.orElse(null);
    }

    public Requerente atualizarRequerente(Requerente requerente, int codigo) throws Exception {
        Optional<Requerente> requerenteOptional = requerenteRepository.findById(codigo);
        if (requerenteOptional.isPresent()) {
            requerente.setId(codigo);
            return requerenteRepository.save(requerente);
        } else {
            return null;
        }

    }
}
