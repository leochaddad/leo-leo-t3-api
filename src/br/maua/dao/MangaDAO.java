package br.maua.dao;

import br.maua.exceptions.NoEntryDB;
import br.maua.models.Anime;
import br.maua.models.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaDAO implements DAO<Manga> {

    private String TABLENAME = "Manga";
    private Connection conn;

    public MangaDAO(){


        // Estabelecendo conexão com o banco de dados

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Manga> getAll()
    {

        List<Manga> mangaList = new ArrayList<>();

        String query = String.format("SELECT * FROM %s", TABLENAME);

        try {

            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery(query);

            while(res.next())
            {
                Manga manga = new Manga(
                        res.getInt("id"),
                        res.getString("title"),
                        res.getString("description"),
                        res.getString("type"),
                        res.getInt("chapters"),
                        res.getInt("volumes"),
                        res.getDouble("score"),
                        res.getString("poster_url")
                );

                mangaList.add(manga);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return mangaList;
    }


    @Override
    public void insertEntry(Manga manga) throws SQLException {

        String query = String.format(
                "INSERT INTO %s (id, title, description, type, chapter, volume, score, poster_url) " +
                        "VALUES (%d, '%s\', '%s\', '%s\', %d, %d, %f, '%s\')",
                TABLENAME,
                manga.getId(),
                manga.getTitle(),
                manga.getDescription(),
                manga.getType(),
                manga.getChapters(),
                manga.getVolumes(),
                manga.getScore(),
                manga.getPoster_url()
        );

        PreparedStatement ps = conn.prepareStatement(query);

        ps.executeUpdate();

    }


    @Override
    public void deleteEntry(Manga manga) throws SQLException {

        String query = String.format(
                "DELETE FROM %s WHERE id = %d",
                TABLENAME,
                manga.getId()
        );

        PreparedStatement ps = conn.prepareStatement(query);

        ps.executeUpdate();
    }

    @Override
    public Manga getEntryID(int ID) throws NoEntryDB {

        for (Manga manga : getAll())
        {
            if (ID == manga.getId()) return manga;
        }

        throw new NoEntryDB();
    }

    @Override
    public ArrayList<Manga> getEntryTitle(String title)  {

        ArrayList<Manga> mangaList = new ArrayList<>();

        for (Manga manga : getAll())
        {
            if (manga.getTitle().toLowerCase().contains(title))
                mangaList.add(manga);
        }


        return mangaList;
    }


}
