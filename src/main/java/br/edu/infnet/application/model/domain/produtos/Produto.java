package br.edu.infnet.application.model.domain.produtos;

import br.edu.infnet.application.model.domain.Pedido;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tproduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private float valor;

    public Produto() {
    }

    public Produto(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f;%d",
                        nome,
                        valor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }



}
