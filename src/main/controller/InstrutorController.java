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
				validarCampos(instrutor);
				return bo.inserir(instrutor);
			} catch(Exception exception) {
				return exception.getMessage();
			}
		}

		private static void validarCampos(InstrutorVO instrutor) throws Exception {
			try {
				if (instrutor.getNome().isEmpty() && (instrutor.getNome().length() > 100 || instrutor.getNome().length() < 3)) {
					throw new Exception("Nome não pode ser vazio e deve conter entre 3 e 100 caracteres");
				}
			} catch (Exception exception) {
				throw new Exception(exception.getMessage());
			}
		}
}
