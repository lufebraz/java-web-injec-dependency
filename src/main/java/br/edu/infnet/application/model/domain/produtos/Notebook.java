package br.edu.infnet.application.model.domain.produtos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tnotebook")
public class Notebook extends Produto {

    private String processador;
    private String memoriaRam;
    private boolean placaDeVideo;

    public Notebook(String nome, float valor, String processador, String memoriaRam, boolean placaDeVideo) {
        super(nome, valor);
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.placaDeVideo = placaDeVideo;
    }

    public Notebook() {

    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s",
                super.toString(),
                processador,
                memoriaRam,
                placaDeVideo);
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public boolean isPlacaDeVideo() {
        return placaDeVideo;
    }

    public void setPlacaDeVideo(boolean placaDeVideo) {
        this.placaDeVideo = placaDeVideo;
    }
}
