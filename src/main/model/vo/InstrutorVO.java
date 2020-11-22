package model.vo;

import java.time.LocalDate;

public class InstrutorVO extends PessoaVO {
	private LocalDate dataAdmissao;
	private double salario;

	public InstrutorVO(String nome, String cpf, LocalDate nascimento, char sexo, String telefone, String celular,
			String email, String bairro, String cidade, char estado, String cep) {
		super(nome, cpf, nascimento, sexo, telefone, celular, email, bairro, cidade, estado, cep);
	}

	public InstrutorVO(LocalDate dataAdmissao, double salario) {
		super();
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
