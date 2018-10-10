package www;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyDbHelper extends JFrame implements ActionListener {

	JButton jb1, jb2 = null;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7 = null;
	JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6, jlb7 = null;
	static String databaseName;

	public static void main(String[] a) {

		MyDbHelper sqlite = new MyDbHelper();
		String sql = sqlTestTable();
		databaseName = "D:/MessageManager.db";
		sqlite.exeCreateTable(sql, databaseName);
	}

	/**
	 * ¥¥Ω® ˝æ›ø‚
	 *
	 * @param sql
	 */
	public static void exeCreateTable(String sql, String databaseName) {
		try {
			// ¡¨Ω”SQLiteµƒJDBC
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/" + databaseName);
			Statement stat = conn.createStatement();
			// ÷¥––sqlŒƒ
			/*
			 * stat.executeUpdate("create table testtbl (name varchar(20),age varchar(20)) "
			 * ); //Ω®±Ì stat.executeUpdate("insert into testtbl values('testuser',21);");
			 * //≤Â»Î ˝æ› ResultSet rs = stat.executeQuery("select * from testtbl;"); // ≤È—Ø ˝æ›
			 *
			 * while (rs.next()) { // Ω´≤È—ØµΩµƒ ˝æ›¥Ú”°≥ˆ¿¥
			 *
			 * System.out.print("name = " + rs.getString("name") + " "); // ¡– Ù–‘“ª
			 *
			 * System.out.println("salary = " + rs.getString("age")); // ¡– Ù–‘∂˛ } rs.close();
			 * //πÿ±’Ω·π˚ºØ
			 */
			stat.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ¥¥Ω®sqlTestTable ˝æ›ø‚
	 *
	 * @return String
	 */
	private static String sqlTestTable() {
		String s = null;
		// ////////////////////////////////////////
		String s1 = "Create TABLE if not exists bookmessage( ";
		String s2 = "id integer PRIMARY KEY AUTOINCREMENT";
		String s3 = ",bookname varchar(100)";
		String s4 = ",writer varchar(100)";
		String s5 = ",publisher varchar(100)";
		String s6 = ",ctime varchar(100)";
		String s7 = ",isbn varchar(100)";
		String s8 = ",url varchar(200)";
		String s9 = ",talknum varchar(100)";
		String s10 = ");";
		// ///////////////////
		s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10;
		return s;
	}
	
	public void insert(String s1,String s2,String s3,String s4,String s5,String s6,String s7) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:/" + databaseName);
		Statement stat = conn.createStatement();
		stat.executeUpdate("insert into bookmessage(bookname,writer,publisher,ctime,isbn,url,talknum) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"');");
		conn.close();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "µ«º«":
			try {
				dengji();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "«Âø’":
			jtf1.setText(null);
			jtf2.setText(null);
			jtf3.setText(null);
			jtf4.setText(null);
			jtf5.setText(null);
			jtf6.setText(null);
			jtf7.setText(null);
			break;
		}

	}

	public MyDbHelper() {
		// ¥¥Ω®◊Èº˛
		jb1 = new JButton("µ«º«");
		jb2 = new JButton("«Âø’");
		// …Ë÷√º‡Ã˝
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel();// ––
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();

		jlb1 = new JLabel("°°°° È√˚:");
		jlb2 = new JLabel("°°°°◊˜’ﬂ:");
		jlb3 = new JLabel("°°≥ˆ∞Ê…Á:");
		jlb4 = new JLabel("≥ˆ∞Ê ±º‰:");
		jlb5 = new JLabel("°°°°ISBN:");
		jlb6 = new JLabel("°°°°Õ¯÷∑:");
		jlb7 = new JLabel("∆¿¬€Ãı ˝:");
		jtf1 = new JTextField(20);
		jtf2 = new JTextField(20);
		jtf3 = new JTextField(20);
		jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		jtf6 = new JTextField(20);
		jtf7 = new JTextField(20);
		// º”»ÎµΩJPanel÷–
		jp1.add(jlb1);
		jp1.add(jtf1);

		jp2.add(jlb2);
		jp2.add(jtf2);

		jp3.add(jlb3);
		jp3.add(jtf3);

		jp4.add(jlb4);
		jp4.add(jtf4);

		jp5.add(jlb5);
		jp5.add(jtf5);

		jp6.add(jlb6);
		jp6.add(jtf6);

		jp7.add(jlb7);
		jp7.add(jtf7);

		jp8.add(jb1); // ÃÌº”∞¥≈•
		jp8.add(jb2);

		// º”»ÎJFrame÷–
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jp7);
		this.add(jp8);

		this.setLayout(new GridLayout(8, 1)); // —°‘ÒGridLayout≤ºæ÷π‹¿Ì∆˜
		this.setTitle("Õº Èπ‹¿ÌœµÕ≥");
		this.setSize(500, 500);
		this.setLocation(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // …Ë÷√µ±πÿ±’¥∞ø⁄ ±£¨±£÷§JVM“≤ÕÀ≥ˆ
		this.setVisible(true);
		this.setResizable(true);
		this.setResizable(false);
	}
	public void dengji() throws SQLException {
		if(jtf1.getText().equals("")&&jtf2.getText().equals("")&&jtf3.getText().equals("")&&jtf4.getText().equals("")&&jtf5.getText().equals("")&&jtf6.getText().equals("")&&jtf7.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "«Î ‰»Î–≈œ¢∫Û‘Ÿ¥Ê¥¢", "¥Ê¥¢ ß∞‹", JOptionPane.INFORMATION_MESSAGE);
		}else {
			insert(jtf1.getText(), jtf2.getText(), jtf3.getText(), jtf4.getText(), jtf5.getText(), jtf6.getText(), jtf7.getText());
		}
	}
}
