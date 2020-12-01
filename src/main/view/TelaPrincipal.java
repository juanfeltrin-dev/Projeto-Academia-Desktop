package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		menuCadastro.setForeground(Color.BLACK);
		menuCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menuCadastro);
		
		JMenuItem menuItemCadastroAluno = new JMenuItem("Aluno");
		menuItemCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new CadastroAluno();
				setContentPane(contentPane);
				revalidate();				
			}
		});
		menuCadastro.add(menuItemCadastroAluno);
		
		JMenu mnNewMenu = new JMenu("Consulta");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem MenuConsultaTurmas = new JMenuItem("Turmas");
		MenuConsultaTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new ConsultaTurmas();
				setContentPane(contentPane);
				revalidate();				
			}
		});
		mnNewMenu.add(MenuConsultaTurmas);
		
		
		
	
		
		
	
	}

}
