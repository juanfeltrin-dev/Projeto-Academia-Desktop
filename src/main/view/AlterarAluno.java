package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;

import controller.AlunoController;
import model.vo.AlunoVO;
import model.vo.TurmaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AlterarAluno extends JPanel {


	private JTextField txtEmail;
	private JTextField textField_5;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private AlunoController alunoController = new AlunoController();
	private AlunoVO alunoVO = new AlunoVO();
	
	private JTextField textField;
	private AlunoVO aluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
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
	public AlterarAluno() {
		try {
			setBounds(100, 100, 708, 571);
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Email:");
			lblNewLabel.setBounds(10, 95, 89, 22);
			add(lblNewLabel);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(103, 94, 290, 25);
			add(txtEmail);
			txtEmail.setColumns(10);
			
			DatePickerSettings dateSettings = new DatePickerSettings();
			dateSettings.setAllowKeyboardEditing(false);
			
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			
			JLabel lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setBounds(10, 130, 89, 25);
			add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Celular:");
			lblNewLabel_4.setBounds(10, 166, 67, 25);
			add(lblNewLabel_4);
			
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");//mascara TELEFONE 
			final JFormattedTextField txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(103, 130, 290, 25);
			add(txtTelefone);
			txtTelefone.setColumns(10);
				
			MaskFormatter mascaraCelular = new MaskFormatter("(##)#####-####");//mascara celular 
			final JFormattedTextField txtCelular = new JFormattedTextField(mascaraCelular);
			txtCelular.setBounds(103, 166, 290, 25);
			add(txtCelular);
			txtCelular.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("CEP:");
			lblNewLabel_5.setBounds(10, 202, 89, 25);
			add(lblNewLabel_5);
			
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP 
			final JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(103, 202, 290, 25);
			add(txtCep);
			txtCep.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
			lblNewLabel_6.setBounds(10, 310, 92, 25);
			add(lblNewLabel_6);
			
			txtEndereco = new JTextField();
			txtEndereco.setBounds(103, 310, 290, 25);
			add(txtEndereco);
			txtEndereco.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Bairro:");
			lblNewLabel_7.setBounds(10, 346, 89, 25);
			add(lblNewLabel_7);
			
			txtBairro = new JTextField();
			txtBairro.setBounds(103, 274, 290, 25);
			add(txtBairro);
			txtBairro.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Cidade:");
			lblNewLabel_8.setBounds(10, 274, 67, 25);
			add(lblNewLabel_8);
			
			txtCidade = new JTextField();
			txtCidade.setBounds(103, 346, 290, 25);
			add(txtCidade);
			txtCidade.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("UF:");
			lblNewLabel_9.setBounds(10, 238, 89, 25);
			add(lblNewLabel_9);
	
			ArrayList<String> estados = this.mockEstados();
			final JComboBox cbEstado = new JComboBox(estados.toArray());
			cbEstado.setBounds(103, 238, 290, 25);
			add(cbEstado);
	
			ArrayList<TurmaVO> turmas = this.alunoController.turmas();
			
			
			JLabel lblNewLabel_1 = new JLabel("CPF do Aluno:");
			lblNewLabel_1.setBounds(10, 11, 89, 25);
			add(lblNewLabel_1);

			final JFormattedTextField buscarCpf = new JFormattedTextField(mascaraCpf);
			buscarCpf.setBounds(103, 11, 290, 25);
			add(buscarCpf);
			buscarCpf.setColumns(10);
			
			final JLabel nome = new JLabel("");
			nome.setBounds(10, 47, 383, 25);
			add(nome);
			
			JButton btnNewButton_2 = new JButton("Buscar");
			btnNewButton_2.setBounds(403, 11, 89, 25);
			add(btnNewButton_2);			
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						aluno = alunoController.buscarPeloCpf(buscarCpf.getText());

						nome.setText(aluno.getNome());
						txtEmail.setText(aluno.getEmail());
						txtTelefone.setText(aluno.getTelefone());
						txtCelular.setText(aluno.getCelular());
						txtCep.setText(aluno.getCep());
						txtBairro.setText(aluno.getBairro());
						txtCidade.setText(aluno.getCidade());
						cbEstado.setSelectedItem(aluno.getEstado());
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
			
			JButton btnNewButton_3 = new JButton("Salvar Altera\u00E7\u00F5es");
			btnNewButton_3.setBounds(276, 408, 128, 23);
			add(btnNewButton_3);
			
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						aluno.setEmail(txtEmail.getText());
						aluno.setTelefone(txtTelefone.getText());
						aluno.setCelular(txtCelular.getText());
						aluno.setCep(txtCep.getText());
						aluno.setBairro(txtBairro.getText());
						aluno.setEstado((String) cbEstado.getSelectedItem());
						aluno.setCidade(txtCidade.getText());

						String msg = alunoController.alterar(aluno);
						
						JOptionPane.showMessageDialog(null, msg);
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> mockEstados() {
		ArrayList<String> estados = new ArrayList<String>();
		estados.add("AC");
		estados.add("AL");
		estados.add("AP");
		estados.add("AM");
		estados.add("BA");
		estados.add("CE");
		estados.add("DF");
		estados.add("ES");
		estados.add("GO");
		estados.add("MA");
		estados.add("MT");
		estados.add("MS");
		estados.add("MG");
		estados.add("PA");
		estados.add("PB");
		estados.add("PR");
		estados.add("PE");
		estados.add("PI");
		estados.add("RJ");
		estados.add("RN");
		estados.add("RS");
		estados.add("RO");
		estados.add("RR");
		estados.add("SC");
		estados.add("SP");
		estados.add("SE");
		estados.add("TO");
		
		return estados;
	}
}