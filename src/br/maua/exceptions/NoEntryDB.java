package br.maua.exceptions;

/**
 * Se o objeto procurado não estiver no banco de dados local, retorna um ERRO
 */

public class NoEntryDB extends Exception {

    public NoEntryDB(){};

    public NoEntryDB(String message){

        super(message);
    }

}
