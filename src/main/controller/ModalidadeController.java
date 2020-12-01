package controller;

import java.util.ArrayList;

import model.bo.ModalidadeBO;
import model.dao.ModalidadeDAO;
import model.vo.ModalidadeVO;

public class ModalidadeController {
	private ModalidadeBO modalidadeBO = new ModalidadeBO();
	
	public String inserir(ModalidadeVO modalidade) throws Exception {
		try {
			validarCampos(modalidade);
			
			return this.modalidadeBO.inserir(modalidade);
		} catch(Exception exception) {
			return exception.getMessage();
		}
	}
	
	private static void validarCampos(ModalidadeVO modalidade) throws Exception {
		try {
			if (modalidade.getNome().isEmpty() && (modalidade.getNome().length() > 100 || modalidade.getNome().length() < 3)) {
				throw new Exception("Nome não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
		
	}
	ModalidadeDAO dao = new ModalidadeDAO();
	public ArrayList<String> consultarNomeModalidade() {
		ArrayList<String> listaNomes = new ArrayList<String>();
		
		for(ModalidadeVO vo : dao.consultarTodos()) {
			listaNomes.add(vo.getNome());
		}
		
		return listaNomes;		
	}
}
