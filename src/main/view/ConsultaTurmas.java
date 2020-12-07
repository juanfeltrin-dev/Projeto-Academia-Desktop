package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.AlunoController;
import controller.TurmaController;
import model.vo.AlunoVO;
import model.vo.TurmaVO;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsultaTurmas extends JPanel {
	private JTable tblTurma;
	private ArrayList<AlunoVO> alunos;
	private AlunoController alunoController = new AlunoController();
	private TurmaController turmaController = new TurmaController();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTurmas frame = new ConsultaTurmas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaTurmas() {
		
		setBounds(100, 100, 489, 397);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		ArrayList<TurmaVO> turmas = this.alunoController.turmas();
		final JComboBox<?> comboBox = new JComboBox<Object>(turmas.toArray());
		comboBox.setBounds(153, 27, 125, 22);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Nome da turma:");
		lblNewLabel.setBounds(42, 31, 111, 14);
		add(lblNewLabel);
		
		DefaultTableModel model = new DefaultTableModel();
		tblTurma = new JTable(model);
		tblTurma.setBounds(10, 63, 416, 226);
		add(tblTurma);
		tblTurma.setRowSorter(new TableRowSorter<DefaultTableModel>(model));//filtro tabela
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int turmaId = Integer.parseInt(comboBox.getSelectedItem().toString().replaceAll("\\D+",""));	
					alunos 		= turmaController.consultarAlunosPorTurma(turmaId);
					
					atualizarTabelaAlunos();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
		btnConsultar.setBounds(338, 27, 89, 23);
		add(btnConsultar);
		
		JButton btnNewButton = new JButton("Gerar Arquivo XLS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser janelaArquivos = new JFileChooser();

				int opcaoSelecionada = janelaArquivos.showSaveDialog(null);

				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminho = janelaArquivos.getSelectedFile().getAbsolutePath();

					TurmaController controller = new TurmaController();
					String mensagem = controller.gerarPlanilha(alunos, caminho);

					JOptionPane.showMessageDialog(null, mensagem);
				}
			}
		});
		btnNewButton.setBounds(121, 348, 226, 23);
		add(btnNewButton);
	}
		
		private void atualizarTabelaAlunos() {
	
			DefaultTableModel model = (DefaultTableModel) tblTurma.getModel();
			
			model.setRowCount(0);
			model.setColumnCount(0);

			for (AlunoVO a : alunos) {

				model.addColumn("Matricula");
				model.addColumn("Nome");
				model.addColumn("CPF");
				
				Object[] novaLinhaDaTabela = new Object[3];
				novaLinhaDaTabela[0] = a.getId();
				novaLinhaDaTabela[1] = a.getNome();
				novaLinhaDaTabela[2] = a.getCpf();
				

				model.addRow(novaLinhaDaTabela);			
			}
			
		}
	}	