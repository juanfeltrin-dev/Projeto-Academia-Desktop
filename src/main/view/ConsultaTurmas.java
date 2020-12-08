package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

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
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class ConsultaTurmas extends JPanel {
	private JTable tblTurma;
	private ArrayList<AlunoVO> alunos;
	private AlunoController alunoController = new AlunoController();
	private TurmaController turmaController = new TurmaController();
	private JTextField txtCidade;
	private JTextField txtBairro;
	private AlunoVO alunoVO = new AlunoVO();
	private TurmaVO turmaVO = new TurmaVO();


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
		try {
			setBounds(100, 100, 597, 457);
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(null);
	
			ArrayList<TurmaVO> turmas = this.alunoController.turmas();
			final JComboBox<?> comboBox = new JComboBox<Object>(turmas.toArray());
			comboBox.setBounds(92, 7, 207, 22);
			add(comboBox);
			
			JLabel lblNewLabel = new JLabel("Nome da turma:");
			lblNewLabel.setBounds(10, 11, 111, 14);
			add(lblNewLabel);
	
			tblTurma = new JTable();
			tblTurma.setBounds(11, 114, 576, 298);
			add(tblTurma);
			
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(10, 52, 72, 14);
			add(lblCidade);
			
			txtCidade = new JTextField();
			txtCidade.setBounds(92, 49, 207, 20);
			add(txtCidade);
			txtCidade.setColumns(10);
			
			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(309, 11, 38, 14);
			add(lblCpf);
			
			JLabel lblBairro = new JLabel("Bairro:");
			lblBairro.setBounds(309, 52, 58, 14);
			add(lblBairro);
			
			txtBairro = new JTextField();
			txtBairro.setBounds(347, 49, 240, 20);
			add(txtBairro);
			txtBairro.setColumns(10);
	
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			final JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(347, 8, 240, 20);
			add(txtCpf);
			
			JButton btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int turmaId = Integer.parseInt(comboBox.getSelectedItem().toString().replaceAll("\\D+",""));
						turmaVO.setId(turmaId);
						alunoVO.setTurma(turmaVO);
						alunoVO.setCpf(txtCpf.getText());
						alunoVO.setCidade(txtCidade.getText());
						alunoVO.setBairro(txtBairro.getText());
						
						alunos = turmaController.consultarAlunosPorTurma(alunoVO);
						
						atualizarTabelaAlunos();
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
			btnConsultar.setBounds(498, 80, 89, 23);
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
			btnNewButton.setBounds(361, 423, 226, 23);
			add(btnNewButton);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
		
		private void atualizarTabelaAlunos() {
			tblTurma.setModel(new DefaultTableModel(new String[][] { { "#", "Nome", "CPF", "Cidade", "Bairro" }, },
					new String[] { "#", "Nome", "CPF", "Cidade", "Bairro" }));
			
			DefaultTableModel model = (DefaultTableModel) tblTurma.getModel();
			
			for (AlunoVO a : alunos) {
				String[] novaLinhaDaTabela = new String[] { a.getId() + "", a.getNome(), a.getCpf(), a.getCidade(), a.getBairro() };
				model.addRow(novaLinhaDaTabela);			
			}
			
		}
	}	