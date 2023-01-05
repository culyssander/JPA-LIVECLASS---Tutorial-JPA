package com.culysoft.sistemausuarios.model;

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
    private boolean encerrarSessaoAutomaticamento;

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

    public boolean isEncerrarSessaoAutomaticamento() {
        return encerrarSessaoAutomaticamento;
    }

    public void setEncerrarSessaoAutomaticamento(boolean encerrarSessaoAutomaticamento) {
        this.encerrarSessaoAutomaticamento = encerrarSessaoAutomaticamento;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "usuario=" + usuario +
                ", receberNotificacoes=" + receberNotificacoes +
                ", encerrarSessaoAutomaticamento=" + encerrarSessaoAutomaticamento +
                '}';
    }
}
