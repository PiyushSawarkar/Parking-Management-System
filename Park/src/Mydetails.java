import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mydetails extends JFrame {

	private JPanel contentPane;
	private JTextField n;
	private JTextField v;
	private JTextField s;
	public String nme ,vehn,sl;
	
	/**
	 * Launch the application.
	 */
	public void getBean(UserBean db) {
		nme=(db.getFirstName());
		vehn = (db.getVehicleNumberV());
		sl = (Integer.toString(db.getSlot()));
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mydetails frame = new Mydetails();
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
	public Mydetails() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 683);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyDetails = new JLabel("My details ");
		lblMyDetails.setForeground(new Color(255, 255, 255));
		lblMyDetails.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 40));
		lblMyDetails.setBounds(12, 23, 303, 74);
		contentPane.add(lblMyDetails);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(51, 0, 102));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 1031, 116);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(51, 0, 102));
		label.setOpaque(true);
		label.setBounds(0, 609, 1031, 74);
		contentPane.add(label);
		
		JLabel lblLoad = new JLabel("Load");
		lblLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				n.setText(nme);
				v.setText(vehn);
				s.setText(sl);
			}
		});
		lblLoad.setBackground(new Color(255, 255, 204));
		lblLoad.setOpaque(true);
		lblLoad.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 31));
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoad.setBounds(10, 129, 117, 74);
		contentPane.add(lblLoad);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		lblName.setBackground(new Color(255, 255, 204));
		lblName.setBounds(269, 207, 208, 36);
		contentPane.add(lblName);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle number");
		lblVehicleNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleNumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		lblVehicleNumber.setBackground(new Color(255, 255, 204));
		lblVehicleNumber.setBounds(269, 268, 208, 36);
		contentPane.add(lblVehicleNumber);
		
		JLabel lblSlot = new JLabel("Slot");
		lblSlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlot.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		lblSlot.setBackground(new Color(255, 255, 204));
		lblSlot.setBounds(269, 337, 208, 36);
		contentPane.add(lblSlot);
		
		n = new JTextField();
		n.setBounds(567, 218, 350, 25);
		contentPane.add(n);
		n.setColumns(10);
		
		v = new JTextField();
		v.setColumns(10);
		v.setBounds(567, 278, 350, 25);
		contentPane.add(v);
		
		s = new JTextField();
		s.setColumns(10);
		s.setBounds(567, 348, 350, 25);
		contentPane.add(s);
	}
}
