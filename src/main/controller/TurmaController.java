package controller;

import java.util.ArrayList;

import model.bo.TurmaBO;
import model.vo.AlunoVO;
import model.vo.TurmaVO;
import util.GerarPlanilha;



public class TurmaController {
	private TurmaBO bo = new TurmaBO();
	
	 public ArrayList<AlunoVO> consultarAlunosPorTurma(int turmaId) throws Exception {
		 try {
				return bo.consultarAlunosPorTurma(turmaId);
		 } catch (Exception exception) {
			 throw new Exception(exception.getMessage());
		 }
	}
	 
	 public String inserir(TurmaVO turma) throws Exception {
		 try {
			 validarCampos(turma);
			 
			 bo.inserir(turma);
			 
			 return "Turma cadastrada com sucesso!";
		 } catch (Exception exception) {
			 throw new Exception(exception.getMessage());
		 }
	 }
	 
	 private static void validarCampos(TurmaVO turma) throws Exception {
		try {
			if (turma.getNome().isEmpty() && (turma.getNome().length() > 100 || turma.getNome().length() < 3)) {
				throw new Exception("Nome não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}
			
			if (turma.getHorario() == null) {
				throw new Exception("Você deve selecionar um horário");
			}
			
			if (turma.getDiasDaSemana().isEmpty()) {
				throw new Exception("Você deve selecionar ao menos um dia da semana");
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	 }
	 
	 public String gerarPlanilha(ArrayList<AlunoVO> alunos, String caminho) {			
		GerarPlanilha geradorExcel = new GerarPlanilha();
		return geradorExcel.gerarPlanilhaAlunos(caminho, alunos);
	}
}
