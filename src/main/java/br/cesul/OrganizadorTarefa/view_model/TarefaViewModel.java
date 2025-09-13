package br.cesul.OrganizadorTarefa.view_model;

import br.cesul.OrganizadorTarefa.commands.Command;
import br.cesul.OrganizadorTarefa.model.Tarefa;
import br.cesul.OrganizadorTarefa.repository.TarefaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Stack;

public class TarefaViewModel {
    private final TarefaRepository repo = new TarefaRepository();
    private final ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();

    private final Stack<Command> undoPilha = new Stack<>();
    private final Stack<Command> redoPilha = new Stack<>();

    public TarefaViewModel() {
        tarefas.addAll(repo.findAll());
    }

    public ObservableList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void executarCommand(Command cmd) {
        cmd.executar();
        undoPilha.push(cmd);
        redoPilha.clear();
    }

    public void undo() {
        if (!undoPilha.isEmpty()) {
            Command cmd = undoPilha.pop();
            cmd.undo();
            redoPilha.push(cmd);
        }
    }

    public void redo() {
        if (!redoPilha.isEmpty()) {
            Command cmd = redoPilha.pop();
            cmd.executar();
            undoPilha.push(cmd);
        }
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        repo.insert(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {

        repo.delete(tarefa);
    }

    public void atualizarTarefa(Tarefa tarefa) {
        repo.update(tarefa);
    }
}
