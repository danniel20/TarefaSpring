package br.com.tarefa.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull(message = "{usuario.login.vazio}")
    @Size(min = 3, message = "{usuario.login.pequeno}")
    private String login;

    @NotNull(message = "{usuario.senha.vazia}")
    @Size(min = 3, message = "{usuario.senha.pequena}")
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
