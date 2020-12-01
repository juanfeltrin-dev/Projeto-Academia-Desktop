package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunoController;
import controller.ModalidadeController;
import controller.TurmaController;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletarModalidade extends JPanel {

	private JComboBox<Object> comboBoxModalidade;
	/**
	 * Create the panel.
	 */
	public DeletarModalidade() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modalidade:");
		lblNewLabel.setBounds(112, 115, 73, 14);
		add(lblNewLabel);
		
		ModalidadeController modalidadeController = new ModalidadeController();
		JComboBox cbxModalidade = new JComboBox(modalidadeController.consultarNomeModalidade().toArray());
		cbxModalidade.setBounds(195, 113, 106, 18);
		add(cbxModalidade);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoController controller = new AlunoController();
				controller.excluir(alunoId, pesssoaId);
			}
		});
		btnNewButton.setBounds(180, 248, 89, 23);
		add(btnNewButton);

	}
}
