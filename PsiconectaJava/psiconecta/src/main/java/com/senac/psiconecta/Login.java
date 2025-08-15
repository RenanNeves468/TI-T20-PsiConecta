package com.senac.psiconecta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private Connection conexao;

    // Construtor que recebe a conexão com o banco
    public Login(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para validar login
    public boolean validarLogin(String email, String senha) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tbl_Usuarios WHERE email = ? AND senha = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha); // idealmente, a senha deve estar criptografada
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }
}
