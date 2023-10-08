package br.edu.infnet.application.model.repository;

import br.edu.infnet.application.model.domain.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	@Query("from Pedido p where p.usuario.id = :userid")
	public List<Pedido> obterLista(Integer userid);
}