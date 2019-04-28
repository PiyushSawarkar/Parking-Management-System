import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class ShowRevenueGenerated extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowRevenueGenerated frame = new ShowRevenueGenerated();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */Connection con=null;
	public ShowRevenueGenerated() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		setBackground(new Color(255, 255, 204));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRevenuegeneratedDateWise = new JLabel("Revenue Generated Date Wise");
		lblRevenuegeneratedDateWise.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevenuegeneratedDateWise.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblRevenuegeneratedDateWise.setBounds(280, 15, 454, 39);
		contentPane.add(lblRevenuegeneratedDateWise);
		
		JLabel label_1 = new JLabel("Load data");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					String query1 ="select * from park.revenueforpms";
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs1 = stmt.executeQuery(query1);
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e23) {
					// TODO: handle exception
				}
			
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		label_1.setBounds(25, 89, 201, 56);
		contentPane.add(label_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 168, 1036, 482);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(40);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanelDashboard a= new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(ShowRevenueGenerated.class.getResource("/img_Driver/back-arrow.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label.setBounds(930, 0, 106, 53);
		contentPane.add(label);
		
		
	}

}
