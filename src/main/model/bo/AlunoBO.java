package model.bo;

import java.time.LocalDate;
import java.time.LocalTime;

import model.dao.AlunoDAO;
import model.dao.PessoaDAO;
import model.vo.AlunoVO;
import model.vo.TurmaVO;

public class AlunoBO {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private AlunoDAO alunoDAO 	= new AlunoDAO();

	//	a validar regra
	public String excluir(int alunoId, int pessoaId) throws Exception {
		try {
			this.alunoDAO.excluir(alunoId);
			this.pessoaDAO.excluir(pessoaId);
			
			return "Aluno excluido com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}

	public String alterar(AlunoVO aluno) throws Exception {
		try {
			this.pessoaDAO.alterar(aluno);
			this.alunoDAO.alterar(aluno);
			
			return "Aluno alterado com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
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
	public AlunoVO verificarAlunoPorCpf(String cpf) {
		return dao.verificarAlunoPorCpf(cpf);
	}
	
	public String checkIn(String cpf) throws Exception {
		try {
			AlunoVO alunoLogado = this.alunoDAO.login(cpf);
			
			if (alunoLogado.isLogado()) {			
				if (this.alunoDAO.verificaSeTreinouHoje(alunoLogado.getId(), LocalDate.now())) {
					throw new Exception("Você já treinou hoje!");
				}
			
				LocalTime agora 			= LocalTime.now();
				LocalTime meiaHoraDepois 	= agora.plusMinutes(30);
				LocalDate dataHoje			= LocalDate.now();
				TurmaVO turmaVO 			= this.alunoDAO.obterHorarioTurma(alunoLogado.getId(), dataHoje.getDayOfWeek().getValue());

				if (turmaVO.getHorario() == null) {
					throw new Exception("Sua turma não tem horário para hoje");
				}

				if (agora.isAfter(turmaVO.getHorario()) && turmaVO.getHorario().isBefore(meiaHoraDepois)) {
					this.alunoDAO.realizarCheckIn(alunoLogado.getId(), turmaVO.getId(), dataHoje, LocalTime.now());
					
					return "Liberado!";
				} else {
					throw new Exception("Você não está entre o horário da sua turma ou seu tempo permitido de atraso!");
				}
			} else {
				throw new Exception("Você não está cadastrado no sistema!");
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
}
