package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.vo.ModalidadeVO;

public class ModalidadeDAO {
	public boolean inserir(ModalidadeVO modalidade)
	{
		String sql 					= "INSERT INTO MODALIDADES VALUES(?)";
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
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
}
