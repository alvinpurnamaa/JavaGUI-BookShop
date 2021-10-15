import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeForm extends JFrame implements ActionListener {
	
	//Connect
	Connect conn = new Connect();
	
	JFrame frame; 
	JLabel lblCart, lblWelcome;
	JButton btnGenre, btnCart, btnHistoryTransaksi, btnLogout;
	
	
	void InitialComponent() {
		//Initialisasi
		//JLabel
		lblCart = new JLabel("Total Cart Anda: ");
		lblWelcome = new JLabel("Selamat Datang");
		
		//JButton
		btnGenre = new JButton("Pilih Genre");
		btnCart = new JButton("Cart");
		btnHistoryTransaksi = new JButton("History Transaksi");
		btnLogout = new JButton("Logout");
	}
	
	void Header() {
		//JPanel untuk menampilkan label
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(lblCart);
		panel.add(lblWelcome);
		
		add(panel , BorderLayout.NORTH);
	}
	
	void Center() {
		//JPanel untuk menampilkan button
		JPanel panel = new JPanel(new GridLayout(4,1));
		
		JPanel panel2 = new JPanel(new GridLayout(4,4));
		panel2.add(btnGenre);
		panel2.add(btnCart);
		panel2.add(btnHistoryTransaksi);
		panel2.add(btnLogout);
		panel.add(panel2);
		
		
		add(panel, BorderLayout.CENTER);
		
		//Action Listener untuk melakukan action pindah halaman
		btnGenre.addActionListener(this);
		btnCart.addActionListener(this);
		btnHistoryTransaksi.addActionListener(this);
		btnLogout.addActionListener(this);
		
	}
	
	void InternalFrame() {
		//Set Frame
		setTitle("Welcome Form");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public WelcomeForm() {
		InitialComponent();
		InternalFrame();
		Center();
		Header();
	}
	
	

	public static void main(String[] args) {
		new WelcomeForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGenre) {
			this.dispose();
			new PilihGenreForm();
			
		}
		else if (e.getSource() == btnCart){
			this.dispose();
			new CartForm();
			
		}
		else if (e.getSource() == btnHistoryTransaksi) {
			this.dispose();
			new HistoryTransaksiForm();
		}
		else if (e.getSource() == btnLogout) {
			this.dispose();
			new Login();
		}
	}

}
