package model.vo;

import java.util.List;
import java.time.LocalTime;

public class TurmaVO {
	private String nome;
	private int quantidadeVagas;
	private InstrutorVO instrutor;
	private List<AlunoVO> alunos;
	private LocalTime horario;
	
	public TurmaVO(String nome, int quantidadeVagas, InstrutorVO instrutor, List<AlunoVO> alunos, LocalTime horario) {
		super();
		this.nome = nome;
		this.quantidadeVagas = quantidadeVagas;
		this.instrutor = instrutor;
		this.alunos = alunos;
		this.horario = horario;
	}
	
	public TurmaVO() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}
	
	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}
	
	public InstrutorVO getInstrutor() {
		return instrutor;
	}
	
	public void setInstrutor(InstrutorVO instrutor) {
		this.instrutor = instrutor;
	}
	
	public List<AlunoVO> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<AlunoVO> alunos) {
		this.alunos = alunos;
	}
	
	public LocalTime getHorario() {
		return horario;
	}
	
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
}
