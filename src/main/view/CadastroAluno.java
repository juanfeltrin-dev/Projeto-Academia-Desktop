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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastroAluno extends JPanel {


	private JTextField txtEmail;
	private JTextField textField_5;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private AlunoController alunoController = new AlunoController();
	private AlunoVO alunoVO = new AlunoVO();
	private TurmaVO turmaVO = new TurmaVO();
	private JTextField txtNome;

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
		try {
			
			
			setBounds(100, 100, 708, 571);
			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Email:");
			lblNewLabel.setBounds(10, 62, 104, 25);
			add(lblNewLabel);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(113, 62, 239, 25);
			add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("CPF:");
			lblNewLabel_1.setBounds(10, 93, 104, 25);
			add(lblNewLabel_1);
			
			DatePickerSettings dateSettings = new DatePickerSettings();
			dateSettings.setAllowKeyboardEditing(false);
			
			final DateTimePicker txtNascimento = new DateTimePicker(dateSettings, null);
			txtNascimento.setBounds(492, 62, 180, 25);
			add(txtNascimento);
			
			JLabel lblNewLabel_2 = new JLabel("Data de Nascimento:");
			lblNewLabel_2.setBounds(362, 62, 129, 25);
			add(lblNewLabel_2);
			
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara de cpf
			final JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(113, 93, 239, 25);
			add(txtCpf);
			txtCpf.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setBounds(10, 129, 67, 25);
			add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Celular:");
			lblNewLabel_4.setBounds(10, 165, 67, 25);
			add(lblNewLabel_4);
			
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");//mascara TELEFONE 
			final JFormattedTextField txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(113, 129, 239, 25);
			add(txtTelefone);
			txtTelefone.setColumns(10);
				
			MaskFormatter mascaraCelular = new MaskFormatter("(##)#####-####");//mascara celular 
			final JFormattedTextField txtCelular = new JFormattedTextField(mascaraCelular);
			txtCelular.setBounds(113, 165, 239, 25);
			add(txtCelular);
			txtCelular.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("CEP:");
			lblNewLabel_5.setBounds(10, 201, 104, 25);
			add(lblNewLabel_5);
			
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP 
			final JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(113, 201, 239, 25);
			add(txtCep);
			txtCep.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
			lblNewLabel_6.setBounds(10, 309, 104, 25);
			add(lblNewLabel_6);
			
			txtEndereco = new JTextField();
			txtEndereco.setBounds(113, 309, 239, 25);
			add(txtEndereco);
			txtEndereco.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Bairro:");
			lblNewLabel_7.setBounds(10, 345, 67, 25);
			add(lblNewLabel_7);
			
			txtBairro = new JTextField();
			txtBairro.setBounds(113, 345, 239, 25);
			add(txtBairro);
			txtBairro.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("Cidade:");
			lblNewLabel_8.setBounds(10, 273, 104, 25);
			add(lblNewLabel_8);
			
			txtCidade = new JTextField();
			txtCidade.setBounds(113, 273, 239, 25);
			add(txtCidade);
			txtCidade.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("UF:");
			lblNewLabel_9.setBounds(10, 237, 104, 25);
			add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("Observac\u00F5es:");
			lblNewLabel_10.setBounds(10, 408, 104, 25);
			add(lblNewLabel_10);
			
			final JTextPane txtObservacoes = new JTextPane();
			txtObservacoes.setBorder(new LineBorder(Color.LIGHT_GRAY));
			txtObservacoes.setBounds(113, 408, 585, 105);
			add(txtObservacoes);
	
			ArrayList<String> estados = this.mockEstados();
			final JComboBox cbEstado = new JComboBox(estados.toArray());
			cbEstado.setBounds(113, 237, 239, 25);
			add(cbEstado);
			
			JLabel lblNewLabel_11 = new JLabel("Sexo:");
			lblNewLabel_11.setBounds(362, 26, 129, 25);
			add(lblNewLabel_11);
			
			final JRadioButton btnMasculino = new JRadioButton("Masculino");
			btnMasculino.setBounds(492, 26, 94, 25);
			add(btnMasculino);
			
			JRadioButton btnFeminino = new JRadioButton("Feminino");
			btnFeminino.setBounds(588, 26, 84, 25);
			add(btnFeminino);
			
			JLabel lblNewLabel_12 = new JLabel("Turma:");
			lblNewLabel_12.setBounds(362, 98, 129, 25);
			add(lblNewLabel_12);
	
			ArrayList<TurmaVO> turmas = this.alunoController.turmas();
			final JComboBox cbTurma = new JComboBox(turmas.toArray());
			cbTurma.setBounds(492, 98, 206, 25);
			add(cbTurma);
			
			JButton btnNewButton = new JButton("Limpar");
			btnNewButton.setBounds(274, 524, 89, 23);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cadastrar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						alunoVO.setEmail(txtEmail.getText());
						alunoVO.setNome(txtNome.getText());
						alunoVO.setCpf(txtCpf.getText());
						alunoVO.setNascimento(txtNascimento.getDatePicker().getDate());
						alunoVO.setTelefone(txtTelefone.getText());
						alunoVO.setCelular(txtCelular.getText());
						alunoVO.setCep(txtCep.getText());
						alunoVO.setBairro(txtBairro.getText());
						alunoVO.setCidade(txtCidade.getText());
						alunoVO.setEstado((String) cbEstado.getSelectedItem());
						alunoVO.setObservacao(txtObservacoes.getText());
						
						char sexo = btnMasculino.isSelected() ? 'M' : 'F';
						alunoVO.setSexo(sexo);
	
						int turmaId = Integer.parseInt(cbTurma.getSelectedItem().toString().replaceAll("\\D+",""));							
						turmaVO.setId(turmaId);
						alunoVO.setTurma(turmaVO);
	
						String msg = alunoController.inserir(alunoVO);
						
						JOptionPane.showMessageDialog(null, msg);
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
			btnNewButton_1.setBounds(423, 524, 104, 23);
			add(btnNewButton_1);
			
			JLabel lblNewLabel_13 = new JLabel("Nome completo:");
			lblNewLabel_13.setBounds(10, 26, 104, 25);
			add(lblNewLabel_13);
			
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(113, 26, 239, 25);
			add(txtNome);
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