/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eders
 */
public class Conexao {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Drive");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbveiculos", "postgres", "");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erro: " + e);
            return (null);
        }
    }
}
