package com.culysoft.destrinchandojpql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Configuracao {

    @Id
    private Integer id;

    @MapsId
    @OneToOne
    private Usuario usuario;

    private boolean receberNotificacoes;
    private boolean encerrarSessaoAutomatica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isReceberNotificacoes() {
        return receberNotificacoes;
    }

    public void setReceberNotificacoes(boolean receberNotificacoes) {
        this.receberNotificacoes = receberNotificacoes;
    }

    public boolean isEncerrarSessaoAutomatica() {
        return encerrarSessaoAutomatica;
    }

    public void setEncerrarSessaoAutomatica(boolean encerrarSessaoAutomatica) {
        this.encerrarSessaoAutomatica = encerrarSessaoAutomatica;
    }
}
