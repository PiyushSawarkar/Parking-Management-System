
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CleanMyVeh extends JFrame {

	private JPanel contentPane;
	private JTextField vn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CleanMyVeh frame = new CleanMyVeh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */Connection con = null;
	public CleanMyVeh() throws SQLException {
		try {
			java.lang.Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserPanelDashboard p =new UserPanelDashboard();
				p.setVisible(true);
				p.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_1.setIcon(new ImageIcon(CleanMyVeh.class.getResource("/img_Driver/back-arrow.png")));
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label_1.setBounds(632, 0, 106, 53);
		contentPane.add(label_1);
		
		JLabel lblTuneMyVehicle = new JLabel("Clean My Vehicle . . .");
		lblTuneMyVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuneMyVehicle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTuneMyVehicle.setForeground(new Color(255, 255, 255));
		lblTuneMyVehicle.setBackground(new Color(51, 0, 102));
		lblTuneMyVehicle.setOpaque(true);
		lblTuneMyVehicle.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 34));
		lblTuneMyVehicle.setBounds(0, 0, 738, 134);
		contentPane.add(lblTuneMyVehicle);
		
		JLabel lblOurToolkit = new JLabel("Our ToolKit ");
		lblOurToolkit.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblOurToolkit.setBounds(10, 147, 178, 44);
		contentPane.add(lblOurToolkit);
		
		JLabel lblCheckAirPressure = new JLabel("Clean My Vehicle");
		lblCheckAirPressure.setIcon(new ImageIcon(CleanMyVeh.class.getResource("/img_Driver/car-wash (1).png")));
		lblCheckAirPressure.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblCheckAirPressure.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCheckAirPressure.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAirPressure.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCheckAirPressure.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblCheckAirPressure.setBounds(30, 292, 229, 207);
		contentPane.add(lblCheckAirPressure);
		
		JLabel lblNoteThese = new JLabel("* Note these are third party Suppliers , the management is not responsible for any misconvienience");
		lblNoteThese.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNoteThese.setForeground(new Color(255, 255, 204));
		lblNoteThese.setBackground(new Color(51, 0, 102));
		lblNoteThese.setBounds(12, 561, 588, 41);
		contentPane.add(lblNoteThese);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(51, 0, 102));
		label.setOpaque(true);
		label.setBounds(0, 550, 738, 65);
		contentPane.add(label);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle number");
		lblVehicleNumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblVehicleNumber.setBounds(43, 204, 229, 44);
		contentPane.add(lblVehicleNumber);
		
		vn = new JTextField();
		vn.setBounds(318, 204, 367, 44);
		contentPane.add(vn);
		vn.setColumns(10);
		
		JLabel btn = new JLabel("Book One For Me  . . . ");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				String date = sdf.format(new java.util.Date());
				String vehiclenumber=vn.getText();
				String query = "select * from park.clean where vehicleNumber = '"+vehiclenumber+"'";
				try {
					Statement st23 = (Statement) con.createStatement();
					ResultSet r =st23.executeQuery(query);
					while(r.next()) {
						String vehnum =r.getString(1);
						String dt = r.getString(2);
						if(dt.equals(date)) {
							JOptionPane.showMessageDialog(null, "Complementary Subscription is Only Once In A Day allowed ");
						}
						else {
							try {
								Statement s = con.createStatement();
								String q= "insert into park.clean (VehicleNumber,Date) "
										+ "values('"+vehiclenumber+"','"+date+"')";
								s.executeUpdate(q);
								JOptionPane.showMessageDialog(null,"Record added successfully");
								JOptionPane.showMessageDialog(null, "The Cleaning Service is initiated for You And would be done within next 45-50 Minutes.");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						}
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				String date = sdf.format(new java.util.Date());
				String vehiclenumber=vn.getText();
				String query = "select * from park.clean where vehicleNumber = '"+vehiclenumber+"' and date='"+date+"'";
				try {
					Statement st23 = (Statement) con.createStatement();
					ResultSet r =st23.executeQuery(query);
					if( r.isBeforeFirst()) {
					while(r.next()) {
						String vehnum =r.getString(1);
						String dt = r.getString(2);
						JOptionPane.showMessageDialog(null, vehnum+"  "+dt);
						SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
						String date1 = sdf.format(new java.util.Date());
						if(dt.equals(date1)) {
							JOptionPane.showMessageDialog(null, "Complementary Subscription is Only Once In A Day allowed ");
						}
						else {
							try {
								Statement s = con.createStatement();
								String q= "insert into park.clean (VehicleNumber,Date) "
										+ "values('"+vehiclenumber+"','"+date+"')";
								s.executeUpdate(q);
								JOptionPane.showMessageDialog(null,"Record added successfully");
								JOptionPane.showMessageDialog(null, "Your Service is initiated and would be done within next 50 minutes.");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						}
					}
					}
					else {
						try {
							Statement s = con.createStatement();
							String q= "insert into park.clean (VehicleNumber,Date) "
									+ "values('"+vehiclenumber+"','"+date+"')";
							s.executeUpdate(q);
							JOptionPane.showMessageDialog(null,"Record added successfully");
							JOptionPane.showMessageDialog(null, "Your Service is initiated and would be done within next 50 minutes.");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn.setBackground(new Color(255, 255, 204));
		btn.setOpaque(true);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		btn.setBounds(415, 377, 270, 82);
		contentPane.add(btn);
	}
}
