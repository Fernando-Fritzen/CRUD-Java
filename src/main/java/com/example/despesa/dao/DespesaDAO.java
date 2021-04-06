package com.example.despesa.dao;

import com.example.despesa.factory.ConnectionFactory;
import com.example.despesa.model.Despesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DespesaDAO {

    private Connection connection;

    public DespesaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraDespesa(Despesa d) {
        String sql = "insert into despesas" +
                " (id, nome, valor, idCategoria, descricao) " +
                "values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getNome());
            stmt.setDouble(3, d.getPreco());
            stmt.setInt(4, d.getIdCategoria());
            stmt.setString(5, d.getDescricao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listaDespesas() {
        String sql = "select * from despesas";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet despesas = stmt.executeQuery();

            while (despesas.next()) {
                System.out.println(despesas.getInt("id"));
                System.out.println(despesas.getString("nome"));
                System.out.println(despesas.getDouble("valor"));
                System.out.println(despesas.getInt("idCategoria"));
                System.out.println(despesas.getString("descricao"));
                System.out.println("====================================");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alteraDespesa(Despesa d) {

        String sql = "update despesas set nome=?, valor=?, idCategoria=?," +
                "descricao=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, d.getNome());
            stmt.setDouble(2, d.getPreco());
            stmt.setInt(3, d.getIdCategoria());
            stmt.setString(4, d.getDescricao());
            stmt.setLong(5, d.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarDespesa(Despesa d) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from despesas where id=?");
            stmt.setInt(1, d.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
