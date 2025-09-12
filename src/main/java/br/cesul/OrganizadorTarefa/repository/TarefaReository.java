package br.cesul.OrganizadorTarefa.repository;

import br.cesul.OrganizadorTarefa.config.MongoConfig;
import br.cesul.OrganizadorTarefa.model.Tarefa;
import com.mongodb.client.MongoCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class TarefaReository {
    private final MongoCollection<Tarefa> col =
            MongoConfig.db.getCollection("tarefas", Tarefa.class);

    public ObservableList<Tarefa> findAll (){
        var list = FXCollections.<Tarefa>observableArrayList();
        col.find().sort(ascending("name"))
                .forEach(list::add);
        return list;
    }

    public void insert(Tarefa c){
        col.insertOne(c);
    }

    public void delete(Tarefa c){
        col.deleteOne(eq("_id", c.getId()));
    }

    public void update(Tarefa c) {
        col.replaceOne(eq("_id", c.getId()), c);
    }
}