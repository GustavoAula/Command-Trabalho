package br.cesul.Command.model;

import javafx.scene.control.ComboBox;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Command {
    private ObjectId id;
    private String nome;
    private String tarefa;
    private LocalDate date;
    private ComboBox<String> prioridade;
    private ComboBox<String> status;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ComboBox<String> getStatus() {
        return status;
    }

    public void setStatus(ComboBox<String> status) {
        this.status = status;
    }

    public ComboBox<String> getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(ComboBox<String> prioridade) {
        this.prioridade = prioridade;
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

    public Command(String nome, String tarefa, LocalDate date, ComboBox prioridade, ComboBox status){
        this.nome = nome;
        this.tarefa = tarefa;
        this.date = date;
        this.prioridade = prioridade;
        this.status = status;
    }


}
