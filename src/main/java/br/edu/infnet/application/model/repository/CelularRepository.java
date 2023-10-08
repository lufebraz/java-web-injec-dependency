package br.edu.infnet.application.model.repository;

import br.edu.infnet.application.model.domain.produtos.Celular;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelularRepository extends CrudRepository<Celular, Integer> {

	@Query("from Celular b where b.usuario.id = :userid")
	public List<Celular> obterLista(Integer userid);
}