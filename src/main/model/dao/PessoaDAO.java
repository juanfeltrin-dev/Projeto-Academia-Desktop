package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

			int codeReturn = prepStmt.executeUpdate();
			
			if(codeReturn == Database.CODE_RETURN_SUCCESS) {
				ResultSet rs 	= prepStmt.getGeneratedKeys();
				result = rs.getInt(1);
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir pessoa. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return result;
	}
	
	public boolean validaSeCpfExiste(String cpf)
	{
		String sql					= "SELECT CPF FROM PESSOA WHERE CPF = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado 		= null;
		
		try {
			prepStmt.setString(1, cpf);

			resultado = prepStmt.executeQuery(sql);
			
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("\nErro ao executar a Query que verifica existência de pessoa por CPF.");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
}
