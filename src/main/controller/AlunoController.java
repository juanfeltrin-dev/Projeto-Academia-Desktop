package controller;
import model.vo.AlunoVO;
import model.vo.ModalidadeVO;
import model.vo.TurmaVO;

import java.util.ArrayList;

import model.bo.AlunoBO;
import model.dao.ModalidadeDAO;
import model.dao.TurmaDAO;

public class AlunoController extends PessoaController{
	AlunoBO bo = new AlunoBO();
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


	private static void validarCampos(AlunoVO aluno) throws Exception {
		try {
			if (aluno.getNome().isEmpty() && (aluno.getNome().length() > 100 || aluno.getNome().length() < 3)) {
				throw new Exception("Nome não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (aluno.getEmail().isEmpty() && (aluno.getEmail().length() > 100 || aluno.getEmail().length() < 3)) {
				throw new Exception("Email não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (aluno.getCpf().isEmpty() && aluno.getNome().length() != 14) {
				throw new Exception("CPF deve conter 11 digitoss");
			}

			if (aluno.getNascimento().toString().isEmpty()) {
				throw new Exception("Nascimento não pode ser vazio");
			}

			if (aluno.getSexo() != 'M' && aluno.getSexo() != 'F') {
				throw new Exception("Sexo deve ser M/F");
			}

			if (aluno.getEmail().isEmpty() && (aluno.getEmail().length() > 100 || aluno.getEmail().length() < 3)) {
				throw new Exception("Email não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (aluno.getBairro().isEmpty() && (aluno.getBairro().length() > 100 || aluno.getBairro().length() < 3)) {
				throw new Exception("Bairro não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (aluno.getCidade().isEmpty() && (aluno.getCidade().length() > 100 || aluno.getCidade().length() < 3)) {
				throw new Exception("Cidade não pode ser vazio e deve conter entre 3 e 100 caracteres");
			}

			if (aluno.getEstado().isEmpty() && aluno.getEstado().length() == 2) {
				throw new Exception("Estado deve conter 2 digitos");
			}

			if (aluno.getCep().isEmpty() && aluno.getCep().length() != 10) {
				throw new Exception("CEP deve conter 8 digitos");
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}

	public String excluir(String alunoId, String pesssoaId) throws Exception {
		int aluno 		= 0;
		int pessoa 		= 0;

		try {
			aluno 			= Integer.parseInt(alunoId);
			pessoa 			= Integer.parseInt(pesssoaId);

			return bo.excluir(aluno, pessoa);
		} catch (NumberFormatException e) {
			return "Insira um número inteiro";
		}	
	}

	public String alterar(AlunoVO aluno) {
		try {
			validarCampos(aluno);

			return bo.alterar(aluno);
		} catch (Exception exception) {
			return exception.getMessage();
		}

	}

	public ArrayList<TurmaVO> turmas() {
		return this.turmaDAO.consultarTodos();
	}
}
