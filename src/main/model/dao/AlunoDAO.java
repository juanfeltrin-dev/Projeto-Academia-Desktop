package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.AlunoVO;

public class AlunoDAO {
	public int inserir(AlunoVO aluno, int pessoaId)
	{
		String sql 			= "INSERT INTO ALUNOS(id_pessoa, observacoes, data_matricula, matricula, id_turma) "
				+ "VALUES(?, ?, ?, ?, ?)";
		Connection conn 	= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 		= 0;
		
		try {
			prepStmt.setInt(1, pessoaId);
			prepStmt.setString(2, aluno.getObservacao());
			Date matricula = java.sql.Date.valueOf(aluno.getDataMatricula());
			prepStmt.setDate(3, matricula);
			prepStmt.setString(4, aluno.getMatricula());
			prepStmt.setInt(5, aluno.getTurma().getId());
			
			resultado = prepStmt.executeUpdate(sql);
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de cadastro do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return resultado;
	}
	
	public boolean login(int cpf)
	{
		String sql = "SELECT ALUNOS.ID_ALUNO FROM PESSOAS "
				+ "INNER JOIN ALUNOS ON ALUNOS.ID_PESSOA = PESSOAS.ID_PESSOA "
				+ "WHERE PESSOA.CPF = ?";

		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		
		try {
			prepStmt.setInt(1, cpf);

			resultado = prepStmt.executeQuery();

			if(resultado.next()) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que verifica existência de aluno por CPF.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
}
