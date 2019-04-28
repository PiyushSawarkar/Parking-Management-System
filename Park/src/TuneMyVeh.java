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

public class TuneMyVeh extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TuneMyVeh frame = new TuneMyVeh();
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
	private JTextField vn;
	public TuneMyVeh() throws SQLException {
		
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
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserPanelDashboard p = new UserPanelDashboard();
				p.setVisible(true);
				p.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_2.setIcon(new ImageIcon(TuneMyVeh.class.getResource("/img_Driver/back-arrow.png")));
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label_2.setBounds(632, 0, 106, 53);
		contentPane.add(label_2);
		
		JLabel lblTuneMyVehicle = new JLabel("Tune My Vehicle . . .");
		lblTuneMyVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuneMyVehicle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTuneMyVehicle.setForeground(new Color(255, 255, 255));
		lblTuneMyVehicle.setBackground(new Color(51, 0, 102));
		lblTuneMyVehicle.setOpaque(true);
		lblTuneMyVehicle.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 34));
		lblTuneMyVehicle.setBounds(0, 0, 738, 134);
		contentPane.add(lblTuneMyVehicle);
		
		JLabel lblCheckAirPressure = new JLabel("Check Air Pressure");
		lblCheckAirPressure.setIcon(new ImageIcon(TuneMyVeh.class.getResource("/img_Driver/wheel.png")));
		lblCheckAirPressure.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblCheckAirPressure.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCheckAirPressure.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAirPressure.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCheckAirPressure.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblCheckAirPressure.setBounds(74, 183, 229, 207);
		contentPane.add(lblCheckAirPressure);
		
		JLabel lblCheckOilLevels = new JLabel("Check Oil Levels");
		lblCheckOilLevels.setIcon(new ImageIcon(TuneMyVeh.class.getResource("/img_Driver/gasoline.png")));
		lblCheckOilLevels.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblCheckOilLevels.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCheckOilLevels.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCheckOilLevels.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOilLevels.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblCheckOilLevels.setBounds(432, 183, 229, 207);
		contentPane.add(lblCheckOilLevels);
		
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
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setOpaque(true);
		lblVehicleNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleNumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 28));
		lblVehicleNumber.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblVehicleNumber.setBackground(new Color(255, 255, 204));
		lblVehicleNumber.setBounds(74, 432, 238, 44);
		contentPane.add(lblVehicleNumber);
		
		vn = new JTextField();
		vn.setBounds(356, 433, 334, 40);
		contentPane.add(vn);
		vn.setColumns(10);
		
		JLabel lblBookBothFor = new JLabel("Book both for Me . . . ");
		lblBookBothFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			/*String compl = "complementary";
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(new java.util.Date());
			LocalTime t = LocalTime.now();
			String time = t.toString();
				String q= "insert into park.tune (vehiclenumber,bill,date,time) "
						+ "values('"+vn.getText()+"','"+compl+"' , '"+date+"' , '"+time+"')";
				Statement stm;
				try {
					stm = (Statement) con.createStatement();
					stm.executeUpdate(q);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"Data inserted Successfully");*/
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				String date = sdf.format(new java.util.Date());
				String vehiclenumber=vn.getText();
				/*try {
					Statement s = con.createStatement();
					String q= "insert into park.tunedb (VehicleNumber,Date) "
							+ "values('"+vehiclenumber+"','"+date+"')";
					s.executeUpdate(q);
					JOptionPane.showMessageDialog(null,"Record added successfully");
					JOptionPane.showMessageDialog(null, "Your Service is initiated and would be done within next 50 minutes.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			*/
				String query = "select * from park.tunedb where vehicleNumber = '"+vehiclenumber+"' and date='"+date+"'";
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
								String q= "insert into park.tunedb (VehicleNumber,Date) "
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
							String q= "insert into park.tunedb (VehicleNumber,Date) "
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
		lblBookBothFor.setOpaque(true);
		lblBookBothFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookBothFor.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 28));
		lblBookBothFor.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBookBothFor.setBackground(new Color(255, 255, 204));
		lblBookBothFor.setBounds(158, 489, 442, 44);
		contentPane.add(lblBookBothFor);
	}

}
