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

import controller.ModalidadeController;
import controller.TurmaController;
import model.bo.TurmaBO;
import model.vo.ModalidadeVO;
import model.vo.TurmaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class CadastroTurma extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private TurmaVO turmaVO = new TurmaVO();
	private TurmaBO turmaBO = new TurmaBO();
	private TurmaController turmaController = new TurmaController();
	private ModalidadeController modalidadeController = new ModalidadeController();

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
		
		setBounds(100, 100, 528, 456);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da turma:");
		lblNewLabel.setBounds(23, 32, 79, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(112, 29, 163, 20);
		add(textField);
		textField.setColumns(10);
		
		TimePickerSettings timeSettings = new TimePickerSettings();
		timeSettings.setAllowKeyboardEditing(false);
		
		
		final TimePicker time = new TimePicker(timeSettings);
		time.setBounds(23, 75, 119, 29);
		add(time);
		
		JButton btnNewButton = new JButton("Cadastrar Turma");
		btnNewButton.setBounds(178, 367, 141, 23);
		add(btnNewButton);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Segunda - Feira");
		chckbxNewCheckBox.setBounds(23, 121, 119, 23);
		add(chckbxNewCheckBox);
		
		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ter\u00E7a - Feira");
		chckbxNewCheckBox_1.setBounds(22, 147, 97, 23);
		add(chckbxNewCheckBox_1);
		
		final JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Quarta - Feira");
		chckbxNewCheckBox_2.setBounds(23, 173, 97, 23);
		add(chckbxNewCheckBox_2);
		
		final JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Quinta - Feira");
		chckbxNewCheckBox_3.setBounds(23, 199, 97, 23);
		add(chckbxNewCheckBox_3);
		
		final JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Sexta - Feira");
		chckbxNewCheckBox_4.setBounds(23, 225, 97, 23);
		add(chckbxNewCheckBox_4);		
		
		JLabel lblModalidade = new JLabel("Modalidade:");
		lblModalidade.setBounds(285, 32, 79, 14);
		add(lblModalidade);
		
		ArrayList<ModalidadeVO> modalidades = this.modalidadeController.consultarNomeModalidade();
		JComboBox comboBox = new JComboBox(modalidades.toArray());
		comboBox.setBounds(353, 29, 144, 20);
		add(comboBox);

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
				
				try {
					String msg = turmaController.inserir(turmaVO);

					JOptionPane.showMessageDialog(null, msg);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
	}
}
