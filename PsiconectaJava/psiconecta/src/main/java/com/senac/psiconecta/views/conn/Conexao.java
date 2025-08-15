package com.senac.psiconecta.views.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //MÉTODO PARA OBTER A CONEXÃO
    public static Connection getConexao() throws SQLException{
        final String SERVIDOR = "jdbc:sqlserver://127.0.0.1:1433;databaseName=painel_admin_db;encrypt=false;trustServerCertificate=true";
        final String USUARIO = "sa";
        final String SENHA = "pw_user_app";
        
        return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
    }
}
