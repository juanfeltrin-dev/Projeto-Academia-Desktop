package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.vo.AlunoVO;
import model.vo.TurmaVO;

public class AlunoDAO {
	public boolean inserir(AlunoVO aluno, int pessoaId) throws Exception
	{
		String sql 					= "INSERT INTO ALUNOS(id_pessoa, observacoes, data_matricula, matricula, id_turma) "
									+ "VALUES(?, ?, ?, ?, ?)";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 				= 0;

		try {
			prepStmt.setInt(1, pessoaId);
			prepStmt.setString(2, aluno.getObservacao());
			Date matricula = java.sql.Date.valueOf(LocalDate.now());
			prepStmt.setDate(3, matricula);
			prepStmt.setString(4, aluno.getMatricula());
			prepStmt.setInt(5, aluno.getTurma().getId());
			
			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de cadastro do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return false;
	}
	
	public boolean alterar(AlunoVO aluno) throws Exception
	{
		String sql 					= "UPDATE ALUNOS SET OBSERVACOES = ?, DATA_MATRICULA = ?, MATRICULA = ?, ID_TURMA = ? "
									+ "WHERE ID_ALUNO = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);		
		boolean alterou 			= false;
		
		try {
			prepStmt.setString(1, aluno.getObservacao());
			Date matricula = java.sql.Date.valueOf(aluno.getDataMatricula());
			prepStmt.setDate(2, matricula);
			prepStmt.setString(3, aluno.getMatricula());
			prepStmt.setInt(4, aluno.getTurma().getId());
			
			ResultSet rs 	= prepStmt.executeQuery();
			alterou 		= rs.next();
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de alteração do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());

			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return alterou;
	}
	
	public boolean excluir(int id) throws Exception
	{
		String sql 					= "DELETE FROM ALUNOS WHERE ID_ALUNO = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 				= 0;
		
		try {
			prepStmt.setInt(1, id);

			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de exclusão do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());

			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return false;
	}
	
	public boolean excluirCheckIn(int idAluno) throws Exception
	{
		String sql 					= "DELETE FROM CHECK_IN WHERE ID_ALUNO = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		int resultado 				= 0;
		
		try {
			prepStmt.setInt(1, idAluno);

			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de exclusão de check-in do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());

			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return false;
	}
	
	public int consultarIdPessoa(int idAluno) throws Exception
	{
		String sql 					= "SELECT id_pessoa FROM alunos "
									+ "WHERE id_aluno = ?";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		
		try {
			prepStmt.setInt(1, idAluno);
			
			ResultSet rs = prepStmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de consultar id pessoa do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());

			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return 0;
	}
	
	public ArrayList<AlunoVO> consultarAlunos()
	{
		String sql 					= "SELECT alunos.id_aluno, pessoas.nome FROM alunos "
									+ "INNER JOIN pessoas ON alunos.id_pessoa = pessoas.id_pessoa ";
		Connection conn 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conn, sql);
		ArrayList<AlunoVO> alunos	= new ArrayList<AlunoVO>();
		
		try {			
			ResultSet rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				AlunoVO aluno = new AlunoVO();
				
				aluno.setId(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				alunos.add(aluno);
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query de consultar alunos.\n");
			System.out.println("Erro: " + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conn);
		}
		
		return alunos;
	}
	
	public AlunoVO login(String cpf) throws Exception
	{
		String sql = "SELECT ALUNOS.ID_ALUNO, PESSOAS.CPF FROM PESSOAS "
				+ "INNER JOIN ALUNOS ON ALUNOS.ID_PESSOA = PESSOAS.ID_PESSOA "
				+ "WHERE PESSOAS.CPF = ?";

		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		AlunoVO alunoVO				= new AlunoVO();
		alunoVO.setLogado(false);
		
		try {
			prepStmt.setString(1, cpf);

			resultado = prepStmt.executeQuery();

			if(resultado.next()) {
				System.out.println(resultado.getInt(1));
				alunoVO.setId(resultado.getInt(1));
				alunoVO.setCpf(resultado.getString(2));
				alunoVO.setLogado(true);
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que verifica existência de aluno por CPF.\n");
			System.out.println("Erro: " + exception.getMessage());

			throw new SQLException(exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return alunoVO;
	}
	
	public TurmaVO obterHorarioTurma(int alunoId, int diaDaSemana) throws Exception
	{
		String sql = "SELECT TURMAS.id_turma, DIA_SEMANA_TURMAS.HORA FROM ALUNOS "
				+ "INNER JOIN PESSOAS ON ALUNOS.ID_PESSOA = PESSOAS.ID_PESSOA "
				+ "INNER JOIN TURMAS ON ALUNOS.ID_TURMA = TURMAS.ID_TURMA "
				+ "INNER JOIN DIA_SEMANA_TURMAS ON TURMAS.ID_TURMA = DIA_SEMANA_TURMAS.ID_TURMA "
				+ "INNER JOIN DIAS_SEMANA ON DIA_SEMANA_TURMAS.ID_DIA_SEMANA = DIAS_SEMANA.ID_DIA_SEMANA "
				+ "WHERE ALUNOS.ID_ALUNO = ? AND "
				+ "DIAS_SEMANA.ID_DIA_SEMANA = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		TurmaVO turmaVO 			= new TurmaVO();
		LocalTime horario			= null;
		
		try {
			prepStmt.setInt(1, alunoId);
			prepStmt.setInt(2, diaDaSemana);
			
			resultado = prepStmt.executeQuery();
			
			if (resultado.next()) {				
				turmaVO.setId(resultado.getInt(1));
				
				Time horarioSQL = resultado.getTime(2);
				horario 		= horarioSQL.toLocalTime();
				turmaVO.setHorario(horario);
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que obtem horário da turma do aluno pelo CPF.\n");
			System.out.println("Erro: " + exception.getMessage());

			throw new Exception(exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return turmaVO;
	}
	
	public boolean realizarCheckIn(int alunoId, int turmaId, LocalDate data, LocalTime hora) throws Exception
	{
		String sql 					= "INSERT INTO CHECK_IN(ID_ALUNO, ID_TURMA, DATA, HORA) VALUES(?, ?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		int resultado				= 0;
		
		try {
			Date dataCheckIn = java.sql.Date.valueOf(data);
			Time horaCheckIn = java.sql.Time.valueOf(hora);			
			
			prepStmt.setInt(1, alunoId);
			prepStmt.setInt(2, turmaId);
			prepStmt.setDate(3, dataCheckIn);
			prepStmt.setTime(4, horaCheckIn);
			
			resultado = prepStmt.executeUpdate();

			if(resultado == Database.CODE_RETURN_SUCCESS) {
				return true;
			}			
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que realiza o check-in do aluno.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
	
	public boolean verificaSeTreinouHoje(int alunoId, LocalDate data) throws Exception
	{
		String sql = "SELECT ALUNOS.ID_ALUNO FROM ALUNOS "
				+ "INNER JOIN CHECK_IN ON ALUNOS.ID_ALUNO = CHECK_IN.ID_ALUNO "
				+ "WHERE ALUNOS.ID_ALUNO = ? AND "
				+ "CHECK_IN.DATA = ?";

		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		
		try {
			prepStmt.setInt(1, alunoId);
			Date dataCheckIn = java.sql.Date.valueOf(data);
			prepStmt.setDate(2, dataCheckIn);

			resultado = prepStmt.executeQuery();

			if(resultado.next()) {
				return true;
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que verifica existência de aluno por CPF.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return false;
	}
	
	public AlunoVO buscarPeloCpf(String cpf) throws Exception {
		String sql 					= "SELECT pessoas.email, pessoas.telefone, pessoas.celular, pessoas.cep, pessoas.bairro, pessoas.cidade, pessoas.estado, pessoas.id_pessoa "
									+ "FROM pessoas "
									+ "INNER JOIN alunos ON pessoas.id_pessoa = alunos.id_pessoa "
									+ "WHERE pessoas.cpf = ?";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatement(conexao, sql);
		ResultSet resultado			= null;
		AlunoVO aluno				= new AlunoVO();
		
		try {
			prepStmt.setString(1, cpf);

			resultado = prepStmt.executeQuery();

			if(resultado.next()) {
				aluno.setEmail(resultado.getString(1));
				aluno.setTelefone(resultado.getString(2));
				aluno.setCelular(resultado.getString(3));
				aluno.setCep(resultado.getString(4));
				aluno.setBairro(resultado.getString(5));
				aluno.setCidade(resultado.getString(6));
				aluno.setEstado(resultado.getString(7));
				aluno.setPessoaId(resultado.getInt(8));
			}
		} catch (SQLException exception) {
			System.out.println("Erro ao executar a query que buscar aluno pelo CPF.\n");
			System.out.println("Erro: " + exception.getMessage());
			
			throw new Exception(exception.getMessage());
		} finally {
			Database.closeResultSet(resultado);
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return aluno;
	}
}
