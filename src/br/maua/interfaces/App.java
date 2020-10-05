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

public class App {

    public static AnimeDAO animeDAO = new AnimeDAO();
    public static MangaDAO mangaDAO = new MangaDAO();

    public static void printResults(ArrayList<IMedia> results){
        results.forEach(res -> {
            System.out.println("[ID: "+res.getId()+"] - " + res.getTitle());
        });
    }

    private static final AvailableAction Quit = ()->{
        System.out.println("Goodbye");
        System.exit(0);
    };

    private static final AvailableAction SearchAnime = ()->{
        boolean inDatabase = true;
        ArrayList<IMedia> searchResults = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the title of the anime: ");
        String title = scanner.nextLine();
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

    private static final AvailableAction SearchManga = ()->{
        boolean inDatabase = true;
        ArrayList<IMedia> searchResults = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the title of the manga: ");
        String title = scanner.nextLine();
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
            manga  = Parser.parseManga(GetAPI.getMedia(MediaType.ANIME, id));
            mangaDAO.insertEntry(manga);
        }
        System.out.println(manga);
    };

    private static final AvailableAction ViewDB = ()->{
        System.out.println("Look at the database!!!");
    };

    private static final AvailableAction[] actions = {Quit, SearchAnime, SearchManga, ViewDB};

    public static void Start() {
        Menu.title();
        while(true){
            int instruction = Menu.Instructions();
            try {
                actions[instruction].Perform();
            }catch (NullPointerException | NoEntryDB | SQLException e){
                e.printStackTrace();
            }
        }
    }


}

