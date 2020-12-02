package controller;

import java.util.ArrayList;

import model.bo.TurmaBO;
import model.vo.AlunoVO;
import model.vo.TurmaVO;



public class TurmaController {
	private TurmaBO bo = new TurmaBO();
	
	 public ArrayList<AlunoVO> consultarAlunosPorTurma(int turmaId) throws Exception {
		 try {
				return bo.consultarAlunosPorTurma(turmaId);
		 } catch (Exception exception) {
			 throw new Exception(exception.getMessage());
		 }
	}
}
