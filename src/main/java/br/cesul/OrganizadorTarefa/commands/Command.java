package br.cesul.OrganizadorTarefa.commands;

public interface Command {
    void executar();
    void undo();
}