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

public class Err extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Err frame = new Err();
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
	public Err() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 539);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 67));
		lblLogin.setBackground(Color.BLACK);
		lblLogin.setOpaque(true);
		lblLogin.setBounds(12, 13, 416, 129);
		contentPane.add(lblLogin);
		
		JLabel lblFailed = new JLabel("Failed  :(");
		lblFailed.setOpaque(true);
		lblFailed.setForeground(Color.WHITE);
		lblFailed.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 67));
		lblFailed.setBackground(Color.BLACK);
		lblFailed.setBounds(12, 199, 416, 129);
		contentPane.add(lblFailed);
		
		JLabel lblTryAgain = new JLabel("Try Again . . .");
		lblTryAgain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTryAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTryAgain.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTryAgain.setBackground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginScreen ls = new LoginScreen();
				ls.setVisible(true);
				ls.setLocationRelativeTo(null);
			}
		});
		lblTryAgain.setBackground(Color.BLACK);
		lblTryAgain.setForeground(Color.WHITE);
		lblTryAgain.setOpaque(true);
		lblTryAgain.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblTryAgain.setBounds(527, 457, 213, 82);
		contentPane.add(lblTryAgain);
	}

}
