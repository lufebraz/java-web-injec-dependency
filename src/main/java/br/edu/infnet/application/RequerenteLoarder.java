package br.edu.infnet.application;

import br.edu.infnet.application.model.domain.Requerente;
import br.edu.infnet.application.model.service.RequerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class RequerenteLoarder implements ApplicationRunner {

    @Autowired
    private RequerenteService requerenteService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("arquivos/requerente.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Requerente requerente = new Requerente();
            requerente.setNome(campos[0]);
            requerente.setCpf(campos[1]);
            requerente.setEmail(campos[2]);

            requerenteService.incluir(requerente);

            linha = leitura.readLine();
        }

        leitura.close();
    }
}
