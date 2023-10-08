package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.repository.RequerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RequerenteService {
    
    @Autowired
    private RequerenteRepository requerenteRepository;

    public Collection<Requerente> obterLista(){

        return (Collection<Requerente>) requerenteRepository.findAll();
    }

    public void incluir(Requerente requerente) {

        requerenteRepository.save(requerente);
    }

    public void excluir(Integer id) {

        requerenteRepository.deleteById(id);
    }
}
