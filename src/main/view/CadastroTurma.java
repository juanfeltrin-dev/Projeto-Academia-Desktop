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
		
		JLabel lblNewLabel = new JLabel("Nome da turma*:");
		lblNewLabel.setBounds(10, 29, 104, 25);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(112, 29, 406, 25);
		add(textField);
		textField.setColumns(10);
		
		TimePickerSettings timeSettings = new TimePickerSettings();
		timeSettings.setAllowKeyboardEditing(false);
		
		
		final TimePicker time = new TimePicker(timeSettings);
		time.setBounds(112, 101, 406, 25);
		add(time);
		
		JButton btnNewButton = new JButton("Cadastrar Turma");
		btnNewButton.setBounds(178, 367, 141, 23);
		add(btnNewButton);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Segunda - Feira");
		chckbxNewCheckBox.setBounds(113, 137, 119, 25);
		add(chckbxNewCheckBox);
		
		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ter\u00E7a - Feira");
		chckbxNewCheckBox_1.setBounds(112, 163, 97, 25);
		add(chckbxNewCheckBox_1);
		
		final JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Quarta - Feira");
		chckbxNewCheckBox_2.setBounds(113, 189, 97, 25);
		add(chckbxNewCheckBox_2);
		
		final JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Quinta - Feira");
		chckbxNewCheckBox_3.setBounds(113, 215, 97, 25);
		add(chckbxNewCheckBox_3);
		
		final JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Sexta - Feira");
		chckbxNewCheckBox_4.setBounds(113, 241, 97, 25);
		add(chckbxNewCheckBox_4);		
		
		JLabel lblModalidade = new JLabel("Modalidade*:");
		lblModalidade.setBounds(10, 65, 79, 25);
		add(lblModalidade);
		
		ArrayList<ModalidadeVO> modalidades = this.modalidadeController.consultarNomeModalidade();
		JComboBox comboBox = new JComboBox(modalidades.toArray());
		comboBox.setBounds(112, 65, 406, 25);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Hora*:");
		lblNewLabel_1.setBounds(10, 101, 104, 25);
		add(lblNewLabel_1);
		
		JLabel lblDiasDaSemana = new JLabel("Dias da semana*:");
		lblDiasDaSemana.setBounds(10, 137, 104, 25);
		add(lblDiasDaSemana);

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
