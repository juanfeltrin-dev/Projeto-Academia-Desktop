package view;

import javax.swing.JPanel;

import controller.AlunoController;
import model.vo.AlunoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class DeletarAluno extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlunoController alunoController = new AlunoController();

	/**
	 * Create the panel.
	 */
	public DeletarAluno() {
		setLayout(null);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(36, 11, 56, 14);
		add(lblAlunos);
		
		ArrayList<AlunoVO> alunos = this.alunoController.alunos();
		final JComboBox comboBox = new JComboBox(alunos.toArray());
		comboBox.setBounds(92, 8, 199, 20);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.setBounds(301, 7, 89, 23);
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int res = JOptionPane.showConfirmDialog(null, "Desejar deletar este aluno?");
					
					if (res == 0) {
						int idAluno = Integer.parseInt(comboBox.getSelectedItem().toString().replaceAll("\\D+",""));
						String msg 	= alunoController.excluir(idAluno);

						JOptionPane.showMessageDialog(null, msg);
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
				
			}
		});
	}
}
