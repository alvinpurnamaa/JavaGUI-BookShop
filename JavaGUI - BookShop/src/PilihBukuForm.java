import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PilihBukuForm extends JFrame {
	
	//Connect 
	Connect conn = new Connect();
	
	JFrame frame;
	JButton btnCart, btnKembali;
	
	Vector<String> header;
	Vector<String> object;
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable();
	JPanel panelTabel;
	
	void InitialComponent() {
		//Initialisasi
		
		//JButton
		btnCart = new JButton("Add to Cart");
		btnKembali = new JButton("Kembali");
	
		
		//JTable pembuatan table
		DefaultTableModel dtm = new DefaultTableModel();
		JTable table = new JTable();
		JPanel panelTabel;
		
		panelTabel = new JPanel();
		
		header = new Vector<String>();
		object = new Vector<String>();
		
		header.add("Genre");
		header.add("Judul");
		header.add("Penulis");
		header.add("Penerbit");
		header.add("Tahun");
		header.add("Harga");
		header.add("Stok");
		
		dtm.setDataVector(object, header);
		table.setModel(dtm);
		
		//JScrollPane
		panelTabel.add(new JScrollPane(table));
		add(panelTabel);
	}
	
	void Footer() {
		//JPanel untuk menampilkan button
		JPanel panel = new JPanel(new GridLayout(2,1));
		
		
		JPanel panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(btnCart);
		panel.add(panel2);
		
		panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(btnKembali);
		panel.add(panel2);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	void InternalFrame() {
		//Set Frame
		setTitle("Welcome Form");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public PilihBukuForm() {
		InitialComponent();
		InternalFrame();
		Footer();

	}

	public static void main(String[] args) {
		new PilihBukuForm();
	}

}
