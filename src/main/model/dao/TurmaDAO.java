package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import model.vo.TurmaVO;

public class TurmaDAO {
	public int inserir(TurmaVO turmaVO)
	{
		String sql 					= "INSERT INTO TURMAS(NOME, QUANTIDADE_VAGAS, ID_INSTRUTOR, ID_MODALIDADE) VALUES(?, ?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		int id						= 0;
		
		try {
			prepStmt.setString(1, turmaVO.getNome());
			prepStmt.setInt(2, turmaVO.getQuantidadeVagas());
			prepStmt.setInt(3, turmaVO.getInstrutor().getId());
			prepStmt.setInt(4, turmaVO.getModalidade().getId());

			int codeReturn = prepStmt.executeUpdate();
			
			if(codeReturn == Database.CODE_RETURN_SUCCESS) {
				ResultSet rs 	= prepStmt.getGeneratedKeys();
				id 				= rs.getInt(1);
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir turma. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return id;
	}
	
	public boolean inserirHorarios(int turmaId, int diaSemanaId, LocalTime hora)
	{
		String sql 					= "INSERT INTO DIA_SEMANA_TURMAS(ID_TURMA, ID_DIA_SEMANA, HORA) VALUES(?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		int codeReturn				= 0;
		
		try {
			prepStmt.setInt(1, turmaId);
			prepStmt.setInt(2, diaSemanaId);
			Time horaTurma = java.sql.Time.valueOf(hora);		
			prepStmt.setTime(3, horaTurma);

			codeReturn = prepStmt.executeUpdate();
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir horário da turma. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return codeReturn == Database.CODE_RETURN_SUCCESS;
	}
	
	public boolean verificaSeExisteHorario(int diaSemanaId, LocalTime hora)
	{
		String sql 					= "SELECT ID_TURMA FROM DIA_SEMANA_TURMAS "
									+ "WHERE ID_DIA_SEMANA = ? AND "
									+ "HORA = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		boolean existe				= false;
		
		try {
			prepStmt.setInt(1, diaSemanaId);
			Time horaTurma = java.sql.Time.valueOf(hora);		
			prepStmt.setTime(2, horaTurma);

			ResultSet rs = prepStmt.executeQuery();
			
			existe = rs.next();
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir horário da turma. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return existe;
	}
	
	public int buscarIdPeloNome(String nome)
	{
		String sql					= "SELECT ID_TURMA FROM TURMAS WHERE NOME = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		int id						= 0;
		
		try {
			prepStmt.setString(1, nome);
			ResultSet rs = prepStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar id da turma pelo nome.\nCausa: " + e.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return id;
	}
}
