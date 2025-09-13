package br.cesul.OrganizadorTarefa.commands;

import br.cesul.OrganizadorTarefa.model.Tarefa;
import br.cesul.OrganizadorTarefa.repository.TarefaRepository;
import br.cesul.OrganizadorTarefa.view_model.TarefaViewModel;
import javafx.collections.ObservableList;

public class CommandAdicionar implements Command {
    private final Tarefa tarefa;
    private final ObservableList<Tarefa> tarefas;
    private final TarefaViewModel vm;

    public CommandAdicionar(Tarefa tarefa, ObservableList<Tarefa> tarefas, TarefaViewModel vm) {
        this.tarefa = tarefa;
        this.tarefas = tarefas;
        this.vm = vm;
    }

    @Override
    public void executar() {
        tarefas.addFirst(tarefa);
        vm.adicionarTarefa(tarefa);
    }

    @Override
    public void undo() {
        tarefas.remove(tarefa);
        vm.removerTarefa(tarefa);
    }
}
