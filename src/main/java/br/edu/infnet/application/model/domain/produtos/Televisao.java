package br.edu.infnet.application.model.domain.produtos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ttelevisao")
public class Televisao extends Produto {

    private String polegadas;
    private boolean smartTv;
    private String marca;

    public Televisao() {
    }

    public Televisao(String nome, float valor, String polegadas, boolean smartTv, String marca) {
        super(nome, valor);
        this.polegadas = polegadas;
        this.smartTv = smartTv;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s",
                super.toString(),
                polegadas,
                smartTv,
                marca);
    }

    public String getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(String polegadas) {
        this.polegadas = polegadas;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
