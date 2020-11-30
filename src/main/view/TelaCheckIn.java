package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCheckIn extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TelaCheckIn() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(104, 118, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 115, 120, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("check-in");
		btnNewButton.setBounds(169, 245, 89, 23);
		add(btnNewButton);

	}
}
