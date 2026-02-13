package com.exemplo.bilbioteca.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";

    private static final String PASSWD = "mysqlPW";

    public static Connection conectar () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWD);
    }
}
