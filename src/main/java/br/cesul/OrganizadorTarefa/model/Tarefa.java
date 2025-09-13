package br.cesul.OrganizadorTarefa.model;

import javafx.scene.control.ComboBox;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Tarefa {
    private ObjectId id;
    private String nome;
    private String tarefa;
    private LocalDate date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    private String prioridade;
    private String status;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }


    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tarefa(String nome, String tarefa, LocalDate date, String prioridade, String status){
        this.nome = nome;
        this.tarefa = tarefa;
        this.date = date;
        this.prioridade = prioridade;
        this.status = status;
    }
}
