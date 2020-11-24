package controller;

import java.time.LocalDate;
import model.vo.PessoaVO;

public class PessoaController {

	public static void inserir(int id, String nome, String cpf, LocalDate nascimento, char sexo, String telefone, String celular,
			String email, String bairro, String cidade, char estado, String cep) {
		
		PessoaVO pessoa = new PessoaVO(id,nome,cpf,nascimento, sexo, telefone, celular, email, bairro, cidade, estado, cep);
	}
}



