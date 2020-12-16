package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ModalidadeController;
import model.vo.ModalidadeVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroModalidade extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private ModalidadeVO modalidadeVO = new ModalidadeVO();
	private ModalidadeController modalidadeController = new ModalidadeController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroModalidade frame = new CadastroModalidade();
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
	public CadastroModalidade() {
	
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(58, 64, 37, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(119, 62, 169, 17);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar Modalidade");
		btnNewButton.setBounds(100, 198, 198, 23);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modalidadeVO.setNome(textField.getText());
					
					String msg = modalidadeController.inserir(modalidadeVO);
					
					JOptionPane.showMessageDialog(null, msg);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
	}
}
