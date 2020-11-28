package model.bo;


import model.dao.TurmaDAO;
import model.vo.DiaSemanaVO;
import model.vo.TurmaVO;

public class TurmaBO {
	private TurmaDAO turmaDAO = new TurmaDAO();
	private DiaSemanaVO diaSemana = new DiaSemanaVO();
	
	public String inserir(TurmaVO turmaVO)
	{
		try {			
			if (this.turmaDAO.verificaSeExisteHorario(1, turmaVO.getHorario())) {
				throw new Exception("Já existe uma turma no mesmo horário e dia da semana!");
			}
			
			int turmaId = this.turmaDAO.inserir(turmaVO);
			
			this.turmaDAO.inserirHorarios(turmaId, 1, turmaVO.getHorario());
			
			return "Turma criada com sucesso!";
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}
}
