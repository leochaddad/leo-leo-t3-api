package br.maua.interfaces;

import br.maua.api.GetAPI;
import br.maua.dao.AnimeDAO;
import br.maua.dao.MangaDAO;
import br.maua.exceptions.NoEntryDB;
import br.maua.json.Parser;
import br.maua.models.Anime;
import br.maua.models.Manga;
import br.maua.models.MediaType;
import br.maua.utils.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static br.maua.interfaces.Menu.*;

public class App {

    private static AnimeDAO animeDAO = new AnimeDAO();
    private static MangaDAO mangaDAO = new MangaDAO();

    private static  String promptTitle(String helperText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(helperText);
        String text = scanner.nextLine();
        while (!Utils.validadeText(text)) {
            System.out.println("Entrada ilegal");
            System.out.println(helperText);
            text = scanner.nextLine();
        }
        return text;
    }

    private static  int promptOption( ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Opção: ");
        String option = scanner.nextLine();
        while (!Utils.validateOption(option)){
            System.out.println("Opção Ilegal");
            System.out.println("Opção: ");
            option = scanner.nextLine();
        }
        return Integer.parseInt(option);
    }

    /**
     * Displays search results formatted with ID for user to choose
     * @param results List of objects implementing IMedia (with title and id)
     */
    public static void printResults(ArrayList<IMedia> results){
        results.forEach(res -> {
            System.out.println("[ID: "+res.getId()+"] - " + res.getTitle());
        });
    }

    /**
     * Prints goodbye and ends the program with a success code
     */
    private static final AvailableAction Quit = ()->{
        Goodbye();
        System.exit(0);
    };

    /**
     * Prompts user for anime title, searches the local database and if nothing is found searches the API.
     * Lists the result and prompts user for the anime's ID. Then prints the result, and adds the anime to the DB if it wasn't already present.
     */
    private static final AvailableAction SearchAnime = ()->{
        boolean inDatabase = true;
        ArrayList<IMedia> searchResults = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String title = App.promptTitle("Type the title of the anime: ");

        searchResults.addAll(animeDAO.getEntryTitle(title));

        if(searchResults.isEmpty()){
            inDatabase = false;
            String json = GetAPI.search(MediaType.ANIME, title, 10);
            searchResults.addAll(Parser.parseSearchResults(json));
        }

        printResults(searchResults);

        System.out.println("Digite o Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Anime anime;
        if(inDatabase){
            anime = animeDAO.getEntryID(id);
        }
        else {
            anime  = Parser.parseAnime(GetAPI.getMedia(MediaType.ANIME, id));
            System.out.println("ANIME: " + anime);
            animeDAO.insertEntry(anime);
        }
        System.out.println("ANIME: " + anime);
    };

    /**
     * Prompts user for manga title, searches the local database and if nothing is found searches the API.
     * Lists the result and prompts user for the anime's ID. Then prints the result, and adds the manga to the DB if it wasn't already present.
     */
    private static final AvailableAction SearchManga = ()->{
        boolean inDatabase = true;
        ArrayList<IMedia> searchResults = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String title = App.promptTitle("Type the title of the manga: ");
        searchResults.addAll(mangaDAO.getEntryTitle(title));
        if(searchResults.isEmpty()){
            inDatabase = false;
            String json = GetAPI.search(MediaType.MANGA, title, 10);
            searchResults.addAll(Parser.parseSearchResults(json));
        }
        searchResults.forEach(res -> {
            System.out.println("[ID: "+res.getId()+"] - " + res.getTitle());
        });

        System.out.println("Digite o Id: ");
        int id = Integer.parseInt(scanner.nextLine());

        Manga manga;
        if(inDatabase){
            manga = mangaDAO.getEntryID(id);
        }
        else {
            manga  = Parser.parseManga(GetAPI.getMedia(MediaType.MANGA, id));
            mangaDAO.insertEntry(manga);
        }
        System.out.println(manga);
    };

    /**
     * Displays all media currently in the database
     */
    private static final AvailableAction ViewDB = ()->{

        showAnime();
        for (Anime anime : animeDAO.getAll())
            System.out.println(anime.getId() + " " + anime.getTitle());

        showManga();
        for (Manga manga : mangaDAO.getAll())
            System.out.println(manga.getId() + " " + manga.getTitle());

    };

    /**
     * Array of arrow functions (AvailableMedia) with indices corresponding to the menu's listing
     */
    private static final AvailableAction[] actions = {Quit, SearchAnime, SearchManga, ViewDB};

    /**
     * Main method for the application
     * Displays the title, and prompts user for one of the available action until the user quits the program
     */
    public static void Start() {
        Menu.title();
        while(true){
            Menu.Instructions();
            int instruction = App.promptOption();
            try {
                actions[instruction].Perform();
            }catch (NullPointerException | NoEntryDB | SQLException e){
                e.printStackTrace();
            }
        }
    }


}

