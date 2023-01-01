package com.culysoft.sistemausuarios.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    private Integer id;
    private String login;
    private String senha;
    private String nome;

    private LocalDateTime ultimoAcesso;

    @ManyToOne
    private Dominio dominio;

//    @OneToOne(mappedBy = "usuario")
//    private Configuracao configuracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

//    public Configuracao getConfiguracao() {
//        return configuracao;
//    }
//
//    public void setConfiguracao(Configuracao configuracao) {
//        this.configuracao = configuracao;
//    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
