import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BeforeDriver extends JFrame {

	private JPanel contentPane;
	public JLabel lblSystem;
	public JLabel lblManagement;
	public JLabel lblParking;
	public JLabel lblTheConceptOf;
	public JLabel lblIntroducing;
	public JLabel label_1;//car
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeforeDriver frame = new BeforeDriver();
					frame.setVisible(true);
					
					
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public BeforeDriver() throws InterruptedException {
		
		setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 629);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(BeforeDriver.class.getResource("/img_Driver/car (2).png")));
		label_1.setBounds(481, 285, 379, 300);
		contentPane.add(label_1);
		
		lblIntroducing = new JLabel("Introducing  ,  ");
		lblIntroducing.setForeground(new Color(255, 255, 0));
		lblIntroducing.setFont(new Font("Monospaced", Font.PLAIN, 55));
		lblIntroducing.setBounds(12, 13, 483, 66);
		contentPane.add(lblIntroducing);
		
		lblTheConceptOf = new JLabel("The Concept Of an Ideal . . . ");
		lblTheConceptOf.setForeground(Color.YELLOW);
		lblTheConceptOf.setFont(new Font("Monospaced", Font.ITALIC, 42));
		lblTheConceptOf.setBounds(90, 94, 770, 66);
		contentPane.add(lblTheConceptOf);
		
		lblParking = new JLabel("Parking");
		lblParking.setForeground(new Color(255, 255, 255));
		lblParking.setFont(new Font("Monospaced", Font.PLAIN, 39));
		lblParking.setBounds(28, 196, 385, 52);
		contentPane.add(lblParking);
		
		lblManagement = new JLabel("Management");
		lblManagement.setForeground(new Color(255, 255, 255));
		lblManagement.setFont(new Font("Monospaced", Font.PLAIN, 39));
		lblManagement.setBounds(28, 257, 385, 52);
		contentPane.add(lblManagement);
		
		lblSystem = new JLabel("System");
		lblSystem.setForeground(new Color(255, 255, 255));
		lblSystem.setFont(new Font("Monospaced", Font.PLAIN, 39));
		lblSystem.setBounds(28, 316, 385, 52);
		contentPane.add(lblSystem);
		
		
		lblSystem.setVisible(false);
		label_1.setVisible(false);
		lblIntroducing.setVisible(false);
		lblManagement.setVisible(false);
		lblTheConceptOf.setVisible(false);
		lblParking.setVisible(false);
		
	}

}
