package controller;
import model.vo.AlunoVO;
import model.bo.AlunoBO;

public class AlunoController extends PessoaController{
	AlunoBO bo = new AlunoBO();

	public String inserir(AlunoVO aluno){
		try {
			validarCampos(aluno);
			
			return bo.inserir(aluno);
		} catch(Exception exception) {
			return exception.getMessage();
		}
	}


	private static void validarCampos(AlunoVO aluno) throws Exception {
		try {
			if (aluno.getNome().isEmpty()) {
				throw new Exception("Nome não pode ser vazio");
			}
			
			if (aluno.getCpf().isEmpty()) {
				throw new Exception("CPF não pode ser vazio");
			}
			
			if (aluno.getNascimento().toString().isEmpty()) {
				throw new Exception("Nascimento não pode ser vazio");
			}
			
			if (aluno.getSexo() != 'M' && aluno.getSexo() != 'F') {
				throw new Exception("Sexo não pode ser vazio");
			}
			
			if (aluno.getEmail().isEmpty()) {
				throw new Exception("Email não pode ser vazio");
			}
			
			if (aluno.getBairro().isEmpty()) {
				throw new Exception("Bairro não pode ser vazio");
			}
			
			if (aluno.getCidade().isEmpty()) {
				throw new Exception("Bairro não pode ser vazio");
			}
			
			if (aluno.getEstado().isEmpty()) {
				throw new Exception("Estado não pode ser vazio");
			}
			
			if (aluno.getCep().isEmpty()) {
				throw new Exception("CEP não pode ser vazio");
			}
			
			if (aluno.getDataMatricula().toString().isEmpty()) {
				throw new Exception("Nascimento não pode ser vazio");
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public String excluir(String alunoId, String pesssoaId) {
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
}
