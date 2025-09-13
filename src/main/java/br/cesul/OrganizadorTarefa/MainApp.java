package br.cesul.OrganizadorTarefa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/cesul/OrganizadorTarefa/Tarefa.fxml"));
        Parent root = loader.load();

        stage.setScene(new Scene(root));
        stage.setTitle("Organizador Tarefa - MVVM - Command");
        stage.show();
    }

    public static void main( String[] args )
    {
        launch();
    }
}