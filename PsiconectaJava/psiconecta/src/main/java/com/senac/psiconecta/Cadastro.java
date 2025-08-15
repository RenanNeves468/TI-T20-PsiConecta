package com.senac.psiconecta;
import com.senac.psiconecta.views.conn.Conexao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro {
    public void cadastrarAdmin(String nome, String email, String senha) throws SQLException{
    String sql = "INSERT INTO tbl_Usuarios (nome, email, senha) VALUES ( ?, ?, ?)";

        
        try(Connection con = Conexao.getConexao();PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.executeUpdate();
        }
    }
}
