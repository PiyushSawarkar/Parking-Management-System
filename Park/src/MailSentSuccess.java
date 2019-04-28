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

public class MailSentSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailSentSuccess frame = new MailSentSuccess();
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
	public MailSentSuccess() {
		setBackground(new Color(0, 0, 0));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMailSent = new JLabel("Mail Sent   :)");
		lblMailSent.setForeground(new Color(255, 255, 255));
		lblMailSent.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 73));
		lblMailSent.setHorizontalAlignment(SwingConstants.LEFT);
		lblMailSent.setBounds(73, 42, 433, 155);
		contentPane.add(lblMailSent);
		
		JLabel lblReturnToDashboard = new JLabel("Return to dashboard");
		lblReturnToDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanelDashboard a = new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblReturnToDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnToDashboard.setForeground(Color.WHITE);
		lblReturnToDashboard.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		lblReturnToDashboard.setBounds(359, 343, 409, 60);
		contentPane.add(lblReturnToDashboard);
		
		JLabel lblReturnToMessenger = new JLabel("Return to Messenger");
		lblReturnToMessenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SendMailAdminDashboard s = new SendMailAdminDashboard();
				s.setVisible(true);
				s.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblReturnToMessenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnToMessenger.setForeground(Color.WHITE);
		lblReturnToMessenger.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		lblReturnToMessenger.setBounds(359, 416, 409, 60);
		contentPane.add(lblReturnToMessenger);
		
		JLabel lblChoose = new JLabel("Choose . . . ");
		lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoose.setForeground(Color.WHITE);
		lblChoose.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		lblChoose.setBounds(12, 264, 409, 60);
		contentPane.add(lblChoose);
	}

}
