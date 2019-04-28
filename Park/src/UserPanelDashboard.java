
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class UserPanelDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanelDashboard frame = new UserPanelDashboard();
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
	public UserPanelDashboard() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 668);
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
		logout.setIcon(new ImageIcon(UserPanelDashboard.class.getResource("/img_Driver/logout (8).png")));
		logout.setBounds(715, 0, 79, 64);
		contentPane.add(logout);
		
		JLabel lblLogout = new JLabel("logout");
		lblLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogout.setBackground(new Color(51, 0, 102));
		lblLogout.setOpaque(true);
		lblLogout.setForeground(new Color(255, 255, 255));
		lblLogout.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblLogout.setBounds(597, 13, 100, 30);
		contentPane.add(lblLogout);
		
		JLabel lblAdminsDashboard = new JLabel("  User's Dashboard");
		lblAdminsDashboard.setIcon(new ImageIcon(UserPanelDashboard.class.getResource("/img_Driver/user (6).png")));
		lblAdminsDashboard.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 33));
		lblAdminsDashboard.setForeground(new Color(255, 255, 255));
		lblAdminsDashboard.setBackground(new Color(255, 255, 255));
		lblAdminsDashboard.setBounds(12, 13, 407, 90);
		contentPane.add(lblAdminsDashboard);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 795, 122);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 123, 794, 545);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenus = new JLabel("  Menu's");
		lblMenus.setIcon(new ImageIcon(UserPanelDashboard.class.getResource("/img_Driver/menu.png")));
		lblMenus.setForeground(new Color(0, 0, 0));
		lblMenus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenus.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblMenus.setBounds(12, 31, 186, 48);
		panel.add(lblMenus);
		
		JLabel kno = new JLabel("Know more !!!");
		kno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			KnowMore d = new KnowMore();
			d.setVisible(true);
			d.setLocationRelativeTo(null);
			dispose();
			
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			kno.setBackground(Color.pink);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				kno.setBackground(new Color(255,255,204));
			}
		});
		kno.setBorder(null);
		kno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		kno.setIcon(new ImageIcon(UserPanelDashboard.class.getResource("/img_Driver/icon (1).png")));
		kno.setHorizontalTextPosition(SwingConstants.CENTER);
		kno.setForeground(new Color(51, 51, 102));
		kno.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		kno.setVerticalTextPosition(SwingConstants.BOTTOM);
		kno.setBackground(new Color(255, 255, 204));
		kno.setOpaque(true);
		kno.setHorizontalAlignment(SwingConstants.CENTER);
		kno.setBounds(533, 159, 179, 132);
		panel.add(kno);
		
		JLabel lblMessenger = new JLabel("Messenger");
		lblMessenger.setBorder(null);
		lblMessenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessengerUser a = new MessengerUser();
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
		lblMessenger.setIcon(new ImageIcon(UserPanelDashboard.class.getResource("/img_Driver/telegram-logo.png")));
		lblMessenger.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMessenger.setForeground(new Color(51, 51, 102));
		lblMessenger.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblMessenger.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMessenger.setBackground(new Color(255, 255, 204));
		lblMessenger.setOpaque(true);
		lblMessenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessenger.setBounds(256, 159, 179, 132);
		panel.add(lblMessenger);
		
		JLabel label_2 = new JLabel("CopyRight ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		label_2.setBounds(312, 484, 136, 28);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("All rights are reserved.");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		label_3.setBounds(312, 512, 169, 33);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("  2018");
		label_4.setIcon(new ImageIcon(UserPanelDashboard.class.getResource("/img_Driver/copyright (2).png")));
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		label_4.setBounds(391, 484, 75, 28);
		panel.add(label_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(51, 0, 102));
		label_1.setBounds(0, 484, 1290, 61);
		panel.add(label_1);
	}
}
