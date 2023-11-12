package br.edu.infnet.application;

import br.edu.infnet.application.controller.PedidoController;
import br.edu.infnet.application.model.domain.*;
import br.edu.infnet.application.model.domain.produtos.Celular;
import br.edu.infnet.application.model.domain.produtos.Notebook;
import br.edu.infnet.application.model.domain.produtos.Produto;
import br.edu.infnet.application.model.domain.produtos.Televisao;
import br.edu.infnet.application.model.service.PedidoService;
import br.edu.infnet.application.model.service.RequerenteService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Order(5)
@Component
public class PedidoLoader implements ApplicationRunner {
	
	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private RequerenteService requerenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Map<LocalDateTime, Pedido> mapaPedido = new HashMap<LocalDateTime, Pedido>();
		
		FileReader file = new FileReader("arquivos/pedido.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		Pedido pedido = null;		
		
		while(linha != null) {
			campos = linha.split(";"); 

			switch (campos[0]) {
			case "P":		
								
				pedido = new Pedido(
						campos[1],
						requerenteService.incluir(new Requerente(campos[2], campos[3], campos[4])),
						new ArrayList<Produto>()
					);

				pedidoService.incluir(pedido);

				break;

			case "C":
				Celular celular = new Celular(
						campos[1],
						Float.parseFloat(campos[2]),
						Integer.parseInt(campos[3]),
						Integer.parseInt(campos[4]),
						campos[5]
				);
				
				pedido.getProdutoList().add(celular);
				
				break;

			case "N":

				Notebook notebook = new Notebook(
						campos[1],
						Float.parseFloat(campos[2]),
						campos[3],
						campos[4],
						Boolean.parseBoolean(campos[5])
				);
				
				pedido.getProdutoList().add(notebook);
				
				break;

			case "T":

				Televisao televisao = new Televisao(
						campos[1],
						Float.parseFloat(campos[2]),
						campos[3],
						Boolean.parseBoolean(campos[4]),
						campos[5]
				);
				
				pedido.getProdutoList().add(televisao);

				break;

			default:
				break;
			}
			
			linha = leitura.readLine();
		}

		for(Pedido p : mapaPedido.values()) {
			System.out.println("[Pedido] Inclusão realizada com sucesso: " + p);			
		}

		leitura.close();			
	}

}