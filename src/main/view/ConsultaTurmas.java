package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;
import controller.TurmaController;
import model.vo.AlunoVO;
import model.vo.TurmaVO;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsultaTurmas extends JPanel {
	private JTable tblTurma;
	private ArrayList<TurmaVO> Turmas;



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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(153, 27, 125, 22);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Nome da turma:");
		lblNewLabel.setBounds(42, 31, 111, 14);
		add(lblNewLabel);
		
		tblTurma = new JTable();
		tblTurma.setBounds(10, 63, 416, 226);
		add(tblTurma);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TurmaController controller = new TurmaController();
				Turmas = controller.consultarTodasTurmas();
				
				atualizarTabelaAlunos(); 
			}
		});
		btnConsultar.setBounds(338, 27, 89, 23);
		add(btnConsultar);
	}
		
		private void atualizarTabelaAlunos() {
	

			DefaultTableModel model = (DefaultTableModel) tblTurma.getModel();

			for (TurmaVO a : Turmas) {

				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");

				Object[] novaLinhaDaTabela = new Object[3];
				novaLinhaDaTabela[0] = a.getId();
				novaLinhaDaTabela[1] = a.getNome();
				novaLinhaDaTabela[2] = a.getCpf();
				

				model.addRow(novaLinhaDaTabela);
			
				}
		}
	}	