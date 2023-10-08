package br.edu.infnet.application.model.domain;

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
    private int codigo;

    @ManyToMany(mappedBy = "produtoList")
    private List<Pedido> pedidos;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Produto() {
    }

    public Produto(String nome, float valor, int codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f;%d",
                        nome,
                        valor,
                        codigo);
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
