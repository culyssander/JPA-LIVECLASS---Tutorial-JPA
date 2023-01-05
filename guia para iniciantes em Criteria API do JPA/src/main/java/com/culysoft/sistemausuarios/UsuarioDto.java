package com.culysoft.sistemausuarios;

public class UsuarioDto {
    private Integer id;
    private String login;
    private String nome;

    public UsuarioDto(Integer id, String login, String nome) {
        this.id = id;
        this.login = login;
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
