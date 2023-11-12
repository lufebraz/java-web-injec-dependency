package br.edu.infnet.application.model.domain;

import br.edu.infnet.application.model.domain.produtos.Produto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tpedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDateTime data;
    private boolean web;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idRequerente")
    private Requerente requerente;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Produto> produtoList;

    public Pedido(Requerente requerente, List<Produto> produtoList) {
        this.descricao = "Pedido inicial";
        this.data = LocalDateTime.now();
        this.web = true;
        this.requerente = requerente;
        this.produtoList = produtoList;
    }

    public Pedido() {

    }

    public Pedido(String descricao, Requerente requerente, List<Produto> produtoList) {
        this();
        this.descricao = descricao;
        this.requerente = requerente;
        this.produtoList = produtoList;
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + web + ";" + requerente + ";" + produtoList.size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public Requerente getRequerente() {
        return requerente;
    }

    public void setRequerente(Requerente requerente) {
        this.requerente = requerente;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }


}
