package br.edu.infnet.application.model.repository;

import br.edu.infnet.application.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query("from Produto p where p.usuario.id = :userid")
	public List<Produto> obterLista(Integer userid);
}