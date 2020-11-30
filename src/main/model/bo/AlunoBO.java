package model.bo;

import java.time.LocalDate;
import java.time.LocalTime;

import model.dao.AlunoDAO;
import model.dao.PessoaDAO;
import model.dao.TurmaDAO;
import model.vo.AlunoVO;
import model.vo.TurmaVO;

public class AlunoBO {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private AlunoDAO alunoDAO 	= new AlunoDAO();
	private TurmaDAO turmaDAO 	= new TurmaDAO();

	//	a validar regra
	public String excluir(int alunoId, int pessoaId) {
		try {
			this.alunoDAO.excluir(alunoId);
			this.pessoaDAO.excluir(pessoaId);
			
			return "Aluno excluido com sucesso!";
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}

	public String alterar(AlunoVO aluno) {
		try {
			this.pessoaDAO.alterar(aluno);
			this.alunoDAO.alterar(aluno);
			
			return "Aluno alterado com sucesso!";
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}

	public String inserir(AlunoVO aluno) throws Exception {
		try {
			if (this.pessoaDAO.validaSeCpfExiste(aluno.getCpf())) {
				throw new Exception("CPF já existente!");
			}

			int pessoaId = this.pessoaDAO.inserir(aluno);

			this.alunoDAO.inserir(aluno, pessoaId);
			
			return "Aluno cadastrado com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	
	public String checkIn(AlunoVO aluno) {
		try {
			AlunoVO alunoLogado = this.alunoDAO.login(aluno.getCpf());
			
			if (this.alunoDAO.verificaSeTreinouHoje(alunoLogado.getId(), LocalDate.now())) {
				throw new Exception("Você já treinou hoje!");
			}
			
			if (alunoLogado.isLogado()) {
				LocalTime agora 			= LocalTime.now();
				LocalTime meiaHoraDepois 	= agora.plusMinutes(30);
				LocalDate dataHoje			= LocalDate.now();
				TurmaVO turmaVO 			= this.alunoDAO.obterHorarioTurma(aluno.getCpf(), dataHoje.getDayOfWeek().getValue());
				
				if (turmaVO.getHorario().isAfter(agora) && turmaVO.getHorario().isBefore(meiaHoraDepois)) {
					this.alunoDAO.realizarCheckIn(alunoLogado.getId(), turmaVO.getId(), dataHoje, LocalTime.now());
					
					return "Liberado!";
				} else {
					throw new Exception("Você não está entre o horário da sua turma ou seu tempo permitido de atraso!");
				}
			} else {
				throw new Exception("Você não está cadastrado no sistema!");
			}
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}
}
