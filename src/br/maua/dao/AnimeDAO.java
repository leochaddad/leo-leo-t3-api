package br.maua.dao;

import br.maua.exceptions.NoEntryDB;
import br.maua.models.Anime;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDAO implements DAO<Anime> {

    private String TABLENAME = "Anime";
    private Connection conn;

    public AnimeDAO(){


        // Estabelecendo conexão com o banco de dados

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DATABASE);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Anime> getAll()
    {

        List<Anime> animeList = new ArrayList<>();

        String query = String.format("SELECT * FROM %s", TABLENAME);

        try {

            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery(query);

            while(res.next())
            {
                Anime anime = new Anime(
                        res.getInt("id"),
                        res.getString("title"),
                        res.getString("description"),
                        res.getInt("episodes"),
                        res.getDouble("score"),
                        res.getString("poster_url")
                );

                animeList.add(anime);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return animeList;
    }


    @Override
    public void insertEntry(Anime anime) throws SQLException {

        String query = String.format(
                "INSERT INTO %s (id, title, description, episodes, score, poster_url) VALUES (%d, '%s\', '%s\', %d, %f, '%s\')",
                TABLENAME,
                anime.getId(),
                anime.getTitle(),
                anime.getDescription(),
                anime.getEpisodes(),
                anime.getScore(),
                anime.getPoster_url()
        );

        PreparedStatement ps = conn.prepareStatement(query);

        ps.executeUpdate();

    }


    @Override
    public void deleteEntry(Anime anime) throws SQLException {

        String query = String.format(
                "DELETE FROM %s WHERE id = %d",
                TABLENAME,
                anime.getId()
        );

        PreparedStatement ps = conn.prepareStatement(query);

        ps.executeUpdate();
    }

    @Override
    public Anime getEntryID(int ID) throws NoEntryDB {

        for (Anime anime : getAll())
        {
            if (ID == anime.getId()) return anime;
        }

        throw new NoEntryDB();
    }

    @Override
    public Anime getEntryTitle(String title) throws NoEntryDB {

        for (Anime anime : getAll())
        {
            if (title.equals(anime.getTitle().toLowerCase()))
                return anime;
        }

        throw new NoEntryDB();
    }

}
