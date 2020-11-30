package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ConsultaTurmas extends JPanel {



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
		
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(153, 27, 125, 22);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Nome da turma:");
		lblNewLabel.setBounds(42, 31, 111, 14);
		add(lblNewLabel);
	}
}
