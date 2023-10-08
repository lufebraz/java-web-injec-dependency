package br.edu.infnet.application.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tusuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Requerente> requerentes;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Pedido> pedidos;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Produto> produtos;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idendereco")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
