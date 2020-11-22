package model.vo;

import java.time.LocalDate;

public class AlunoVO extends PessoaVO {
	private String observacao;
	private LocalDate dataMatricula;
	private String matricula;
	private ModalidadeVO modalidade;

	public AlunoVO(String nome, String cpf, LocalDate nascimento, char sexo, String telefone, String celular,
			String email, String bairro, String cidade, char estado, String cep) {
		super(nome, cpf, nascimento, sexo, telefone, celular, email, bairro, cidade, estado, cep);
	}

	public AlunoVO(String observacao, LocalDate dataMatricula, String matricula, ModalidadeVO modalidade) {
		super();
		this.observacao = observacao;
		this.dataMatricula = dataMatricula;
		this.matricula = matricula;
		this.modalidade = modalidade;
	}

	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}
	
	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public ModalidadeVO getModalidade() {
		return modalidade;
	}
	
	public void setModalidade(ModalidadeVO modalidade) {
		this.modalidade = modalidade;
	}
}
