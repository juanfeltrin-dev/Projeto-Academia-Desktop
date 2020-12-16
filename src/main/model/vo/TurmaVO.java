package model.vo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class TurmaVO {
	private int id;
	private String nome;
	private int quantidadeVagas;
	private InstrutorVO instrutor;
	private ModalidadeVO modalidade;
	private List<AlunoVO> alunos;
	private LocalTime horario;
	private ArrayList<Integer> diasDaSemana;
	
	public TurmaVO() {
		super();
	}

	public TurmaVO(int id, String nome, int quantidadeVagas, InstrutorVO instrutor, ModalidadeVO modalidade,
			List<AlunoVO> alunos, LocalTime horario, ArrayList<Integer> diasDaSemana) {
		super();
		this.id 				= id;
		this.nome 				= nome;
		this.quantidadeVagas 	= quantidadeVagas;
		this.instrutor 			= instrutor;
		this.modalidade 		= modalidade;
		this.alunos 			= alunos;
		this.horario 			= horario;
		this.diasDaSemana 		= diasDaSemana;
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
		this.nome = nome.toUpperCase();
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

	public ModalidadeVO getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeVO modalidade) {
		this.modalidade = modalidade;
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

	public ArrayList<Integer> getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(ArrayList<Integer> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	@Override
	public String toString() {
		return id + ". " + nome;
	}
	
}
