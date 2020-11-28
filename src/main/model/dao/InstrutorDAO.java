package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.InstrutorVO;

public class InstrutorDAO {
	public int inserir(InstrutorVO instrutor, int pessoaId)
	{
		String sql 			= "INSERT INTO INSTRUTORES(id_pessoa, data_admissao, salario) "
				+ "VALUES(?, ?, ?)";
		Connection conn 	= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 		= 0;
		
		try {
			prepStmt.setInt(1, pessoaId);
			Date dataAdmissao = java.sql.Date.valueOf(instrutor.getDataAdmissao());
			prepStmt.setDate(2, dataAdmissao);
			prepStmt.setDouble(3, instrutor.getSalario());
			
			resultado = prepStmt.executeUpdate(sql);
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de cadastro de instrutor.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return resultado;
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
}
