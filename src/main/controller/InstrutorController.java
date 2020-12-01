package controller;

import model.bo.InstrutorBO;
import model.dao.ModalidadeDAO;
import model.dao.TurmaDAO;
import model.vo.InstrutorVO;

	public class InstrutorController extends PessoaController{
		InstrutorBO bo = new InstrutorBO();
		ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
		TurmaDAO turmaDAO = new TurmaDAO();

		public String inserir(InstrutorVO instrutor) throws Exception {
			try {			
				
				return bo.inserir(instrutor);
			} catch(Exception exception) {
				return exception.getMessage();
			}
		}
}
