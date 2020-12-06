package model.bo;

import java.util.ArrayList;

import model.dao.InstrutorDAO;
import model.dao.PessoaDAO;
import model.vo.AlunoVO;
import model.vo.InstrutorVO;

public class InstrutorBO {
	private PessoaDAO pessoaDAO 		= new PessoaDAO();
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
	
	public String excluir(int idInstrutor) throws Exception {
		try {
			if (this.instrutorDAO.verificaSePertenceTurma(idInstrutor)) {
				throw new Exception("Instrutor pertence a uma turma!");
			}
			
			int idPessoa = this.instrutorDAO.consultarIdPessoa(idInstrutor);
			
			if (idPessoa == 0) {
				throw new Exception("Pessoa não foi encontrada!");
			}
			
			this.instrutorDAO.excluir(idInstrutor);
			this.pessoaDAO.excluir(idPessoa);
			
			return "Instrutor excluido com sucesso!";
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
}
