package br.edu.infnet.application.model.repository;

import br.edu.infnet.application.model.domain.Requerente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequerenteRepository extends CrudRepository<Requerente, Integer> {


}
