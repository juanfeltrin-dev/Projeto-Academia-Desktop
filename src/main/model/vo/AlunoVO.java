package model.vo;

import java.time.LocalDate;

public class AlunoVO extends PessoaVO {
	private int id;
	private String observacao;
	private LocalDate dataMatricula;
	private String matricula;
	private TurmaVO turma;
	private boolean logado;
	
	public AlunoVO() {
		super();
	}

	public AlunoVO(int id, String observacao, LocalDate dataMatricula, String matricula, TurmaVO turma, boolean logado) {
		super();
		this.id 			= id;
		this.observacao 	= observacao;
		this.dataMatricula 	= dataMatricula;
		this.matricula 		= matricula;
		this.turma 			= turma;
		this.logado 		= logado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public TurmaVO getTurma() {
		return turma;
	}

	public void setTurma(TurmaVO turma) {
		this.turma = turma;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	@Override
	public String toString() {
		return id + ". " + this.getNome();
	}
}
