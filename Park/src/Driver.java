import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Driver extends JFrame {
	int mousepX;
    int mousepY;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver frame = new Driver();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Driver() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 599);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClose = new JLabel("close");
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setBackground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setBackground(new Color(255,102,0));
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousepX = e.getX();
		        mousepY = e.getY();
			}
		});
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				int coordinateX = evt.getXOnScreen();
		        int coordinateY = evt.getYOnScreen();
		        setLocation(coordinateX-mousepX,coordinateY-mousepY);
			}
		});
		
		JLabel lblImgComseHere = new JLabel("");
		lblImgComseHere.setIcon(new ImageIcon(Driver.class.getResource("/img_Driver/placeholder (1).png")));
		lblImgComseHere.setBounds(62, 98, 143, 148);
		contentPane.add(lblImgComseHere);
		
		JLabel lblWelcome = new JLabel("Hello & Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		lblWelcome.setBounds(25, 278, 215, 68);
		contentPane.add(lblWelcome);
		
		JLabel lblCop = new JLabel("  2018");
		lblCop.setForeground(new Color(255, 255, 255));
		lblCop.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		lblCop.setIcon(new ImageIcon(Driver.class.getResource("/img_Driver/copyright (2).png")));
		lblCop.setBounds(128, 525, 75, 28);
		contentPane.add(lblCop);
		
		JLabel lblAllRightsAre = new JLabel("All rights are reserved.");
		lblAllRightsAre.setForeground(new Color(255, 255, 255));
		lblAllRightsAre.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblAllRightsAre.setBounds(49, 553, 169, 33);
		contentPane.add(lblAllRightsAre);
		
		JLabel lblCopyright = new JLabel("CopyRight ");
		lblCopyright.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblCopyright.setForeground(new Color(255, 255, 255));
		lblCopyright.setBounds(49, 525, 136, 28);
		contentPane.add(lblCopyright);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(51, 0, 102));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(0, 0, 48, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(new Color(204, 204, 255));
		label.setBounds(49, 0, 48, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(204, 204, 255));
		label_1.setBounds(0, 48, 48, 48);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 259, 599);
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(0, 0, 793, 16);
		contentPane.add(lblNewLabel_1);
		lblClose.setBackground(new Color(255, 102, 0));
		lblClose.setOpaque(true);
		lblClose.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 17));
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setBounds(794, 1, 54, 36);
		contentPane.add(lblClose);
		
		JLabel lblTheParkingManagement = new JLabel("The Parking Management System");
		lblTheParkingManagement.setBackground(Color.WHITE);
		lblTheParkingManagement.setOpaque(true);
		lblTheParkingManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheParkingManagement.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		lblTheParkingManagement.setBounds(259, 1, 536, 75);
		contentPane.add(lblTheParkingManagement);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setIcon(new ImageIcon(Driver.class.getResource("/img_Driver/policeman.png")));
		lblAdminPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdminPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAdminPanel.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAdminPanel.setBackground(Color.PINK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginScreen ls = new LoginScreen();
				ls.setVisible(true);
				ls.setLocationRelativeTo(null);
			}
		});
		lblAdminPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblAdminPanel.setForeground(Color.DARK_GRAY);
		lblAdminPanel.setBackground(Color.PINK);
		lblAdminPanel.setOpaque(true);
		lblAdminPanel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setBounds(298, 150, 225, 166);
		contentPane.add(lblAdminPanel);
		
		JLabel lblUserPanel = new JLabel("User Panel");
		lblUserPanel.setIcon(new ImageIcon(Driver.class.getResource("/img_Driver/user (4).png")));
		lblUserPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUserPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUserPanel.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblUserPanel.setBackground(Color.PINK);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserLoginScreen uls;
				try {
					uls = new UserLoginScreen();
					uls.setVisible(true);
					uls.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		lblUserPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblUserPanel.setOpaque(true);
		lblUserPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPanel.setForeground(Color.DARK_GRAY);
		lblUserPanel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblUserPanel.setBackground(Color.PINK);
		lblUserPanel.setBounds(575, 150, 218, 166);
		contentPane.add(lblUserPanel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Driver.class.getResource("/img_Driver/parking.png")));
		lblNewLabel_4.setBounds(473, 365, 143, 176);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(795, 37, 52, 39);
		contentPane.add(label_2);
		
		JLabel lblExit = new JLabel("exit");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setBackground(new Color(220,220,220));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setOpaque(true);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 27));
		lblExit.setBackground(Color.LIGHT_GRAY);
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setBounds(754, 537, 94, 61);
		contentPane.add(lblExit);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(Driver.class.getResource("/img_Driver/placeholder (1).png")));
		label_3.setBounds(62, 98, 143, 148);
		contentPane.add(label_3);
	}
}
