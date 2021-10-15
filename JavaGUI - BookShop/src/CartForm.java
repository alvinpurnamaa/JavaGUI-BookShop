import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CartForm extends JFrame{
	
	JFrame frame;
	JButton btnCheckOut, btnHapus, btnKembali;

	Vector<String> header;
	Vector<Vector> values;
	
	DefaultTableModel dtm;
	JTable table;
	JPanel panelTabel;
	
	Connection connect;
	Statement st;
	ResultSet rs;
	
	
	void InitialComponent () {
		//Inisialisasi
		//JButton
		btnCheckOut = new JButton("Checkout");
		btnHapus = new JButton("Hapus");
		btnKembali = new JButton("Kembali");
		
		header = new Vector<String>();	
		header.add("Judul");
		header.add("Genre");
		header.add("Jumlah");
		header.add("Total Harga");
				
		
		values = new Vector<Vector>();
		
		dtm = new DefaultTableModel();
		dtm.setDataVector(values, header);
		table = new JTable(dtm);
				
		panelTabel = new JPanel();
		
		add(panelTabel,BorderLayout.NORTH);
		
		
		//JScrollPane
		panelTabel.add(new JScrollPane(table));
		add(panelTabel);
		
	}
	
	void Footer () {
		//JPanel untuk menampilkan button
		JPanel panel = new JPanel(new GridLayout(3,1));
		
		JPanel panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(btnCheckOut);
		panel.add(panel2);
		
		panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(btnHapus);
		panel.add(panel2);
		
		panel2 = new JPanel(new GridLayout(1,2));
		panel2.add(btnKembali);
		panel.add(panel2);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	void createConnect ( ){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connect = DriverManager .getConnection("jdbc:mysql://localhost:8080/test","root","");
				st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void loadData () {
		try {
			rs = st.executeQuery("SELECT * FROM test");
			while(rs.next()) {
				Vector<String> row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				
				values.add(row);
			
			}
			
			dtm.setDataVector(values, header);
			table.setModel(dtm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	void InternalFrame () {
		//Set Frame
		setTitle("Cart Form");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public CartForm() {
		InitialComponent();
		InternalFrame();
		Footer();
		createConnect();
		loadData();
	}

	public static void main(String[] args) {
		new CartForm();

	}

}
