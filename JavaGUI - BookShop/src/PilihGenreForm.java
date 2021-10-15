import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PilihGenreForm extends Frame {
	
	//Connect
	Connect conn = new Connect();
	
	JFrame frame;
	JLabel lblText;
	JButton btnHoror, btnFantasi, btnSciFi, btnRomance, btnAll;
	
	
	void InitialComponent() {
		//Initialisasi
		//JLabel
		lblText = new JLabel("Pilih Genre yang anda minati");
		
		//JButton
		btnHoror = new JButton("Horor");
		btnFantasi = new JButton("Fantasi");
		btnSciFi = new JButton("Sci-Fi");
		btnRomance = new JButton("Romance");
		btnAll = new JButton("All");
		
	}
	
	
	void Header() {
		//JPanel untuk menampilkan label
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(lblText);
		
		add(panel , BorderLayout.NORTH);
	}
	void Center() {
		//JPanel untuk menampilkan button
		JPanel panel = new JPanel(new GridLayout(5,1));
				
		JPanel panel2 = new JPanel(new GridLayout(5,5));
		panel2.add(btnHoror);
		panel2.add(btnFantasi);
		panel2.add(btnSciFi);
		panel2.add(btnRomance);
		panel2.add(btnAll);
		panel.add(panel2);
				
				
		add(panel, BorderLayout.CENTER);
		

	}
	
	void InternalFrame() {
		//Set Frame
		setTitle("Genre Form");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	public PilihGenreForm() {
		InitialComponent();
		InternalFrame();
		Center();
		Header();
	}

	public static void main(String[] args) {
		new PilihGenreForm();

	}

}
