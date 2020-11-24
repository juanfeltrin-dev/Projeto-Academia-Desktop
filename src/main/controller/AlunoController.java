package controller;
import java.time.LocalDate;
import model.vo.AlunoVO;
import model.vo.TurmaVO;

public class AlunoController{
	
	public static void inserir(int id_pessoa, String observacoes, LocalDate data_matricula, String matricula, TurmaVO id_turma){
		AlunoVO aluno = new AlunoVO(id_pessoa, observacoes, data_matricula, matricula, id_turma);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	
}
