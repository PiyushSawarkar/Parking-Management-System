

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setUndecorated(true);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.exit(0);
				dispose();
				Driver d = new Driver();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(Color.white);
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setIcon(new ImageIcon(LoginScreen.class.getResource("/img_Driver/error.png")));
		lblNewLabel.setBounds(764, 1, 68, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setOpaque(true);
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals("Admin")&&passwordField.getText().equals("Pass255#")) {
					dispose();
					Success s = new Success();
					s.setVisible(true);
					s.setLocationRelativeTo(null);
					
				}
				else {
					dispose();
					Err er = new Err();
					er.setVisible(true);
					er.setLocationRelativeTo(null);
					
				}
			}
		});
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.DARK_GRAY);
		lblLogin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblLogin.setBounds(659, 576, 173, 61);
		contentPane.add(lblLogin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 33));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(438, 184, 188, 41);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 31));
		textField.setBounds(438, 261, 354, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 39));
		passwordField.setEchoChar('*');
		passwordField.setBounds(438, 378, 354, 41);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(-2, 1, 405, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(88, 44, 222, 143);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(LoginScreen.class.getResource("/img_Driver/admin-with-cogwheels (2).png")));
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 33));
		lblAdmin.setBounds(98, 212, 191, 41);
		panel.add(lblAdmin);
		
		JLabel label_1 = new JLabel("CopyRight ");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 19));
		label_1.setBounds(103, 535, 136, 28);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("All rights are reserved.");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		label_2.setBounds(101, 576, 201, 33);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("  2018");
		label_3.setIcon(new ImageIcon(LoginScreen.class.getResource("/img_Driver/copyright (3).png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		label_3.setBounds(195, 529, 115, 41);
		panel.add(label_3);
		
		JLabel lblEnterCredentials = new JLabel("Enter Credentials ");
		lblEnterCredentials.setBackground(new Color(255, 255, 255));
		lblEnterCredentials.setForeground(Color.DARK_GRAY);
		lblEnterCredentials.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 34));
		lblEnterCredentials.setOpaque(true);
		lblEnterCredentials.setBounds(436, 68, 326, 74);
		contentPane.add(lblEnterCredentials);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setBounds(438, 220, 139, 41);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblPassword.setBounds(438, 337, 139, 41);
		contentPane.add(lblPassword);
	}
}
