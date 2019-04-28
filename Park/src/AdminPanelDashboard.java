import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.Cursor;

public class AdminPanelDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanelDashboard frame = new AdminPanelDashboard();
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
	public AdminPanelDashboard() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logout = new JLabel("");
		logout.setBackground(new Color(51, 0, 102));
		logout.setOpaque(true);
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Driver d = new Driver();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
			logout.setBackground(Color.red);	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logout.setBackground(new Color(51,0,102));
			
			}
		});
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/logout (8).png")));
		logout.setBounds(1029, 0, 79, 64);
		contentPane.add(logout);
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogout.setBackground(new Color(51, 0, 102));
		lblLogout.setOpaque(true);
		lblLogout.setForeground(new Color(255, 255, 255));
		lblLogout.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblLogout.setBounds(911, 13, 100, 30);
		contentPane.add(lblLogout);
		
		JLabel lblAdminsDashboard = new JLabel("  Admin's Dashboard");
		lblAdminsDashboard.setIcon(new ImageIcon("/img_Driver/admin-with-cogwheels (5).png"));
		lblAdminsDashboard.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 33));
		lblAdminsDashboard.setForeground(new Color(255, 255, 255));
		lblAdminsDashboard.setBackground(new Color(255, 255, 255));
		lblAdminsDashboard.setBounds(12, 20, 407, 90);
		contentPane.add(lblAdminsDashboard);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 1108, 122);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 123, 1108, 545);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenus = new JLabel("  Menu's");
		lblMenus.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/menu.png")));
		lblMenus.setForeground(new Color(0, 0, 0));
		lblMenus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenus.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblMenus.setBounds(12, 31, 186, 48);
		panel.add(lblMenus);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddAdminDashboard a = new AddAdminDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAdd.setBackground(Color.pink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAdd.setBackground(new Color(255,255,204));
			}
		});
		lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdd.setForeground(new Color(51, 51, 102));
		lblAdd.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdd.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/add (3).png")));
		lblAdd.setBackground(new Color(255, 255, 204));
		lblAdd.setOpaque(true);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(256, 13, 134, 132);
		panel.add(lblAdd);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteAdminDashboard a = new DeleteAdminDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDelete.setBackground(Color.PINK);
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblDelete.setBackground(new Color(255,255,204));
				
			}
		});
		lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDelete.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/remove (1).png")));
		lblDelete.setForeground(new Color(51, 51, 102));
		lblDelete.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblDelete.setBackground(new Color(255, 255, 204));
		lblDelete.setOpaque(true);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setBounds(500, 13, 134, 132);
		panel.add(lblDelete);
		
		JLabel lblLiveRecords = new JLabel("Live Records");
		lblLiveRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LiveRecordsAdminDashboard d = new LiveRecordsAdminDashboard();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLiveRecords.setBackground(Color.pink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLiveRecords.setBackground(new Color(255,255,204));
			}
		});
		lblLiveRecords.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLiveRecords.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/live.png")));
		lblLiveRecords.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLiveRecords.setForeground(new Color(51, 51, 102));
		lblLiveRecords.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblLiveRecords.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLiveRecords.setBackground(new Color(255, 255, 204));
		lblLiveRecords.setOpaque(true);
		lblLiveRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveRecords.setBounds(743, 13, 134, 132);
		panel.add(lblLiveRecords);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeletedRecordsAdminDashboard d = new DeletedRecordsAdminDashboard();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHistory.setBackground(Color.PINK);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHistory.setBackground(new Color(255,255,204));
			}
		});
		lblHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHistory.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/history-clock-button.png")));
		lblHistory.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHistory.setForeground(new Color(51, 51, 102));
		lblHistory.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblHistory.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblHistory.setBackground(new Color(255, 255, 204));
		lblHistory.setOpaque(true);
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setBounds(476, 158, 192, 132);
		panel.add(lblHistory);
		
		JLabel lblMessenger = new JLabel("Messenger");
		lblMessenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessengerAdmin a = new MessengerAdmin();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblMessenger.setBackground(Color.pink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMessenger.setBackground(new Color(255,255,204));
			
			}
		});
		lblMessenger.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMessenger.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/telegram-logo.png")));
		lblMessenger.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMessenger.setForeground(new Color(51, 51, 102));
		lblMessenger.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblMessenger.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMessenger.setBackground(new Color(255, 255, 204));
		lblMessenger.setOpaque(true);
		lblMessenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessenger.setBounds(253, 305, 134, 132);
		panel.add(lblMessenger);
		
		JLabel lblSendEmail = new JLabel("Send Email");
		lblSendEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SendMailAdminDashboard s = new SendMailAdminDashboard();
				s.setVisible(true);
				s.setLocationRelativeTo(null);
				dispose();
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSendEmail.setBackground(Color.pink);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			
			lblSendEmail.setBackground(new Color(255,255,204));
			
			}
		});
		lblSendEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSendEmail.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/opened-email-envelope.png")));
		lblSendEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSendEmail.setForeground(new Color(51, 51, 102));
		lblSendEmail.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblSendEmail.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSendEmail.setBackground(new Color(255, 255, 204));
		lblSendEmail.setOpaque(true);
		lblSendEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendEmail.setBounds(497, 305, 134, 132);
		panel.add(lblSendEmail);
		
		JLabel lblRevenueCollection = new JLabel("Revenue");
		lblRevenueCollection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ShowRevenueGenerated srg =new ShowRevenueGenerated();
				srg.setVisible(true);
				dispose();
				srg.setLocationRelativeTo(null);
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRevenueCollection.setBackground(Color.pink);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			
				lblRevenueCollection.setBackground(new Color(255, 255, 204));
			}
		});
		lblRevenueCollection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRevenueCollection.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/money-bag.png")));
		lblRevenueCollection.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRevenueCollection.setForeground(new Color(51, 51, 102));
		lblRevenueCollection.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblRevenueCollection.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRevenueCollection.setBackground(new Color(255, 255, 204));
		lblRevenueCollection.setOpaque(true);
		lblRevenueCollection.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevenueCollection.setBounds(740, 305, 134, 132);
		panel.add(lblRevenueCollection);
		
		JLabel label_2 = new JLabel("CopyRight ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		label_2.setBounds(495, 484, 136, 28);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("All rights are reserved.");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		label_3.setBounds(495, 512, 169, 33);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("  2018");
		label_4.setIcon(new ImageIcon(AdminPanelDashboard.class.getResource("/img_Driver/copyright (2).png")));
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		label_4.setBounds(574, 484, 75, 28);
		panel.add(label_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(51, 0, 102));
		label_1.setBounds(0, 484, 1108, 61);
		panel.add(label_1);
	}
}
