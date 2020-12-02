package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.vo.PessoaVO;

public class PessoaDAO {
	public int inserir(PessoaVO pessoa) throws Exception
	{
		String sql 					= "INSERT INTO PESSOAS(cpf, nome, nascimento, sexo, telefone, celular, email, bairro, cidade, estado, cep) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatementWithGeneratedKeys(conexao, sql);
		int result 					= 0;
		
		try {
			prepStmt.setString(1, pessoa.getCpf());
			prepStmt.setString(2, pessoa.getNome());
			Date nascimento = java.sql.Date.valueOf(pessoa.getNascimento());
			prepStmt.setDate(3, nascimento);
			prepStmt.setString(4, String.valueOf(pessoa.getSexo()));
			prepStmt.setString(5, pessoa.getTelefone());
			prepStmt.setString(6, pessoa.getCelular());
			prepStmt.setString(7, pessoa.getEmail());
			prepStmt.setString(8, pessoa.getBairro());
			prepStmt.setString(9, pessoa.getCidade());
			prepStmt.setString(10, pessoa.getEstado());
			prepStmt.setString(11, pessoa.getCep());
			prepStmt.executeUpdate();
			
			ResultSet rs 	= prepStmt.getGeneratedKeys();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir pessoa. Causa: \n:" + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closeStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return result;
	}
	
	public boolean alterar(PessoaVO pessoa) throws Exception
	{
		String sql 					= "UPDATE PESSOAS SET TELEFONE = ?, CELULAR = ?, EMAIL = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, CEP = ? "
									+ "WHERE ID_PESSOA = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 				= 0;

		try {
			prepStmt.setString(1, pessoa.getTelefone());
			prepStmt.setString(2, pessoa.getCelular());
			prepStmt.setString(3, pessoa.getEmail());
			prepStmt.setString(4, pessoa.getBairro());
			prepStmt.setString(5, pessoa.getCidade());
			prepStmt.setString(6, pessoa.getEstado());
			prepStmt.setString(7, pessoa.getCep());
			prepStmt.setInt(8, pessoa.getPessoaId());
		
			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de alteração da pessoa.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return false;
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
	
	public boolean validaSeCpfExiste(String cpf) throws Exception
	{
		String sql					= "SELECT CPF FROM PESSOAS WHERE CPF = '" + cpf + "'";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado 		= null;

		try {
//			prepStmt.setString(1, cpf);

			resultado = prepStmt.executeQuery(sql);
			
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("\nErro ao executar a Query que verifica existência de pessoa por CPF.");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage() + "\n" + exception.getLocalizedMessage() + "\n" + exception.getStackTrace().toString());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
}
