package br.cesul.OrganizadorTarefa.commands;

import br.cesul.OrganizadorTarefa.model.Tarefa;
import br.cesul.OrganizadorTarefa.repository.TarefaRepository;
import br.cesul.OrganizadorTarefa.view_model.TarefaViewModel;
import javafx.collections.ObservableList;

public class CommandAtualizar implements Command {
    private final Tarefa oldTarefa;
    private final Tarefa newTarefa;
    private final ObservableList<Tarefa> tarefas;
    private final TarefaViewModel vm;

    public CommandAtualizar(Tarefa oldTarefa, Tarefa newTarefa,
                               ObservableList<Tarefa> tarefas, TarefaViewModel vm) {
        this.oldTarefa = oldTarefa;
        this.newTarefa = newTarefa;
        this.tarefas = tarefas;
        this.vm = vm;
    }

    @Override
    public void executar() {
        int indice = tarefas.indexOf(oldTarefa);
        if (indice >= 0) {
            tarefas.set(indice, newTarefa);
            vm.atualizarTarefa(newTarefa);
        }
    }

    @Override
    public void undo() {
        int indice = tarefas.indexOf(newTarefa);
        if (indice >= 0) {
            tarefas.set(indice, oldTarefa);
            vm.atualizarTarefa(oldTarefa);
        }
    }
}
