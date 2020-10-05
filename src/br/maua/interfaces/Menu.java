package br.maua.interfaces;

import br.maua.api.GetAPI;
import br.maua.dao.AnimeDAO;
import br.maua.dao.MangaDAO;
import br.maua.exceptions.NoEntryDB;
import br.maua.json.Parser;
import br.maua.models.Anime;
import br.maua.models.Manga;
import br.maua.models.MediaType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {



    public static void title() {
        System.out.println("\n" +
                "                 _                                    \n" +
                " _ __ ___   __ _(_)_ __    _ __ ___   ___ _ __  _   _ \n" +
                "| '_ ` _ \\ / _` | | '_ \\  | '_ ` _ \\ / _ | '_ \\| | | |\n" +
                "| | | | | | (_| | | | | | | | | | | |  __| | | | |_| |\n" +
                "|_| |_| |_|\\__,_|_|_| |_| |_| |_| |_|\\___|_| |_|\\__,_|\n" +
                "                                                      \n");
    }

    public static int Instructions() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");
        System.out.println("Welcome, please choose an option: ");
        System.out.println("->->->->->->->->->->->->-");
        System.out.println("[1] Search for Animes.");
        System.out.println("[2] Search for Mangas.");
        System.out.println("[3] View current database.");
        System.out.println("[0] Quit");
        System.out.println("<*><*><*><*><*><*><*><*><*>\n");
        int option = Integer.parseInt(scanner1.nextLine());

        return option;

    }



}
