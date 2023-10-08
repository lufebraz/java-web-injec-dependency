package br.edu.infnet.application;

import br.edu.infnet.application.model.domain.Requerente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
@Component
public class RequerenteLoarder implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Requerente requerente = new Requerente();

        System.out.println("inclusao com sucesso " + requerente);
    }
}
