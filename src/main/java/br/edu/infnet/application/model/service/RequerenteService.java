package br.edu.infnet.application.model.service;

import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.domain.Usuario;
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

    public Collection<Requerente> obterLista(Usuario usuario){

        return (Collection<Requerente>) requerenteRepository.obterLista(usuario.getId());
    }
    public Requerente incluir(Requerente requerente) {

        return requerenteRepository.save(requerente);
    }

    public void excluir(Integer id) {

        requerenteRepository.deleteById(id);
    }
}
