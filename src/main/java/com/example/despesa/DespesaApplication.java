package com.example.despesa;

import com.example.despesa.dao.DespesaDAO;
import com.example.despesa.factory.ConnectionFactory;
import com.example.despesa.model.Despesa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DespesaApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		SpringApplication.run(DespesaApplication.class, args);

		Connection c = new ConnectionFactory().getConnection();

		System.out.println("Conectou");



		Despesa d = new Despesa(10, "abcd", 1055, 9, "abcdhi");
		DespesaDAO dd = new DespesaDAO();
		dd.cadastraDespesa(d);
		dd.listaDespesas();
		dd.alteraDespesa(d);
		dd.deletarDespesa(d);

		c.close();

	}

}
