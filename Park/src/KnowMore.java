import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class KnowMore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnowMore frame = new KnowMore();
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
	public KnowMore() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 571);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 44));
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel back = new JLabel("");
		back.setBackground(new Color(255, 255, 255));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserPanelDashboard p =new UserPanelDashboard();
				p.setVisible(true);
				p.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			back.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			back.setBackground(new Color(255,255,255));
			}
		});
		back.setIcon(new ImageIcon(KnowMore.class.getResource("/img_Driver/back-arrow.png")));
		back.setOpaque(true);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		back.setBounds(766, 0, 102, 82);
		contentPane.add(back);
		
		JLabel lblKnowMore = new JLabel("Know More ! ! !");
		lblKnowMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblKnowMore.setOpaque(true);
		lblKnowMore.setBackground(new Color(51, 0, 102));
		lblKnowMore.setForeground(new Color(255, 255, 255));
		lblKnowMore.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 45));
		lblKnowMore.setBounds(0, 0, 767, 82);
		contentPane.add(lblKnowMore);
		
		JLabel lblCleanMyVehicle = new JLabel("Clean My Vehicle");
		lblCleanMyVehicle.setBackground(new Color(255, 255, 204));
		lblCleanMyVehicle.setOpaque(true);
		lblCleanMyVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CleanMyVeh c;
				try {
					c = new CleanMyVeh();
					c.setVisible(true);
					c.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCleanMyVehicle.setBackground(Color.pink);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCleanMyVehicle.setBackground(new Color(255,255,204));
			
			}
		});
		lblCleanMyVehicle.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		lblCleanMyVehicle.setIcon(new ImageIcon(KnowMore.class.getResource("/img_Driver/washing-machine.png")));
		lblCleanMyVehicle.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCleanMyVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCleanMyVehicle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCleanMyVehicle.setBounds(175, 222, 245, 196);
		contentPane.add(lblCleanMyVehicle);
		
		JLabel label_1 = new JLabel("CopyRight ");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		label_1.setBounds(357, 497, 136, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("  2018");
		label_2.setIcon(new ImageIcon(KnowMore.class.getResource("/img_Driver/copyright (2).png")));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		label_2.setBounds(436, 497, 75, 28);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("All rights are reserved.");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		label_3.setBounds(357, 525, 169, 33);
		contentPane.add(label_3);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(51, 0, 102));
		label.setOpaque(true);
		label.setBounds(0, 489, 868, 82);
		contentPane.add(label);
		
		JLabel lblTuneMyVehicle = new JLabel("Tune My Vehicle");
		lblTuneMyVehicle.setBackground(new Color(255, 255, 204));
		lblTuneMyVehicle.setOpaque(true);
		lblTuneMyVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TuneMyVeh c;
				try {
					c = new TuneMyVeh();
					c.setVisible(true);
					c.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTuneMyVehicle.setBackground(Color.pink);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTuneMyVehicle.setBackground(new Color(255,255,204));
			}
		});
		lblTuneMyVehicle.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		lblTuneMyVehicle.setIcon(new ImageIcon(KnowMore.class.getResource("/img_Driver/gear.png")));
		lblTuneMyVehicle.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblTuneMyVehicle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTuneMyVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuneMyVehicle.setBounds(456, 222, 245, 196);
		contentPane.add(lblTuneMyVehicle);
		
		JLabel lblPleaseClickTo = new JLabel("Please click on the icons below to get the services for your vehcile ");
		lblPleaseClickTo.setForeground(Color.GRAY);
		lblPleaseClickTo.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		lblPleaseClickTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseClickTo.setBounds(10, 122, 846, 47);
		contentPane.add(lblPleaseClickTo);
	}

}
