package view;

import javax.swing.JPanel;

import controller.InstrutorController;
import model.vo.InstrutorVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class DeletarInstrutor extends JPanel {

	private InstrutorController instrutorController = new InstrutorController();
	
	/**
	 * Create the panel.
	 */
	public DeletarInstrutor() {
		setLayout(null);
		
		JLabel lblInstrutores = new JLabel("Instrutores:");
		lblInstrutores.setBounds(10, 11, 87, 14);
		add(lblInstrutores);
		
		ArrayList<InstrutorVO> instrutores = this.instrutorController.consultarTodos();
		final JComboBox comboBox = new JComboBox(instrutores.toArray());
		comboBox.setBounds(79, 8, 262, 20);
		add(comboBox);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(351, 7, 89, 23);
		add(btnDeletar);
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int idInstrutor = Integer.parseInt(comboBox.getSelectedItem().toString().replaceAll("\\D+",""));
					String msg = instrutorController.excluir(idInstrutor);
					
					JOptionPane.showMessageDialog(null, msg);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});

	}

}
