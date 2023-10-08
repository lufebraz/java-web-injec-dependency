package br.edu.infnet.application.model.repository;

import br.edu.infnet.application.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
}