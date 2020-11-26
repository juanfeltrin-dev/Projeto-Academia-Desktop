package model.bo;

import java.time.LocalTime;

import model.dao.AlunoDAO;
import model.dao.PessoaDAO;
import model.vo.AlunoVO;

public class AlunoBO {
	private PessoaDAO pessoaDAO;
	private AlunoDAO alunoDAO;
	
	public AlunoBO(PessoaDAO pessoaDAO, AlunoDAO alunoDAO) {
		super();
		this.pessoaDAO 	= pessoaDAO;
		this.alunoDAO 	= alunoDAO;
	}

	public String excluir(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String alterar(AlunoVO aluno) {
		// TODO Auto-generated method stub
		return null;
	}

	public String inserir(AlunoVO aluno) {
		try {
			if (this.pessoaDAO.validaSeCpfExiste(aluno.getCpf())) {
				throw new Exception("CPF já existente!");
			}
			
			int pessoaId = this.pessoaDAO.inserir(aluno);
			this.alunoDAO.inserir(aluno, pessoaId);
			
			return "Aluno cadastrado com sucesso!";
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}
	
	public String checkIn(AlunoVO aluno) {
		try {
			LocalTime horario 			= this.alunoDAO.obterHorarioTurma(aluno.getCpf());
			LocalTime agora 			= LocalTime.now();
			LocalTime meiaHoraDepois 	= agora.plusMinutes(30);
			
			if (horario.isAfter(agora) && horario.isBefore(meiaHoraDepois)) {
				return "Liberado!";
			} else {
				throw new Exception("Você não está no horário da sua turma ou seu tempo de atraso!");
			}
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}
}
