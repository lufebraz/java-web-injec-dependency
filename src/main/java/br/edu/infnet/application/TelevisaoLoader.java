package br.edu.infnet.application;

import br.edu.infnet.application.model.domain.produtos.Televisao;
import br.edu.infnet.application.model.service.TelevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


@Order(3)
@Component
public class TelevisaoLoader implements ApplicationRunner {

    @Autowired
    private TelevisaoService televisaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("arquivos/televisao.txt"));

        String linha = reader.readLine();
        String[] campos = null;

        while
        (linha != null) {
            campos = linha.split(";");

            Televisao televisao = new Televisao(
                    campos[0],
                    Float.parseFloat(campos[1]),
                    campos[2],
                    Boolean.parseBoolean(campos[3]),
                    campos[4]
            );

            televisaoService.incluir(televisao);
            linha = reader.readLine();
        }
    }
}