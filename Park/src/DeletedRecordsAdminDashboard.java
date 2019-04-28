
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DeletedRecordsAdminDashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletedRecordsAdminDashboard frame = new DeletedRecordsAdminDashboard();
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
	Connection con =null;
	public DeletedRecordsAdminDashboard() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1373, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLiveRecords = new JLabel("Deleted Records");
		lblLiveRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveRecords.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblLiveRecords.setBounds(240, 13, 570, 39);
		contentPane.add(lblLiveRecords);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminPanelDashboard a = new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(DeletedRecordsAdminDashboard.class.getResource("/img_Driver/back-arrow.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label.setBounds(1267, 0, 106, 53);
		contentPane.add(label);
		
		JLabel lblLoad = new JLabel("Load");
		lblLoad.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					String query1 ="select * from park.deletetb";
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs1 = stmt.executeQuery(query1);
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e23) {
					// TODO: handle exception
				}
				
				
				
			}
		});
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoad.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblLoad.setBounds(12, 81, 179, 53);
		contentPane.add(lblLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 147, 1373, 520);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
