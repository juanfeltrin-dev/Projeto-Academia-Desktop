package model.bo;

import model.dao.InstrutorDAO;
import model.dao.PessoaDAO;
import model.vo.AlunoVO;
import model.vo.InstrutorVO;

public class InstrutorBO {
	private PessoaDAO pessoaDAO 		= new PessoaDAO();;
	private InstrutorDAO instrutorDAO 	= new InstrutorDAO();

	public String inserir(InstrutorVO instrutor) throws Exception
	{
		try {
			if (this.pessoaDAO.validaSeCpfExiste(instrutor.getCpf())) {
				throw new Exception("CPF já existente!");
			}
			
			int pessoaId = this.pessoaDAO.inserir(instrutor);
			this.instrutorDAO.inserir(instrutor, pessoaId);
			
			return "Instrutor cadastrado com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	
	public String alterar(InstrutorVO instrutor) throws Exception
	{
		try {
			this.pessoaDAO.alterar(instrutor);

			return "Instrutor alterado com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	
	public InstrutorVO buscarPeloCpf(String cpf) throws Exception {
		try {
			InstrutorVO instrutor = this.instrutorDAO.buscarPeloCpf(cpf);
			
			if (instrutor == null) {
				throw new Exception("Instrutor não encontrado!");
			}
			
			return instrutor;
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
}
