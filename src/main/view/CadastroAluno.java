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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
	public CadastroAluno() {
		setBackground(Color.GRAY);
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome completo:");
		lblNewLabel.setBounds(10, 59, 83, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 61, 280, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 92, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		
		final DatePicker date = new DatePicker(dateSettings);
		date.setBounds(451, 116, 180, 40);
		getContentPane().add(date);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento:");
		lblNewLabel_2.setBounds(312, 116, 129, 14);
		contentPane.add(lblNewLabel_2);
		
		try {
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara de cpf
		JFormattedTextField textField_2 = new JFormattedTextField(mascaraCpf);
		textField_2.setBounds(113, 90, 67, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setBounds(10, 128, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setBounds(10, 153, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");//mascara TELEFONE 
			JFormattedTextField textField_3 = new JFormattedTextField(mascaraTelefone);
			textField_3.setBounds(113, 122, 99, 18);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				MaskFormatter mascaraCelular = new MaskFormatter("(##)#####-####");//mascara celular 
				JFormattedTextField textField_4 = new JFormattedTextField(mascaraCelular);
				textField_4.setBounds(113, 151, 99, 18);
				contentPane.add(textField_4);
				textField_4.setColumns(10);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		JLabel lblNewLabel_5 = new JLabel("CEP:");
		lblNewLabel_5.setBounds(10, 182, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		try {
		MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP 
		JFormattedTextField textField_5 = new JFormattedTextField(mascaraCep);
		textField_5.setBounds(113, 180, 99, 18);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
		lblNewLabel_6.setBounds(7, 211, 70, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(113, 209, 189, 18);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Bairro:");
		lblNewLabel_7.setBounds(10, 240, 67, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(113, 238, 189, 18);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cidade:");
		lblNewLabel_8.setBounds(10, 269, 67, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_8 = new JTextField();
		textField_8.setBounds(113, 267, 189, 18);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("UF:");
		lblNewLabel_9.setBounds(10, 298, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Observac\u00F5es:");
		lblNewLabel_10.setBounds(10, 325, 83, 14);
		contentPane.add(lblNewLabel_10);
		
		JTextPane txtObservacoes = new JTextPane();
		txtObservacoes.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtObservacoes.setBounds(113, 325, 195, 105);
		contentPane.add(txtObservacoes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 296, 99, 18);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Sexo:");
		lblNewLabel_11.setBounds(312, 90, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setBounds(451, 83, 94, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setBounds(547, 83, 84, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_12 = new JLabel("Modalidade:");
		lblNewLabel_12.setBounds(337, 211, 83, 14);
		contentPane.add(lblNewLabel_12);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(451, 209, 109, 18);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setBounds(276, 482, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(423, 482, 104, 23);
		contentPane.add(btnNewButton_1);
	}
}
