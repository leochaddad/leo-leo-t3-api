package br.maua.dao;

import br.maua.models.Anime;
import java.sql.*;
import java.util.List;

public class AnimeDAO implements DAO<Anime> {

    private String TABLENAME = "Anime";
    private Connection conn;

    public AnimeDAO(){

        try {
            conn = DriverManager.getConnection("jdbc:sqlite" + DATABASE);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Anime> getAll()
    {
        String query = String.format("SELECT * FROM %s", TABLENAME);

        try {

            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery(query);

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

}
