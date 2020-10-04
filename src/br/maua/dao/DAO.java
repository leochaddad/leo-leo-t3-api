package br.maua.dao;

import br.maua.exceptions.NoEntryDB;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador de acesso do banco de dados.
 * Declara os métodos e atributos para manipulação do banco
 *
 * @param <T> objeto genérico para manipulação do banco.
 *
 */

public interface DAO <T> {

    String DATABASE = "medias.db";



    /**
     * Lista todos os itens cadastrados no banco de dados
     * @return lista com todos os itens da categoria
     */

    List<T> getAll();

    /**
     * Insere objeto de midia no banco de dados local
     * @param t parametro genérico para o objeto de procura no banco de dados
     */

    void insertEntry(T t) throws SQLException;

    /**
     * remove objeto de midia no banco de dados local
     * @param t parametro genérico para o objeto de procura no banco de dados
     */

    void deleteEntry(T t) throws SQLException;

    /**
     * recupera o objeto cadastrado no banco de dados por seu ID
     * @param ID número que representa a identidade de cadastro do objeto
     */

    T getEntryID(int ID) throws NoEntryDB;

    /**
     * recupera o objeto cadastrado no banco de dados por seu título
     * @param title nome do objeto cadastrado
     */

    T getEntryTitle(String title) throws NoEntryDB;
}
