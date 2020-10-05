package br.maua.dao;

import br.maua.exceptions.NoEntryDB;
import br.maua.models.Anime;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDAO implements DAO<Anime> {

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

        String query = String.format("SELECT * FROM Anime");

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


        String query = "INSERT INTO Anime (id, title, description, episodes, score, poster_url) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, anime.getId());
        ps.setString(2, anime.getTitle());
        ps.setString(3, anime.getDescription());
        ps.setInt(4, anime.getEpisodes());
        ps.setDouble(5, anime.getScore());
        ps.setString(6, anime.getPoster_url());

        ps.executeUpdate();

    }


    @Override
    public void deleteEntry(Anime anime) throws SQLException {

        String query = String.format(
                "DELETE FROM Anime WHERE id = %d",
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
    public ArrayList<Anime> getEntryTitle(String title) {

        ArrayList<Anime> animeList = new ArrayList<>();

        for (Anime anime : getAll())
        {
            if (anime.getTitle().toLowerCase().contains(title))
                animeList.add(anime);
        }


        return animeList;
    }

}
