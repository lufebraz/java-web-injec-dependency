package br.edu.infnet.application;

import br.edu.infnet.application.controller.CelularController;
import br.edu.infnet.application.model.domain.produtos.Celular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


@Order(1)
@Component
public class CelularLoader implements ApplicationRunner {

    @Autowired
    private CelularController celularController;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("arquivos/celular.txt"));

        String linha = reader.readLine();
        String[] campos = null;

        while
        (linha != null) {
            campos = linha.split(";");

            Celular celular = new Celular(
                    campos[0],
                    Float.parseFloat(campos[1]),
                    Integer.parseInt(campos[2]),
                    Integer.parseInt(campos[3]),
                    campos[4]
            );

            celularController.incluir(celular);
            linha = reader.readLine();
        }
    }
}