package model.bo;


import java.util.ArrayList;

import model.dao.TurmaDAO;
import model.vo.AlunoVO;
import model.vo.DiaSemanaVO;
import model.vo.TurmaVO;

public class TurmaBO {
	private TurmaDAO turmaDAO = new TurmaDAO();
	
	public boolean inserir(TurmaVO turmaVO) throws Exception
	{
		try {
			for (int i = 0; i < turmaVO.getDiasDaSemana().size(); i++) {
				if (this.turmaDAO.verificaSeExisteHorario(turmaVO.getDiasDaSemana().get(i), turmaVO.getHorario())) {
					throw new Exception("Já existe uma turma no mesmo horário e dia da semana!");
				}
			}

			int turmaId = this.turmaDAO.inserir(turmaVO);

			for (int i = 0; i < turmaVO.getDiasDaSemana().size(); i++) {
				this.turmaDAO.inserirHorarios(turmaId, turmaVO.getDiasDaSemana().get(i), turmaVO.getHorario());
			}
			
			return true;
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	public ArrayList<AlunoVO> consultarAlunosPorTurma(int turmaId) throws Exception {
		try {
			ArrayList<AlunoVO> alunos = turmaDAO.consultarAlunosPorTurma(turmaId);

			if (alunos.isEmpty()) {
				 throw new Exception("Sem turmas na base da dados.");
			}
			return alunos;	
		} catch (Exception exception) {
			 throw new Exception(exception.getMessage());
		}
	}
	
}
