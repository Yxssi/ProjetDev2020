package controller;

import java.sql.*;
import java.util.ArrayList;


public class databseElements {
    public static Connection getConnection() {
        Connection connection = null;
        // ------------------------------
        String url = "jdbc:mysql://localhost:8889/GameDev" + "?autoReconnect=true&useSSL=false";
        String user = "yessi";
        String pwd = "azerty!!!";
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ------------------------------
        return connection;

    }

    public static int selectScoreLuffy() {
        int Score = 0;

        Connection connection = getConnection();
        // ------------------------------
        String requete = "select * from score where id=1";
        try {
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = state.executeQuery(requete);
            while (result.next()) {
                Score = result.getInt("Score");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ------------------------------
        return Score;
    }


    public static int selectScoreNaruto() {
        int Score = 0;

        Connection connection = getConnection();
        // ------------------------------
        String requete = "select * from score where id=2";
        try {
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = state.executeQuery(requete);
            while (result.next()) {
                Score = result.getInt("Score");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ------------------------------
        return Score;
    }

}

   // public static int selectForce()



