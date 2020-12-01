package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import model.bo.TurmaBO;
import model.vo.TurmaVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class CadastroTurma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private TurmaVO turmaVO = new TurmaVO();
	private TurmaBO turmaBO = new TurmaBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroTurma frame = new CadastroTurma();
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
	public CadastroTurma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nome da turma:");
		lblNewLabel.setBounds(23, 32, 79, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(112, 29, 163, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		TimePickerSettings timeSettings = new TimePickerSettings();
		timeSettings.setAllowKeyboardEditing(false);
		
		
		final TimePicker time = new TimePicker(timeSettings);
		time.setBounds(23, 75, 119, 29);
		getContentPane().add(time);
		
		JButton btnNewButton = new JButton("Cadastrar Turma");
		btnNewButton.setBounds(178, 367, 141, 23);
		contentPane.add(btnNewButton);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Segunda - Feira");
		chckbxNewCheckBox.setBounds(23, 121, 119, 23);
		contentPane.add(chckbxNewCheckBox);
		
		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ter\u00E7a - Feira");
		chckbxNewCheckBox_1.setBounds(22, 147, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		final JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Quarta - Feira");
		chckbxNewCheckBox_2.setBounds(23, 173, 97, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		final JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Quinta - Feira");
		chckbxNewCheckBox_3.setBounds(23, 199, 97, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		final JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Sexta - Feira");
		chckbxNewCheckBox_4.setBounds(23, 225, 97, 23);
		contentPane.add(chckbxNewCheckBox_4);		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> diasDaSemana = new ArrayList<Integer>();
				
				if (chckbxNewCheckBox.isSelected()) {
					diasDaSemana.add(1);
				}
				
				if (chckbxNewCheckBox_1.isSelected()) {
					diasDaSemana.add(2);
				}
				
				if (chckbxNewCheckBox_2.isSelected()) {
					diasDaSemana.add(3);
				}
				
				if (chckbxNewCheckBox_3.isSelected()) {
					diasDaSemana.add(4);
				}
				
				if (chckbxNewCheckBox_4.isSelected()) {
					diasDaSemana.add(5);
				}
				
				turmaVO.setNome(textField.getText());
				turmaVO.setDiasDaSemana(diasDaSemana);
				turmaVO.setHorario(time.getTime());
				
				turmaBO.inserir(turmaVO);
			}
		});
	}
}
