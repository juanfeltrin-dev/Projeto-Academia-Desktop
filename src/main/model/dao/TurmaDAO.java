package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import model.vo.AlunoVO;
import model.vo.ModalidadeVO;
import model.vo.TurmaVO;

public class TurmaDAO {
	public int inserir(TurmaVO turmaVO)
	{
		String sql 					= "INSERT INTO TURMAS(NOME, QUANTIDADE_VAGAS, ID_INSTRUTOR, ID_MODALIDADE) VALUES(?, ?, ?, ?)";
		Connection conexao 			= Database.getConnection();
		PreparedStatement prepStmt 	= Database.getPreparedStatementWithGeneratedKeys(conexao, sql);
		int id						= 0;
		
		try {
			prepStmt.setString(1, turmaVO.getNome());
			prepStmt.setInt(2, 30);
			prepStmt.setInt(3, 1);
			prepStmt.setInt(4, 1);

			int codeReturn = prepStmt.executeUpdate();
			
			if(codeReturn == Database.CODE_RETURN_SUCCESS) {
				ResultSet rs = prepStmt.getGeneratedKeys();
				
				if (rs.next()) {
					id = rs.getInt(1);
				}
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
			
			if (codeReturn == Database.CODE_RETURN_SUCCESS) {
				return true;
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao inserir horário da turma. Causa: \n:" + exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}

		return false;
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

	public ArrayList<TurmaVO> consultarTodos()
	{
		String sql 							= "SELECT id_turma, nome FROM turmas";
		Connection conexao 					= Database.getConnection();
		PreparedStatement prepStmt 			= Database.getPreparedStatement(conexao, sql);
		ArrayList<TurmaVO> turmas 			= new ArrayList<TurmaVO>();
		
		try {
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()) {
				TurmaVO turma = new TurmaVO();
				turma.setId(rs.getInt("id_turma"));
				turma.setNome(rs.getString("nome"));
				turmas.add(turma);
			}			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar as turmas.\nCausa: " + e.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return turmas;
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
	
	public ArrayList<AlunoVO> consultarAlunosPorTurma(AlunoVO alunoVO) throws Exception
	{
		String sql 							= this.criarFiltro(alunoVO);
		Connection conexao 					= Database.getConnection();
		PreparedStatement prepStmt 			= Database.getPreparedStatement(conexao, sql);
		ArrayList<AlunoVO> alunos 			= new ArrayList<AlunoVO>();
		
		try {			
			ResultSet rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				AlunoVO aluno = new AlunoVO();
				aluno.setId(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setCpf(rs.getString(3));
				aluno.setCidade(rs.getString(4));
				aluno.setBairro(rs.getString(5));
				alunos.add(aluno);
			}
		} catch(SQLException exception) {
			System.out.println("Erro ao consultar os alunos por turma. Causa: \n:" + exception.getMessage());
			
			 throw new Exception(exception.getMessage());
		} finally {
			Database.closePreparedStatement(prepStmt);
			Database.closeConnection(conexao);
		}
		
		return alunos;
	}
	
	private String criarFiltro(AlunoVO aluno)
	{
		String sql = "SELECT alunos.id_aluno, pessoas.nome, pessoas.cpf, pessoas.cidade, pessoas.bairro "
				+ "FROM alunos "
				+ "INNER JOIN turmas on alunos.id_turma = turmas.id_turma "
				+ "INNER JOIN pessoas on alunos.id_pessoa = pessoas.id_pessoa "
				+ "WHERE turmas.id_turma = " + aluno.getTurma().getId();
		
		String cpfSemMascara = aluno.getCpf().replaceAll("\\D+","");

		if (!cpfSemMascara.isEmpty()) {
			sql += " AND pessoas.cpf = '" + aluno.getCpf() + "'";
		}

		if (!aluno.getCidade().isEmpty()) {
			sql += " AND pessoas.cidade LIKE '%" + aluno.getCidade() + "%'";
		}
		
		if (!aluno.getBairro().isEmpty()) {
			sql += " AND pessoas.bairro LIKE '%" + aluno.getBairro() + "%'";
		}

		return sql;
	}
}
