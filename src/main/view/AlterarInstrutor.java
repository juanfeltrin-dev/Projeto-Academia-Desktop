package view;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import controller.InstrutorController;
import model.vo.InstrutorVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AlterarInstrutor extends JPanel {
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private InstrutorController instrutorController = new InstrutorController();
	InstrutorVO instrutor = new InstrutorVO();

	/**
	 * Create the panel.
	 */
	public AlterarInstrutor() {
		try {
			setLayout(null);
			
			JLabel lblCpfDoInstrutor = new JLabel("CPF do instrutor:");
			lblCpfDoInstrutor.setBounds(10, 11, 99, 14);
			add(lblCpfDoInstrutor);
	
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			final JFormattedTextField cpf = new JFormattedTextField(mascaraCpf);
			cpf.setBounds(124, 8, 203, 20);
			add(cpf);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(10, 65, 76, 14);
			add(lblEmail);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(124, 62, 203, 20);
			add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblTelefone = new JLabel("Telefone:");
			lblTelefone.setBounds(10, 96, 76, 14);
			add(lblTelefone);

			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");//mascara TELEFONE 
			final JFormattedTextField txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(124, 93, 203, 20);
			add(txtTelefone);
			
			JLabel lblCelular = new JLabel("Celular:");
			lblCelular.setBounds(10, 127, 76, 14);
			add(lblCelular);
			
			JLabel lblCep = new JLabel("CEP:");
			lblCep.setBounds(10, 158, 76, 14);
			add(lblCep);

			MaskFormatter mascaraCelular = new MaskFormatter("(##)#####-####");//mascara celular 
			final JFormattedTextField txtCelular = new JFormattedTextField(mascaraCelular);
			txtCelular.setBounds(124, 124, 203, 20);
			add(txtCelular);

			MaskFormatter mascaraCep = new MaskFormatter("#####-###");//mascara CEP 
			final JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(124, 155, 203, 20);
			add(txtCep);
			
			JLabel lblBairro = new JLabel("Bairro:");
			lblBairro.setBounds(10, 189, 76, 14);
			add(lblBairro);
			
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(10, 223, 76, 14);
			add(lblCidade);
			
			JLabel lblUf = new JLabel("UF:");
			lblUf.setBounds(10, 248, 76, 14);
			add(lblUf);
			
			txtBairro = new JTextField();
			txtBairro.setBounds(124, 186, 203, 20);
			add(txtBairro);
			txtBairro.setColumns(10);
			
			txtCidade = new JTextField();
			txtCidade.setBounds(124, 217, 203, 20);
			add(txtCidade);
			txtCidade.setColumns(10);

			ArrayList<String> estados = this.mockEstados();
			final JComboBox cbUf = new JComboBox(estados.toArray());
			cbUf.setBounds(124, 245, 203, 20);
			add(cbUf);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						instrutor = instrutorController.buscarPeloCpf(cpf.getText());

						txtEmail.setText(instrutor.getEmail());
						txtTelefone.setText(instrutor.getTelefone());
						txtCelular.setText(instrutor.getCelular());
						txtCep.setText(instrutor.getCep());
						txtBairro.setText(instrutor.getBairro());
						txtCidade.setText(instrutor.getCidade());
						cbUf.setSelectedItem(instrutor.getEstado());
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage());
					}
				}
			});
			btnBuscar.setBounds(238, 33, 89, 23);
			add(btnBuscar);
			
			JButton btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(238, 270, 89, 23);
			add(btnAlterar);
			btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						instrutor.setEmail(txtEmail.getText());
						instrutor.setTelefone(txtTelefone.getText());
						instrutor.setCelular(txtCelular.getText());
						instrutor.setCep(txtCep.getText());
						instrutor.setBairro(txtBairro.getText());
						instrutor.setEstado((String) cbUf.getSelectedItem());
						instrutor.setCidade(txtCidade.getText());

						String msg = instrutorController.alterar(instrutor);
						
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

	private ArrayList<String> mockEstados() {
		ArrayList<String> estados = new ArrayList<String>();
		estados.add("AC");
		estados.add("AL");
		estados.add("AP");
		estados.add("AM");
		estados.add("BA");
		estados.add("CE");
		estados.add("DF");
		estados.add("ES");
		estados.add("GO");
		estados.add("MA");
		estados.add("MT");
		estados.add("MS");
		estados.add("MG");
		estados.add("PA");
		estados.add("PB");
		estados.add("PR");
		estados.add("PE");
		estados.add("PI");
		estados.add("RJ");
		estados.add("RN");
		estados.add("RS");
		estados.add("RO");
		estados.add("RR");
		estados.add("SC");
		estados.add("SP");
		estados.add("SE");
		estados.add("TO");
		
		return estados;
	}
}
