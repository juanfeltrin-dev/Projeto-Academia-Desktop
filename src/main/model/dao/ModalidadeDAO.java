package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.ModalidadeVO;

public class ModalidadeDAO {
	public boolean inserir(ModalidadeVO modalidade) throws Exception
	{
		String sql 					= "INSERT INTO MODALIDADES(NOME) VALUES(?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		
		try {
			prepStmt.setString(1, modalidade.getNome());

			int codeReturn = prepStmt.executeUpdate();
			
			if (codeReturn == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir modalidade. Causa: \n:" + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
	
	public ArrayList<ModalidadeVO> consultarTodos()
	{
		String sql 							= "SELECT ID_MODALIDADE, NOME FROM MODALIDADES";
		Connection conexao 					= Database.getConnection();
		PreparedStatement prepStmt 			= Database.getPreparedStatement(conexao, sql);
		ArrayList<ModalidadeVO> modalidades = new ArrayList<ModalidadeVO>();
		
		try {
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()) {
				ModalidadeVO modalidade = new ModalidadeVO();
				modalidade.setId(rs.getInt("id_modalidade"));
				modalidade.setNome(rs.getString("nome"));
				modalidades.add(modalidade);
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao consultar modalidades. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return modalidades;
	}

	public boolean excluir(int id) throws Exception {
		String sql 							= "DELETE FROM modalidades WHERE id_modalidade = ?";
		Connection conexao 					= Database.getConnection();
		PreparedStatement prepStmt 			= Database.getPreparedStatement(conexao, sql);
		int resultado 						= 0; 
		
		try {
			prepStmt.setInt(1, id);
			
			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao excluir modalidade. Causa: \n:" + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
}
