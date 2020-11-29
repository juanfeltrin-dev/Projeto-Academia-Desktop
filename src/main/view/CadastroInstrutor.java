package view;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;

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
import java.awt.event.ActionEvent;

public class CadastroInstrutor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
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
	public CadastroInstrutor() {
		setTitle("Cadastro de Instrutor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome completo:");
		lblNewLabel.setBounds(10, 41, 83, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(122, 45, 255, 14);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 106, 24, 14);
		contentPane.add(lblNewLabel_1);
		
		
		

		try {
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara de cpf
		JFormattedTextField textField_2 = new JFormattedTextField(mascaraCpf);
		textField_2.setBounds(122, 106, 99, 14);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setBounds(10, 131, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setBounds(10, 163, 46, 14);
		contentPane.add(lblNewLabel_4);
		try {
		MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");//mascara TELEFONE 
		JFormattedTextField textField_3 = new JFormattedTextField(mascaraTelefone);
		textField_3.setBounds(122, 131, 99, 14);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			MaskFormatter mascaraCelular = new MaskFormatter("(##)#####-####");//mascara celular 
			JFormattedTextField textField_4 = new JFormattedTextField(mascaraCelular);
			textField_4.setBounds(122, 163, 99, 14);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		JLabel lblNewLabel_5 = new JLabel("CEP:");
		lblNewLabel_5.setBounds(10, 190, 46, 14);
		contentPane.add(lblNewLabel_5);
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP 
			JFormattedTextField textField_5 = new JFormattedTextField(mascaraCep);
			textField_5.setBounds(122, 188, 99, 14);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 64, 40, 20);
		getContentPane().add(lblData);

		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		
		final DatePicker date = new DatePicker(dateSettings);
		date.setBounds(113, 70, 100, 19);
		getContentPane().add(date);
	
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
		lblNewLabel_6.setBounds(10, 215, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(122, 213, 99, 14);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Bairro:");
		lblNewLabel_7.setBounds(10, 244, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(122, 244, 99, 14);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cidade:");
		lblNewLabel_8.setBounds(10, 269, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_8 = new JTextField();
		textField_8.setBounds(122, 269, 99, 14);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("UF:");
		lblNewLabel_9.setBounds(10, 294, 24, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Observac\u00F5es:");
		lblNewLabel_10.setBounds(10, 319, 67, 14);
		contentPane.add(lblNewLabel_10);
		
		JTextPane txtObservacoes = new JTextPane();
		txtObservacoes.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtObservacoes.setBounds(122, 319, 195, 105);
		contentPane.add(txtObservacoes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(122, 294, 67, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Sexo:");
		lblNewLabel_11.setBounds(331, 81, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setBounds(331, 102, 77, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setBounds(410, 102, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_12 = new JLabel("Salario:");
		lblNewLabel_12.setBounds(330, 146, 36, 14);
		contentPane.add(lblNewLabel_12);
		
		
		try {
			MaskFormatter	mascaraReal= new MaskFormatter("#.###,##");  // mascara de salario
			JFormattedTextField textField_9 = new JFormattedTextField(mascaraReal);
			textField_9.setBounds(376, 146, 67, 14);
			contentPane.add(textField_9);
			textField_9.setColumns(10);
			
			JButton btnNewButton = new JButton("Limpar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(160, 476, 89, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cadastrar");
			btnNewButton_1.setBounds(311, 476, 89, 23);
			contentPane.add(btnNewButton_1);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
