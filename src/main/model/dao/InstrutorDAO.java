package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.AlunoVO;
import model.vo.InstrutorVO;

public class InstrutorDAO {
	public boolean inserir(InstrutorVO instrutor, int pessoaId) throws Exception
	{
		String sql 					= "INSERT INTO INSTRUTORES(id_pessoa, data_admissao, salario) "
									+ "VALUES(?, ?, ?)";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 				= 0;

		try {
			prepStmt.setInt(1, pessoaId);
			Date dataAdmissao = java.sql.Date.valueOf(instrutor.getDataAdmissao());
			prepStmt.setDate(2, dataAdmissao);
			prepStmt.setDouble(3, instrutor.getSalario());
			
			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de cadastro de instrutor.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return false;
	}
	
	public boolean alterar(InstrutorVO instrutor)
	{
		String sql 					= "UPDATE INSTRUTORES SET SALARIO = ? "
									+ "WHERE ID_INSTRUTOR = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);		
		boolean alterou 			= false;
		
		try {
			prepStmt.setDouble(1, instrutor.getSalario());
			
			ResultSet rs 	= prepStmt.executeQuery();
			alterou 		= rs.next();
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de alteração do instrutor.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return alterou;
	}
	
	public InstrutorVO buscarPeloCpf(String cpf) throws Exception {
		String sql 					= "SELECT pessoas.email, pessoas.telefone, pessoas.celular, pessoas.cep, pessoas.bairro, pessoas.cidade, pessoas.estado, pessoas.id_pessoa "
									+ "FROM pessoas "
									+ "INNER JOIN instrutores ON pessoas.id_pessoa = instrutores.id_pessoa "
									+ "WHERE pessoas.cpf = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		InstrutorVO instrutor		= new InstrutorVO();
		
		try {
			prepStmt.setString(1, cpf);

			resultado = prepStmt.executeQuery();

			if(resultado.next()) {
				instrutor.setEmail(resultado.getString(1));
				instrutor.setTelefone(resultado.getString(2));
				instrutor.setCelular(resultado.getString(3));
				instrutor.setCep(resultado.getString(4));
				instrutor.setBairro(resultado.getString(5));
				instrutor.setCidade(resultado.getString(6));
				instrutor.setEstado(resultado.getString(7));
				instrutor.setPessoaId(resultado.getInt(8));
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que busca pessoa pelo CPF.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return instrutor;
	}
}
