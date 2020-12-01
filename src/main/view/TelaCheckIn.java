package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.bo.AlunoBO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaCheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private AlunoBO alunoBO = new AlunoBO();

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
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("CPF: ");
			lblNewLabel.setBounds(63, 90, 46, 14);
			contentPane.add(lblNewLabel);

			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");  //mascara de cpf
			final JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(133, 87, 132, 20);
			contentPane.add(txtCpf);
			txtCpf.setColumns(10);
			
			JButton btnCheckIn = new JButton("Check-In");
			btnCheckIn.setBounds(149, 210, 89, 23);
			contentPane.add(btnCheckIn);
			
			btnCheckIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String msg = alunoBO.checkIn(txtCpf.getText());
						
						JOptionPane.showMessageDialog(null, msg);
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
