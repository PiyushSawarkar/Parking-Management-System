import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;

public class DeleteAdminDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAdminDashboard frame = new DeleteAdminDashboard();
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
	public DeleteAdminDashboard() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 721);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanelDashboard a = new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(DeleteAdminDashboard.class.getResource("/img_Driver/back-arrow.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label.setBounds(957, 0, 106, 53);
		contentPane.add(label);
		
		JLabel lblDeleteARecord = new JLabel("Delete a Record");
		lblDeleteARecord.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 34));
		lblDeleteARecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteARecord.setBounds(275, 45, 490, 49);
		contentPane.add(lblDeleteARecord);
		
		JLabel lblOfflinePayment = new JLabel("Offline Payment");
		lblOfflinePayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfflinePayment op;
				try {
					op = new OfflinePayment();
					op.setVisible(true);
					op.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblOfflinePayment.setIcon(new ImageIcon(DeleteAdminDashboard.class.getResource("/img_Driver/notes.png")));
		lblOfflinePayment.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblOfflinePayment.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblOfflinePayment.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOfflinePayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfflinePayment.setBounds(403, 245, 277, 279);
		contentPane.add(lblOfflinePayment);
	}

}
