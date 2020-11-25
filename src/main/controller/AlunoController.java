package controller;
import java.time.LocalDate	;
import java.time.format.DateTimeFormatter;
import model.vo.AlunoVO;
import model.vo.TurmaVO;
import model.bo.AlunoBO;

public class AlunoController extends PessoaController{
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	AlunoBO bo = new AlunoBO();

	public String inserir(String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, Object object, String cep, String email,int id,String observacoes, LocalDate data_matricula, String matricula, TurmaVO id_turma){
		AlunoVO aluno = new AlunoVO(id,observacoes, data_matricula, matricula, id_turma);
		String mensagem = validarCampos(id, observacoes, data_matricula, matricula, id_turma);

		if(mensagem == "") {
			mensagem = bo.salvar(criarNovoAluno(observacoes, data_matricula, matricula, id_turma));			
		}


		return mensagem;
	}


	private static String validarCampos(int id,String observacoes, LocalDate data_matricula, String matricula,
			TurmaVO id_turma) {
		// TODO Auto-generated method stub
		return null;
	}


	public String excluir(String idSelecionado) {

		String mensagem = "";
		int id = 0;

		try {

			id = Integer.parseInt(idSelecionado);

		} catch (NumberFormatException e) {
			mensagem = "Insira um número inteiro";
		}

		if (mensagem == "") {
			mensagem = bo.excluir(id);
		}

		return mensagem;		
	}
	
	private AlunoVO criarNovoAluno(int id, String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email, String modalidade,
			String observacoes, LocalDate data_matricula, String matricula, TurmaVO id_turma) {
		
		ModalidadeController controller = new ModalidadeController();
		LocalDate dtNasc = LocalDate.parse(dataNascimento, dataFormatter);
		
		AlunoVO vo = new AlunoVO(removerMascara(cpf), nome, dtNasc, sexo, removerMascara(telefone), removerMascara(celular), email, bairro,
				endereco, removerMascara(cep), cidade, uf, controller.consultarPorNome(modalidade),
				observacoes, LocalDate.now(), true);
		
		return vo;
	}

	public String alterar(int id, String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email, String modalidade,
			String observacoes, LocalDate data_matricula, String matricula, TurmaVO id_turma) {

		String mensagem = validarCampos(cpf, nome, dataNascimento, sexo, telefone, celular, 
				endereco, bairro, cidade, uf, cep, email);

		if(mensagem == "") {
			AlunoVO aluno = criarNovoAluno(id,cpf,nome,dataNascimento,sexo,telefone,celular,endereco,bairro,cidade,uf,cep,email,modalidade
				,observacoes,data_matricula, matricula, id_turma);
			aluno.setId(id);
			mensagem = bo.alterar(aluno);			
		}

		return mensagem;

	}
}
