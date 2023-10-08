package br.edu.infnet.application;

import br.edu.infnet.application.model.domain.produtos.Celular;
import br.edu.infnet.application.model.domain.Pedido;
import br.edu.infnet.application.model.domain.Produto;
import br.edu.infnet.application.model.domain.Requerente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Order(5)
@Component
public class PedidoLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Requerente requerente = new Requerente("NOME", "123123123", "123123@213123");
        Celular celular = new Celular( "iphone",3000,2,128,3,"ios" );

        List<Produto> produtoList = new ArrayList<Produto>();
        produtoList.add(celular);

        Pedido pedido = new Pedido(requerente, produtoList);
        System.out.println("inclusao com sucesso "+ pedido);
    }
}