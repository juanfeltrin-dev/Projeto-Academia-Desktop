package model.bo;


import java.util.ArrayList;

import model.dao.TurmaDAO;
import model.vo.AlunoVO;
import model.vo.DiaSemanaVO;
import model.vo.TurmaVO;

public class TurmaBO {
	private TurmaDAO turmaDAO = new TurmaDAO();
	
	public String inserir(TurmaVO turmaVO)
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
			
			return "Turma criada com sucesso!";
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}
	public ArrayList<TurmaVO> consultarTodasTurmas() {
		ArrayList<TurmaVO> turma = turmaDAO.consultarTodos();

		if (turma.isEmpty()) {
			System.out.println("Sem alunos na base da dados.");
		}
		return turma;	
	}
	
}
