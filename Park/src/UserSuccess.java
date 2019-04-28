
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class UserSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSuccess frame = new UserSuccess();
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
	public UserSuccess() {
		setBackground(Color.BLACK);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 454);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 70));
		lblLogin.setBackground(Color.BLACK);
		lblLogin.setOpaque(true);
		lblLogin.setBounds(26, 58, 428, 140);
		contentPane.add(lblLogin);
		
		JLabel lblPressToContinue = new JLabel("Press to Continue . . . ");
		lblPressToContinue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPressToContinue.setBackground(Color.BLACK);
		lblPressToContinue.setOpaque(true);
		lblPressToContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPressToContinue.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPressToContinue.setBackground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UserPanelDashboard adp = new UserPanelDashboard();
				adp.setVisible(true);
				adp.setLocationRelativeTo(null);
			}
		});
		lblPressToContinue.setForeground(Color.WHITE);
		lblPressToContinue.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblPressToContinue.setBounds(372, 390, 324, 64);
		contentPane.add(lblPressToContinue);
		
		JLabel lblSuccess = new JLabel("Success   :)");
		lblSuccess.setOpaque(true);
		lblSuccess.setForeground(Color.WHITE);
		lblSuccess.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 70));
		lblSuccess.setBackground(Color.BLACK);
		lblSuccess.setBounds(26, 223, 428, 140);
		contentPane.add(lblSuccess);
	}

}
