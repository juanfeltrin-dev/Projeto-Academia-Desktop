package model.bo;


import model.dao.TurmaDAO;
import model.vo.DiaSemanaVO;
import model.vo.TurmaVO;

public class TurmaBO {
	private TurmaDAO turmaDAO = new TurmaDAO();
	
	public String inserir(TurmaVO turmaVO)
	{
		try {
			for (int i = 0; i < turmaVO.getDiasDaSemana().size(); i++) {
				if (this.turmaDAO.verificaSeExisteHorario(turmaVO.getDiasDaSemana().get(i), turmaVO.getHorario())) {
					throw new Exception("J� existe uma turma no mesmo hor�rio e dia da semana!");
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
}
