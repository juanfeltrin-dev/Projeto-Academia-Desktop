package model.vo;

import java.time.LocalDate;

public class PessoaVO {
	private int id;
	private String nome;
	private String cpf;
	private LocalDate nascimento;
	private char sexo;
	private String telefone;
	private String celular;
	private String email;
	private String bairro;
	private String cidade;
	private char estado;
	private String cep;
		
	public PessoaVO() {
		super();
	}
	
	public PessoaVO(int id, String nome, String cpf, LocalDate nascimento, char sexo, String telefone, String celular,
			String email, String bairro, String cidade, char estado, String cep) {
		super();
		this.id 		= id;
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

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public void setIdade(LocalDate nascimento) {
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
		this.email = email;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public char getEstado() {
		return estado;
	}
	
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
}
