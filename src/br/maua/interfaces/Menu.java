package br.maua.interfaces;

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

    public static void Instructions() {
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");
        System.out.println("Bem-vindo(a), por favor selecione uma opção: ");
        System.out.println("->->->->->->->->->->->->-");
        System.out.println("[1] Pesquisar Animes.");
        System.out.println("[2] Pesquisar Mangas.");
        System.out.println("[3] Ver o banco de dados atual.");
        System.out.println("[0] Sair");
        System.out.println("<*><*><*><*><*><*><*><*><*>\n");



    }

    public  static  void showManga(){
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");
        System.out.println("                      MANGAS                              ");
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");
    }

    public  static  void showAnime(){
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");
        System.out.println("                      ANIME                               ");
        System.out.println("=^..^=  =^..^=  =^..^=   =^..^=   =^..^=   =^..^=   =^..^=");
    }


    public static void Goodbye(){
        System.out.println("Até mais!!!");
    }


}
