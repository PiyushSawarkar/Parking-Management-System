import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class LoadingScreen extends JFrame {

	private JPanel contentPane;
	public 	JLabel lblTextBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingScreen frame = new LoadingScreen();
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
	public LoadingScreen() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTextBox = new JLabel("");
		lblTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextBox.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 63));
		lblTextBox.setForeground(new Color(255, 255, 255));
		lblTextBox.setBackground(new Color(0, 0, 0));
		lblTextBox.setOpaque(true);
		lblTextBox.setBounds(0, 0, 939, 563);
		contentPane.add(lblTextBox);
	}

}
