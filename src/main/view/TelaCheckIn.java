package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckIn frame = new TelaCheckIn();
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
	public TelaCheckIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF: ");
		lblNewLabel.setBounds(63, 90, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(133, 87, 132, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnCheckIn = new JButton("Check-In");
		btnCheckIn.setBounds(149, 210, 89, 23);
		contentPane.add(btnCheckIn);
	}

}
