package br.edu.infnet.application;

import br.edu.infnet.application.model.domain.Requerente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Order(6)
@Component
public class MapLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
	
		Map<String, Requerente> userMap = new HashMap<>();
		userMap.put("111", new Requerente("maria", "111", "maria@maria.com"));
		userMap.put("123", new Requerente("jose", "123", "jose@jose.com"));
		userMap.put("234", new Requerente("aninha", "234", "ana@ana.com"));

		//recuperar as chaves do mapa
		userMap.keySet();

		//recuperar os valores do mapa
		userMap.values();

		//remover um valor através da chave
		userMap.remove("234");

		//recuperar um valor através da chave
		userMap.get("234");
	}
}