package br.cesul.OrganizadorTarefa.view;

import br.cesul.OrganizadorTarefa.commands.CommandAdicionar;
import br.cesul.OrganizadorTarefa.commands.CommandAtualizar;
import br.cesul.OrganizadorTarefa.commands.CommandRemover;
import br.cesul.OrganizadorTarefa.model.Tarefa;
import br.cesul.OrganizadorTarefa.view_model.TarefaViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class TarefaView {

    @FXML private TextField tfNome;
    @FXML private TextField tfTarefa;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> prioridade;
    @FXML private ComboBox<String> status;
    @FXML private Button btnAdicionar;
    @FXML private Button btnRemover;
    @FXML private Button btnAtualizar;
    @FXML private Button btnUndo;
    @FXML private Button btnRedo;
    @FXML private TableView<Tarefa> tableView;
    @FXML private TableColumn<Tarefa, String> nameCol;
    @FXML private TableColumn<Tarefa, String> tarefaCol;
    @FXML private TableColumn<Tarefa, LocalDate> dateCol;
    @FXML private TableColumn<Tarefa, String> statusCol;
    @FXML private TableColumn<Tarefa, String> prioridadeCol;

    private final TarefaViewModel vm = new TarefaViewModel();

    @FXML
    private void initialize() {
        // Inicializar ComboBoxes
        prioridade.getItems().addAll("Alta", "Média", "Baixa");
        status.getItems().addAll("Pendente", "Em andamento", "Concluída");

        // Configuração das colunas da TableView
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tarefaCol.setCellValueFactory(new PropertyValueFactory<>("tarefa"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        prioridadeCol.setCellValueFactory(new PropertyValueFactory<>("prioridade"));

        // Ligar a lista observável do ViewModel à TableView
        tableView.setItems(vm.getTarefas());

        // Botão Adicionar
        btnAdicionar.setOnAction(e -> {
                vm.executarCommand(new CommandAdicionar(tableView.getSelectionModel().getSelectedItem(), vm.getTarefas(), vm));
        });

        // Botão Remover
        btnRemover.setOnAction(e -> {
            Tarefa selecionada = tableView.getSelectionModel().getSelectedItem();
            if (selecionada != null) {
                vm.executarCommand(new CommandRemover(selecionada, vm.getTarefas(), vm));
            }
        });

        // Botão Atualizar
        btnAtualizar.setOnAction(e -> {
            Tarefa selecionada = tableView.getSelectionModel().getSelectedItem();
            if (selecionada != null) {
                String nome = tfNome.getText();
                String tarefaNome = tfTarefa.getText();
                LocalDate data = datePicker.getValue();
                String stat = status.getSelectionModel().getSelectedItem();
                String prior = prioridade.getSelectionModel().getSelectedItem();

                if (!nome.isBlank() && !tarefaNome.isBlank() && data != null
                        && stat != null && prior != null) {

                    Tarefa novaTarefa = new Tarefa(nome, tarefaNome, data, prior, stat);
                    vm.executarCommand(new CommandAtualizar(selecionada, novaTarefa, vm.getTarefas(), vm));
                    limparCampos();
                }
            }
        });

        // Undo / Redo
        btnUndo.setOnAction(e -> vm.undo());
        btnRedo.setOnAction(e -> vm.redo());
    }

    private void limparCampos() {
        tfNome.clear();
        tfTarefa.clear();
        datePicker.setValue(null);
        status.setValue(null);
        prioridade.setValue(null);
    }
}
