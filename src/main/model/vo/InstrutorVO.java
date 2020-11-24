package model.vo;

import java.time.LocalDate;
import java.util.List;

public class InstrutorVO extends PessoaVO {
	private int id;
	private LocalDate dataAdmissao;
	private double salario;
	private List<TurmaVO> turmas;
	
	public InstrutorVO() {
		super();
	}

	public InstrutorVO(int id, LocalDate dataAdmissao, double salario, List<TurmaVO> turmas) {
		super();
		this.id 			= id;
		this.dataAdmissao 	= dataAdmissao;
		this.salario 		= salario;
		this.turmas 		= turmas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<TurmaVO> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaVO> turmas) {
		this.turmas = turmas;
	}
	
}
