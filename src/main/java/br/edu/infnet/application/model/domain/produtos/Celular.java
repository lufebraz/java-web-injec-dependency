package br.edu.infnet.application.model.domain.produtos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tcelular")
public class Celular extends Produto {

    private int armazenamento;
    private int quantidadeCameras;
    private String sistemaOperacional;

    public Celular(String nome, float valor, int armazenamento, int quantidadeCameras, String sistemaOperacional) {
        super(nome, valor);
        this.armazenamento = armazenamento;
        this.quantidadeCameras = quantidadeCameras;
        this.sistemaOperacional = sistemaOperacional;
    }

    public Celular() {

    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%s",
                super.toString(),
                armazenamento,
                quantidadeCameras,
                sistemaOperacional);
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public int getQuantidadeCameras() {
        return quantidadeCameras;
    }

    public void setQuantidadeCameras(int quantidadeCameras) {
        this.quantidadeCameras = quantidadeCameras;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
}
