package br.edu.infnet.application.model.domain;

import javax.persistence.*;

@Entity
@Table(name ="trequerente")
public class Requerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Requerente() {
    }

    public Requerente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s",
                nome,
                cpf,
                email);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
