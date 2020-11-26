package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import model.vo.AlunoVO;
import model.vo.TurmaVO;

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
	
	public boolean login(String cpf)
	{
		String sql = "SELECT ALUNOS.ID_ALUNO FROM PESSOAS "
				+ "INNER JOIN ALUNOS ON ALUNOS.ID_PESSOA = PESSOAS.ID_PESSOA "
				+ "WHERE PESSOAS.CPF = ?";

		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		
		try {
			prepStmt.setString(1, cpf);

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
	
	public LocalTime obterHorarioTurma(String cpf)
	{
		String sql = "SELECT TURMAS.HORARIO FROM ALUNOS "
				+ "INNER JOIN PESSOAS ON ALUNOS.ID_PESSOA = PESSOAS.ID_PESSOA "
				+ "INNER JOIN TURMAS ON ALUNOS.ID_TURMA = TURMAS.ID_TURMA "
				+ "WHERE PESSOAS.CPF = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		LocalTime horario			= null;
		
		try {
			prepStmt.setString(1, cpf);
			resultado = prepStmt.executeQuery();
			
			if (resultado.next()) {
				Time horarioSQL = resultado.getTime(1);
				horario 		= horarioSQL.toLocalTime();
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que obtem horário da turma do aluno pelo CPF.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return horario;
	}
	
	public void realizarCheckIn(int alunoId, int turmaId, LocalDateTime horario)
	{
		String sql 					= "INSERT INTO CHECK_IN(ID_ALUNO, ID_TURMA, HORARIO) VALUES(?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		
		try {
			prepStmt.setInt(1, alunoId);
			prepStmt.setInt(2, turmaId);
			Timestamp  horarioChegada = Timestamp.valueOf(horario);
			prepStmt.setTimestamp(3, horarioChegada);
			resultado = prepStmt.executeQuery();
			
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que realizar o check-in do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
	}
}
