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
				result 			= rs.getInt(1);
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir pessoa. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return result;
	}
	
	public boolean alterar(PessoaVO pessoa)
	{
		String sql 					= "UPDATE PESSOAS SET NOME = ?, NASCIMENTO = ?, SEXO = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, CEP = ? "
				+ "WHERE PESSOA_ID = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);		
		boolean alterou 			= false;
		
		try {
			prepStmt.setString(1, pessoa.getNome());
			Date nascimento = java.sql.Date.valueOf(pessoa.getNascimento());
			prepStmt.setDate(2, nascimento);
			prepStmt.setLong(3, pessoa.getSexo());
			prepStmt.setString(4, pessoa.getTelefone());
			prepStmt.setString(5, pessoa.getCelular());
			prepStmt.setString(6, pessoa.getEmail());
			prepStmt.setString(7, pessoa.getBairro());
			prepStmt.setString(8, pessoa.getCidade());
			prepStmt.setLong(9, pessoa.getEstado());
			prepStmt.setString(10, pessoa.getCep());
			prepStmt.setInt(10, pessoa.getPessoaId());
		
			ResultSet rs 	= prepStmt.executeQuery();
			alterou 		= rs.next();
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de alteração da pessoa.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return alterou;
	}
	
	public boolean excluir(int id)
	{
		String sql 					= "DELETE FROM PESSOAS WHERE ID_PESSOA = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);		
		boolean excluiu 			= false;
		
		try {
			prepStmt.setInt(1, id);
			
			ResultSet rs 	= prepStmt.executeQuery();
			excluiu 		= rs.next();
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de exclusão da pessoa.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return excluiu;
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
