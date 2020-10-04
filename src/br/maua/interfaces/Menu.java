package br.maua.interfaces;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");

                System.out.println("Welcome, please choose an option: ");
        System.out.println("->->->->->->->->->->->->-");
        System.out.println("[1] Search for Animes.");
        System.out.println("[2] Search for Mangas.");
        System.out.println("[3] View current database.");
        System.out.println("[0] Quit");
        System.out.println("<*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*>\n");
        return scanner.nextInt();
    }

    private static final AvailableAction Quit = ()->{
        System.out.println("Goodbye");
        System.exit(0);
    };

    private static final AvailableAction SearchAnime = ()->{
        System.out.println("Searched Anime");


    };

    private static final AvailableAction SearchManga = ()->{
        System.out.println("Searched Manga");
    };

    private static final AvailableAction ViewDB = ()->{
        System.out.println("Look at the database!!!");
    };

    private static final AvailableAction[] actions = {Quit, SearchAnime, SearchManga, ViewDB};

    public static void start() {
        title();
        while(true){
            int instruction = Instructions();
            try {
                actions[instruction].Perform();
            }catch (NullPointerException e){
                System.out.println("This option is invalid");
            }
        }
    }

}
