package br.edu.infnet.application;

import br.edu.infnet.application.controller.NotebookController;
import br.edu.infnet.application.model.domain.produtos.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


@Order(2)
@Component
public class NotebookLoader implements ApplicationRunner {

    @Autowired
    private NotebookController notebookController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("arquivos/notebook.txt"));

        String linha = reader.readLine();
        String[] campos = null;

        while
        (linha != null) {
            campos = linha.split(";");

            Notebook notebook = new Notebook(
                    campos[0],
                    Float.parseFloat(campos[1]),
                    campos[2],
                    campos[3],
                    Boolean.parseBoolean(campos[4])
            );

            notebookController.incluir(notebook);
            linha = reader.readLine();
        }
    }
}