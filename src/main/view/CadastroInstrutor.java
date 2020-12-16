package view;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controller.InstrutorController;
import model.vo.InstrutorVO;
import util.JNumberFormatField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroInstrutor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNome;
	
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private InstrutorVO instrutorVO = new InstrutorVO();
	private InstrutorController instrutorController = new InstrutorController();
	
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
	public CadastroInstrutor() {
		try {		
			setBounds(100, 100, 724, 571);
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nome completo:");
			lblNewLabel.setBounds(10, 11, 109, 25);
			add(lblNewLabel);
			
			txtNome = new JTextField();
			txtNome.setBounds(122, 15, 255, 25);
			add(txtNome);
			txtNome.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("CPF:");
			lblNewLabel_1.setBounds(10, 123, 109, 25);
			add(lblNewLabel_1);
			
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara de cpf
			final JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(122, 123, 255, 25);
			add(txtCpf);
			txtCpf.setColumns(10);
	
			JLabel lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setBounds(10, 159, 109, 25);
			add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Celular:");
			lblNewLabel_4.setBounds(10, 195, 109, 25);
			add(lblNewLabel_4);
	
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");//mascara TELEFONE 
			final JFormattedTextField txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(122, 159, 255, 25);
			add(txtTelefone);
			txtTelefone.setColumns(10);
		
			MaskFormatter mascaraCelular = new MaskFormatter("(##)#####-####");//mascara celular 
			final JFormattedTextField txtCelular = new JFormattedTextField(mascaraCelular);
			txtCelular.setBounds(122, 195, 255, 25);
			add(txtCelular);
			txtCelular.setColumns(10);
		
		
			JLabel lblNewLabel_5 = new JLabel("CEP:");
			lblNewLabel_5.setBounds(10, 231, 109, 25);
			add(lblNewLabel_5);
			
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP 
			final JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(122, 231, 255, 25);
			add(txtCep);
			txtCep.setColumns(10);
		
			JLabel lblData = new JLabel("Data admiss\u00E3o:");
			lblData.setBounds(10, 87, 109, 25);
			add(lblData);
	
			DatePickerSettings dateSettings = new DatePickerSettings();
			dateSettings.setAllowKeyboardEditing(false);
			
			final DatePicker admissao = new DatePicker(dateSettings);
			admissao.setBounds(122, 87, 180, 25);
			add(admissao);
		
			JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
			lblNewLabel_6.setBounds(10, 339, 112, 25);
			add(lblNewLabel_6);
			
			txtEndereco = new JTextField();
			txtEndereco.setBounds(122, 339, 255, 25);
			add(txtEndereco);
			txtEndereco.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Bairro:");
			lblNewLabel_7.setBounds(10, 375, 109, 25);
			add(lblNewLabel_7);
			
			txtBairro = new JTextField();
			txtBairro.setBounds(122, 375, 255, 25);
			add(txtBairro);
			txtBairro.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Cidade:");
			lblNewLabel_8.setBounds(10, 303, 109, 25);
			add(lblNewLabel_8);
			
			txtCidade = new JTextField();
			txtCidade.setBounds(122, 303, 255, 25);
			add(txtCidade);
			txtCidade.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("UF:");
			lblNewLabel_9.setBounds(10, 267, 109, 25);
			add(lblNewLabel_9);

			ArrayList<String> estados = this.mockEstados();
			final JComboBox cbxUf = new JComboBox(estados.toArray());
			cbxUf.setBounds(122, 267, 255, 25);
			add(cbxUf);
			
			JLabel lblNewLabel_11 = new JLabel("Sexo:");
			lblNewLabel_11.setBounds(397, 11, 89, 25);
			add(lblNewLabel_11);
			
			final JRadioButton btnMasculino = new JRadioButton("Masculino");
			btnMasculino.setBounds(486, 11, 77, 25);
			add(btnMasculino);
			
			JRadioButton btnFeminino = new JRadioButton("Feminino");
			btnFeminino.setBounds(605, 11, 109, 25);
			add(btnFeminino);
			
			JLabel lblNewLabel_12 = new JLabel("Salario:");
			lblNewLabel_12.setBounds(397, 47, 89, 25);
			add(lblNewLabel_12);
		
			final JNumberFormatField txtSalario = new JNumberFormatField();
			txtSalario.setBounds(486, 83, 228, 25);
			add(txtSalario);
			txtSalario.setColumns(10);
			
			final DatePicker nascimento = new DatePicker();
			nascimento.setBounds(486, 47, 180, 25);
			add(nascimento);
			
			JButton btnNewButton = new JButton("Limpar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(160, 476, 89, 23);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cadastrar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						instrutorVO.setEmail(txtEmail.getText());
						instrutorVO.setNome(txtNome.getText());
						instrutorVO.setSalario(txtSalario.getValue().doubleValue());
						instrutorVO.setCpf(txtCpf.getText());
						instrutorVO.setNascimento(nascimento.getDate());
						instrutorVO.setDataAdmissao(admissao.getDate());
						instrutorVO.setTelefone(txtTelefone.getText());
						instrutorVO.setCelular(txtCelular.getText());
						instrutorVO.setCep(txtCep.getText());
						instrutorVO.setBairro(txtBairro.getText());
						instrutorVO.setCidade(txtCidade.getText());
						instrutorVO.setEstado((String) cbxUf.getSelectedItem());

						char sexo = btnMasculino.isSelected() ? 'M' : 'F';
						instrutorVO.setSexo(sexo);
						
						String msg = instrutorController.inserir(instrutorVO);
						
						JOptionPane.showMessageDialog(null, msg);
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
			btnNewButton_1.setBounds(311, 476, 89, 23);
			add(btnNewButton_1);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(122, 51, 255, 25);
			add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Email:");
			lblNewLabel_2.setBounds(10, 51, 109, 25);
			add(lblNewLabel_2);
			
			JLabel lblNascimento = new JLabel("Nascimento:");
			lblNascimento.setBounds(397, 83, 89, 25);
			add(lblNascimento);
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
