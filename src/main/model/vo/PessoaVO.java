package model.vo;

import java.time.LocalDate;

public class PessoaVO {
	private int pessoaId;
	private String nome;
	private String cpf;
	private LocalDate nascimento;
	private char sexo;
	private String telefone;
	private String celular;
	private String email;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
		
	public PessoaVO() {
		super();
	}
	
	public PessoaVO(int pessoaId, String nome, String cpf, LocalDate nascimento, char sexo, String telefone, String celular,
			String email, String bairro, String cidade, String estado, String cep) {
		super();
		this.pessoaId 	= pessoaId;
		this.nome 		= nome;
		this.cpf 		= cpf;
		this.nascimento = nascimento;
		this.sexo 		= sexo;
		this.telefone 	= telefone;
		this.celular 	= celular;
		this.email 		= email;
		this.bairro 	= bairro;
		this.cidade 	= cidade;
		this.estado 	= estado;
		this.cep 		= cep;
	}

	public int getPessoaId() {
		return pessoaId;
	}
	
	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email.toUpperCase();
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
}
