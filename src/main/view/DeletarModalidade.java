package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private ModalidadeController modalidadeController = new ModalidadeController();
	/**
	 * Create the panel.
	 */
	public DeletarModalidade() {
		try {
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Modalidade:");
			lblNewLabel.setBounds(112, 115, 73, 14);
			add(lblNewLabel);
			
			
			final JComboBox cbxModalidade = new JComboBox(this.modalidadeController.consultarNomeModalidade().toArray());
			cbxModalidade.setBounds(195, 113, 106, 18);
			add(cbxModalidade);
			
			JButton btnNewButton = new JButton("Excluir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int modalidadeId = Integer.parseInt(cbxModalidade.getSelectedItem().toString().replaceAll("\\D+",""));
						
						String msg = modalidadeController.excluir(modalidadeId);
						
						JOptionPane.showMessageDialog(null, msg);
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
			btnNewButton.setBounds(180, 248, 89, 23);
			add(btnNewButton);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

	}
}
