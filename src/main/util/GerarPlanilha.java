package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.vo.AlunoVO;



public class GerarPlanilha {

	/**
	 * Gera uma planilha Excel (formato .xlsx) a partir de uma lista de produtos
	 * 
	 * @param caminho onde a planilha será salva
	 * @param produtos       a lista de produtos
	 * 
	 * @return uma mensagem informando ao usuário o que ocorreu.
	 */
	public String gerarPlanilhaAlunos(String caminho, ArrayList<AlunoVO> alunos) {
		// Criar a planilha (Workbook)
		XSSFWorkbook planilha = new XSSFWorkbook();

		// Criar uma aba (Sheet)
		XSSFSheet aba = planilha.createSheet("alunos");

		int linhaAtual = 0;

		// Criar o cabeçalho (header)
		String[] nomesColunas = { "ID", "Nome", "CPF", "Cidade", "Bairro" };
		linhaAtual = criarCabecalho(nomesColunas, aba, linhaAtual);
		
		// Preencher as linhas com os produtos
		criarLinhasAlunos(alunos	, aba, linhaAtual);

		// Salvar o arquivo gerado no disco
		return salvarNoDisco(planilha, caminho, ".xlsx");
	}

	private void criarLinhasAlunos(ArrayList<AlunoVO> consultarAlunosPorTurma, XSSFSheet aba, int posicaoLinhaAtual) {
		for (AlunoVO aluno : consultarAlunosPorTurma) {
			XSSFRow linhaAtual = aba.createRow(posicaoLinhaAtual);

			linhaAtual.createCell(0).setCellValue(aluno.getId());
			linhaAtual.createCell(1).setCellValue(aluno.getNome());
			linhaAtual.createCell(2).setCellValue(aluno.getCpf());
			linhaAtual.createCell(3).setCellValue(aluno.getCidade());
			linhaAtual.createCell(4).setCellValue(aluno.getBairro());
			
			posicaoLinhaAtual++;
		}

	}

	private int criarCabecalho(String[] nomesColunas, XSSFSheet aba, int posicaoLinhaAtual) {
		XSSFRow linhaAtual = aba.createRow(posicaoLinhaAtual);

		for (int i = 0; i < nomesColunas.length; i++) {
			linhaAtual.createCell(i).setCellValue(nomesColunas[i]);
		}
		
		posicaoLinhaAtual++;

		return posicaoLinhaAtual;
	}

	private String salvarNoDisco(XSSFWorkbook planilha, String caminho, String extensao) {
		String mensagem = "";
		FileOutputStream saida = null;

		try {
			saida = new FileOutputStream(new File(caminho + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			// TODO lançar exceções de negócio (para poder capturar as causas no controller
			// ou tela)
			mensagem = "Erro ao tentar salvar planilha em: " + caminho + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro ao tentar salvar planilha em: " + caminho + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminho + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}

		return mensagem;
	}
}