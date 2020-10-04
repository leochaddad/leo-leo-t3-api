package br.maua.dao;

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
     */

    List<T> getAll();

    /**
     * Insere objeto de midia no banco de dados local
     * @param t parametro genérico para o objeto de procura no banco de dados
     */

    void insertEntry(T t);

    /**
     * remove objeto de midia no banco de dados local
     * @param t parametro genérico para o objeto de procura no banco de dados
     */

    void deleteEntry(T t);

    /**
     * recupera o objeto cadastrado no banco de dados por seu ID
     * @param ID número que representa a identidade de cadastro do objeto
     */

    T getEntryID(int ID);

    /**
     * recupera o objeto cadastrado no banco de dados por seu título
     * @param title nome do objeto cadastrado
     */

    T getEntryTitle(String title);
}
