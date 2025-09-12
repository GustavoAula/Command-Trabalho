package br.cesul.Command.repository;

import br.cesul.Command.config.MongoConfig;
import br.cesul.Command.model.Command;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class CommandRepository {
    private final MongoCollection<Command> col =
            MongoConfig.db.getCollection("commands", Command.class);

    public ObservableList<Command> findAll (){
        var list = FXCollections.<Command>observableArrayList();
        col.find().sort(ascending("name"))
                .forEach(list::add);
        return list;
    }

    public void insert(Command c){
        col.insertOne(c);
    }

    public void delete(Command c){
        col.deleteOne(eq("_id", c.getId()));
    }

    public void update(Command c) {
        col.replaceOne(eq("_id", c.getId()), c);
    }
}