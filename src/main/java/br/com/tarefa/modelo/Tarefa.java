package br.com.tarefa.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "{tarefa.descricao.vazia}")
    @Size(min = 5, message = "{tarefa.descricao.pequena}")
    private String descricao;

    private boolean finalizado;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dataFinalizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
