package br.cesul.OrganizadorTarefa.commands;

import br.cesul.OrganizadorTarefa.model.Tarefa;
import br.cesul.OrganizadorTarefa.repository.TarefaRepository;
import br.cesul.OrganizadorTarefa.view_model.TarefaViewModel;
import javafx.collections.ObservableList;

public class CommandRemover implements Command {
    private final Tarefa tarefa;
    private final ObservableList<Tarefa> tarefas;
    private final TarefaViewModel vm;

    public CommandRemover(Tarefa tarefa, ObservableList<Tarefa> tarefas, TarefaViewModel vm) {
        this.tarefa = tarefa;
        this.tarefas = tarefas;
        this.vm = vm;
    }

    @Override
    public void executar() {
        tarefas.remove(tarefa);
        vm.removerTarefa(tarefa);
    }

    @Override
    public void undo() {
        tarefas.add(tarefa);
        vm.adicionarTarefa(tarefa);
    }
}
