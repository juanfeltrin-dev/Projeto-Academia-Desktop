package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import model.vo.PessoaVO;

public class PessoaDAO {
	public int inserir(PessoaVO pessoa)
	{
		String sql 					= "INSERT INTO PESSOAS(cpf, nome, nascimento, sexo, telefone, celular, email, bairro, cidade, estado, cep) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		int result 					= 0;
		
		try {
			prepStmt.setString(1, pessoa.getCpf());
			prepStmt.setString(2, pessoa.getNome());
			Date nascimento = java.sql.Date.valueOf(pessoa.getNascimento());
			prepStmt.setDate(3, nascimento);
			prepStmt.setLong(4, pessoa.getSexo());
			prepStmt.setString(5, pessoa.getTelefone());
			prepStmt.setString(6, pessoa.getCelular());
			prepStmt.setString(7, pessoa.getEmail());
			prepStmt.setString(8, pessoa.getBairro());
			prepStmt.setString(9, pessoa.getCidade());
			prepStmt.setLong(10, pessoa.getEstado());
			prepStmt.setString(11, pessoa.getCep());

			result = prepStmt.executeUpdate();
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir pessoa. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return result;
	}
}
