package model.bo;

import model.dao.ModalidadeDAO;
import model.vo.ModalidadeVO;

public class ModalidadeBO {
	private ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
	
	public String inserir(ModalidadeVO modalidade) throws Exception
	{
		try {
			this.modalidadeDAO.inserir(modalidade);
			
			return "Modalidade cadastrada com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	
	public String excluir(int id) throws Exception
	{
		try {
			this.modalidadeDAO.excluir(id);
			
			return "Modalidade excluida com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
}
