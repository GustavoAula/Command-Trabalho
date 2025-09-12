package br.cesul.OrganizadorTarefa.view_model;

import br.cesul.OrganizadorTarefa.model.Tarefa;
import br.cesul.OrganizadorTarefa.repository.TarefaReository;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.time.LocalDate;

public class ViewModel {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty tarefa = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>(LocalDate.now());
    private final ObjectProperty<ComboBox> prioridade = new SimpleObjectProperty<>();
    private final ObjectProperty<ComboBox> status = new SimpleObjectProperty<>();

    private final ObservableList<Tarefa> commands = FXCollections.observableArrayList();

    private final TarefaReository repo = new TarefaReository();

    public ViewModel(){
        commands.addAll(repo.findAll());

        commands.addListener((ListChangeListener<? super Tarefa>) change ->{
            while (change.next()){
                if(change.wasAdded()){
                    change.getAddedSubList().forEach(repo::insert);
                }
                if(change.wasUpdated()){
                    change.getList().forEach(repo::update);
                }
                if(change.wasRemoved()){
                    change.getRemoved().forEach(repo::delete);
                }
            }
        });

    }

    // Getters de propriedades para permitir bindings na view
    public StringProperty nameProperty() {return name;}
    public StringProperty tarefeProperty() {return tarefa;}
    public ObjectProperty<LocalDate> dateProperty() {return date;}
    public ObjectProperty<ComboBox> prioridadeProperty() {return prioridade;}
    public ObjectProperty<ComboBox> statusProperty() {return status;}
    public ObservableList<Tarefa> getCommands() {return commands;}
}
