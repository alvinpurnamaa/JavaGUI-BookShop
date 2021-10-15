import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	//Connect 
	Connect conn = new Connect();
	
	JFrame frame;
	JLabel lblNoTelepon, lblPassword;
	JTextField txtNoTelepon;
	JPasswordField pfPassword;
	JButton btnLogin, btnReset;
	
	
	void InitialComponent() {
		//Initialiasi
		//JLabel
		lblNoTelepon = new JLabel("Nomor Tlp");
		lblPassword = new JLabel("Password");
		
		//JTextField
		txtNoTelepon = new JTextField();
		
		//JPasswordField
		pfPassword = new JPasswordField();
		
		//JButton
		btnLogin = new JButton("Login");
		btnReset = new JButton("Reset");
		
	}
	
	void Header() {
		//JPanel untuk menampilkan label,textfield, dan password
		JPanel panel = new JPanel(new GridLayout(2,1));
		
		JPanel panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(lblNoTelepon);
		panel2.add(txtNoTelepon);
		panel.add(panel2);
		
		panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(lblPassword);
		panel2.add(pfPassword);
		panel.add(panel2);
		
		add(panel, BorderLayout.CENTER);
		

	}
	
	void Footer() {
		//JPanel menampilkan untuk button
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(btnLogin);
		panel.add(btnReset);
		
		add(panel, BorderLayout.SOUTH);
		
		//Action Listener untuk melakukan action pindah halaman
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
	}
	void InternalFrame() {
		//Set Frame
		setTitle("Login Form");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public Login() {
		InitialComponent();
		InternalFrame();
		Header();
		Footer();
	}

	public static void main(String[] args) {
		new Login();

	}
	
	//validasi 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin)
			try {
				if (txtNoTelepon.equals("") || pfPassword.equals("") ){
					//JOption Pane untuk show message dialog
					JOptionPane.showMessageDialog(this, "Nomor Telephone dan Password Harus diisi");
					this.dispose();
				}else {
					JOptionPane.showMessageDialog(this, "User Tidak ditemukan");
					this.dispose();
				}
			}catch (Exception e1) {
				if(e.getSource() == btnLogin) {
					//JOptionPane untuk show message dialog
					JOptionPane.showMessageDialog(this, "Selamat Datang");
					this.dispose();
					new WelcomeForm();
				}
			}
			
		}
			
	 
	}

