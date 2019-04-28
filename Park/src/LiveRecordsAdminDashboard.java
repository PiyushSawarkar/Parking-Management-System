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

public class LiveRecordsAdminDashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiveRecordsAdminDashboard frame = new LiveRecordsAdminDashboard();
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
	Connection con=null;
	public LiveRecordsAdminDashboard() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLiveRecords = new JLabel("Live Records");
		lblLiveRecords.setBounds(375, 13, 570, 39);
		lblLiveRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveRecords.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		contentPane.add(lblLiveRecords);
		
		JLabel label = new JLabel("");
		label.setBounds(1268, 0, 106, 53);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminPanelDashboard a = new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(LiveRecordsAdminDashboard.class.getResource("/img_Driver/back-arrow.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		contentPane.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		scrollPane_1.setBackground(new Color(255, 255, 204));
		scrollPane_1.setBounds(0, 162, 1374, 505);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setBackground(new Color(255, 255, 204));
		scrollPane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(40);
		JLabel lblLoadData = new JLabel("Load data");
		lblLoadData.setBounds(29, 78, 219, 39);
		lblLoadData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query1 ="select * from park.detailtb";
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs1 = stmt.executeQuery(query1);
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e23) {
					// TODO: handle exception
				}
			}
		});
		lblLoadData.setForeground(Color.GRAY);
		lblLoadData.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		lblLoadData.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLoadData);
	}
}
