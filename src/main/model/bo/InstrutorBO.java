package model.bo;

import model.dao.InstrutorDAO;
import model.dao.PessoaDAO;
import model.vo.InstrutorVO;

public class InstrutorBO {
	private PessoaDAO pessoaDAO;
	private InstrutorDAO instrutorDAO;
	
	public InstrutorBO(PessoaDAO pessoaDAO, InstrutorDAO instrutorDAO) {
		super();
		this.pessoaDAO 		= pessoaDAO;
		this.instrutorDAO 	= instrutorDAO;
	}

	public String inserir(InstrutorVO instrutor)
	{
		try {
			if (this.pessoaDAO.validaSeCpfExiste(instrutor.getCpf())) {
				throw new Exception("CPF já existente!");
			}
			
			int pessoaId = this.pessoaDAO.inserir(instrutor);
			this.instrutorDAO.inserir(instrutor, pessoaId);
			
			return "Instrutor cadastrado com sucesso!";
		} catch (Exception exception) {
			return exception.getMessage();
		}
	}
}
