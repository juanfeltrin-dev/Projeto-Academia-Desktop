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
import javax.swing.ImageIcon;

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
		menuItemCadastroAluno.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/CadastroInstrutor.png")));
		menuItemCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new CadastroAluno();
				setContentPane(contentPane);
				revalidate();				
			}
		});
		menuCadastro.add(menuItemCadastroAluno);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instrutor");
		mntmNewMenuItem.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/CadastroAluno.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new CadastroInstrutor();
				setContentPane(contentPane);
				revalidate();		
			}
		});
		menuCadastro.add(mntmNewMenuItem);
		
		JMenuItem CadastroModalidade = new JMenuItem("Modalidade");
		CadastroModalidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/modalidade.png")));
		CadastroModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new CadastroModalidade();
				setContentPane(contentPane);
				revalidate();	
			}
		});
		menuCadastro.add(CadastroModalidade);
		
		JMenuItem CadastroTurma = new JMenuItem("Turma");
		CadastroTurma.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/turma.png")));
		CadastroTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new CadastroTurma();
				setContentPane(contentPane);
				revalidate();	
			}
		});
		menuCadastro.add(CadastroTurma);
		
		JMenu mnNewMenu = new JMenu("Consulta");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem MenuConsultaTurmas = new JMenuItem("Turmas");
		MenuConsultaTurmas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/lupa.png")));
		MenuConsultaTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new ConsultaTurmas();
				setContentPane(contentPane);
				revalidate();				
			}
		});
		mnNewMenu.add(MenuConsultaTurmas);

		JMenu menuAlterar = new JMenu("Alterar");
		menuAlterar.setHorizontalAlignment(SwingConstants.LEFT);
		menuAlterar.setForeground(Color.BLACK);
		menuAlterar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menuAlterar);
		
		JMenuItem menuItemEdicaoAluno = new JMenuItem("Aluno");
		menuItemEdicaoAluno.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/CadastroInstrutor.png")));
		menuItemEdicaoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new AlterarAluno();
				setContentPane(contentPane);
				revalidate();				
			}
		});
		menuAlterar.add(menuItemEdicaoAluno);	

		JMenu menuExclusao = new JMenu("Exclusão");
		menuExclusao.setHorizontalAlignment(SwingConstants.LEFT);
		menuExclusao.setForeground(Color.BLACK);
		menuExclusao.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menuExclusao);	

		
		JMenuItem exclusaoModalidade = new JMenuItem("Modalidade");
		exclusaoModalidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/modalidade.png")));
		exclusaoModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new DeletarModalidade();
				setContentPane(contentPane);
				revalidate();	
			}
		});
		menuExclusao.add(exclusaoModalidade);
	}

}
