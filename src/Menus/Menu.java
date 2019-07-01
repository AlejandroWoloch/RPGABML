package Menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	// Constructors
	public Menu(String menuName, int width, int height) {
		super(menuName);
		this.setBasicSettings(600, 600);
		//this.setBackgroundColor();
		this.setHomeMenu();
	}
	
	// Methods
	public void setBasicSettings(int width, int height) {
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrudRpgImplementation = new JLabel("CRUD RPG IMPLEMENTATION");
		lblCrudRpgImplementation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCrudRpgImplementation.setBounds(136, 171, 319, 34);
		contentPane.add(lblCrudRpgImplementation);
		
		JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.setBounds(161, 255, 97, 25);
		contentPane.add(btnLogin_1);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setBounds(295, 255, 143, 25);
		contentPane.add(btnCreateAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(523, 13, 59, 25);
		contentPane.add(btnExit);
		
		JLabel lblByDucampGonzalez = new JLabel("By Ducamp, Gonzalez and Woloch");
		lblByDucampGonzalez.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblByDucampGonzalez.setBounds(12, 510, 164, 16);
		contentPane.add(lblByDucampGonzalez);
	}
	
	public void setBackgroundColor() {
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setOpaque(true);
		lblBackground.setBounds(0, 0, 594, 539);
		getContentPane().add(lblBackground);
	}
	
	public void setHomeMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu account = new JMenu("Account");
		JMenu exit = new JMenu("Exit");
		JMenuItem create = new JMenuItem("Create an account");
		JMenuItem login = new JMenuItem("Login");
		
		JMenuItem[] items = { create, login, exit };
		for(JMenuItem item: items) {
			item.addActionListener(this);
		}
			
		account.add(create);
		account.add(login);
		bar.add(account);
		bar.add(exit);
		setJMenuBar(bar);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Create an account")) {
			this.create();
		} else if(event.getActionCommand().equals("Login")) {
			this.login();
		} else if(event.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
	}
	
	private void create() {
		// TODO Auto-generated method stub
		
	}

	private void login() {
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 136, 108, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 207, 108, 16);
		contentPane.add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setText("Username");
		txtUser.setBounds(220, 133, 204, 22);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setText("Password");
		txtPass.setBounds(220, 204, 204, 22);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(220, 304, 97, 25);
		contentPane.add(btnLogin);
	}
}
