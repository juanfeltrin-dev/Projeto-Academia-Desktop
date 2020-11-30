package controller;

import model.bo.AlunoBO;
import model.bo.InstrutorBO;
import model.dao.ModalidadeDAO;
import model.dao.TurmaDAO;
import model.vo.AlunoVO;

	public class InstrutorController extends PessoaController{
		InstrutorBO bo = new InstrutorBO();
		ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
		TurmaDAO turmaDAO = new TurmaDAO();

		public String inserir(AlunoVO aluno) throws Exception {
			try {
				validarCampos(aluno);
				
				return bo.inserir(aluno);
			} catch(Exception exception) {
				return exception.getMessage();
				
			}
		}
}
