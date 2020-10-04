package br.maua.interfaces;

import br.maua.exceptions.NoEntryDB;

import java.sql.SQLException;

public interface AvailableAction {
    void Perform() throws NoEntryDB, SQLException;
}
