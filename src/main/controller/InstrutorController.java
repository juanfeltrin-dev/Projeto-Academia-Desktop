package controller;

import model.bo.InstrutorBO;
import model.dao.ModalidadeDAO;
import model.dao.TurmaDAO;
import model.vo.AlunoVO;
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
//	public String excluir(String instrutorId, String pesssoaId) throws Exception {
//		int instrutor 		= 0;
//		int pessoa 		= 0;
//
//		try {
//			instrutor 			= Integer.parseInt(instrutorId);
//			pessoa 			= Integer.parseInt(pesssoaId);
//
//			return bo.excluir(instrutor, pessoa);
//		} catch (NumberFormatException e) {
//			return "Insira um número inteiro";
//		}	
//	}

	public String alterar(InstrutorVO instrutor) throws Exception {
		try {
			validarCamposAlterar(instrutor);

			return bo.alterar(instrutor);
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}

	private static void validarCampos(InstrutorVO instrutor) throws Exception {
		try {
			if (instrutor.getNome().isEmpty() && (instrutor.getNome().length() > 100 || instrutor.getNome().length() < 3)) {
				throw new Exception("Nome não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getEmail().isEmpty() && (instrutor.getEmail().length() > 100 || instrutor.getEmail().length() < 3)) {
				throw new Exception("Email não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getCpf().isEmpty() && instrutor.getNome().length() != 14) {
				throw new Exception("CPF deve conter 11 digitoss");
			}

			if (instrutor.getNascimento().toString().isEmpty()) {
				throw new Exception("Nascimento não pode ser vazio");
			}

			if (instrutor.getSexo() != 'M' && instrutor.getSexo() != 'F') {
				throw new Exception("Sexo deve ser M/F");
			}

			if (instrutor.getBairro().isEmpty() && (instrutor.getBairro().length() > 100 || instrutor.getBairro().length() < 3)) {
				throw new Exception("Bairro não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getCidade().isEmpty() && (instrutor.getCidade().length() > 100 || instrutor.getCidade().length() < 3)) {
				throw new Exception("Cidade não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getEstado().isEmpty() && instrutor.getEstado().length() == 2) {
				throw new Exception("Estado deve conter 2 digitos");
			}

			if (instrutor.getCep().isEmpty() && instrutor.getCep().length() != 10) {
				throw new Exception("CEP deve conter 8 digitos");
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}

	private static void validarCamposAlterar(InstrutorVO instrutor) throws Exception {
		try {
			if (instrutor.getEmail().isEmpty() && (instrutor.getEmail().length() > 100 || instrutor.getEmail().length() < 3)) {
				throw new Exception("Email não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getBairro().isEmpty() && (instrutor.getBairro().length() > 100 || instrutor.getBairro().length() < 3)) {
				throw new Exception("Bairro não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getCidade().isEmpty() && (instrutor.getCidade().length() > 100 || instrutor.getCidade().length() < 3)) {
				throw new Exception("Cidade não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (instrutor.getEstado().isEmpty() && instrutor.getEstado().length() == 2) {
				throw new Exception("Estado deve conter 2 digitos");
			}

			if (instrutor.getCep().isEmpty() && instrutor.getCep().length() != 10) {
				throw new Exception("CEP deve conter 8 digitos");
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}

	public InstrutorVO buscarPeloCpf(String cpf) throws Exception {
		try {
			return bo.buscarPeloCpf(cpf);
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
}
