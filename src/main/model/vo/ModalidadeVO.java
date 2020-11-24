package model.vo;

import java.util.List;

public class ModalidadeVO {
	private int id;
	private String nome;
	private List<TurmaVO> turmas;
	
	public ModalidadeVO() {
		super();
	}

	public ModalidadeVO(int id, String nome, List<TurmaVO> turmas) {
		super();
		this.id 	= id;
		this.nome 	= nome;
		this.turmas = turmas;
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

	public List<TurmaVO> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaVO> turmas) {
		this.turmas = turmas;
	}

}
