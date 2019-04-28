import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class OfflinePayment extends JFrame {

	private JPanel contentPane;
	private JTextField tfvehiclenumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfflinePayment frame = new OfflinePayment();
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
	Connection con = null;
	public OfflinePayment() throws SQLException {
		try {
			java.lang.Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOfflinePayment = new JLabel("Offline Payment");
		lblOfflinePayment.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 34));
		lblOfflinePayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfflinePayment.setBounds(376, 39, 374, 73);
		contentPane.add(lblOfflinePayment);
		
		tfvehiclenumber = new JTextField();
		tfvehiclenumber.setBackground(new Color(255, 255, 204));
		tfvehiclenumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		tfvehiclenumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfvehiclenumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		tfvehiclenumber.setBounds(435, 210, 555, 41);
		contentPane.add(tfvehiclenumber);
		tfvehiclenumber.setColumns(10);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleNumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		lblVehicleNumber.setBounds(38, 193, 374, 73);
		contentPane.add(lblVehicleNumber);
		
		JLabel lblProceedToPayment = new JLabel("Proceed to Payment");
		lblProceedToPayment.setBackground(new Color(255, 255, 204));
		lblProceedToPayment.setOpaque(true);
		lblProceedToPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String VehicleNumber = tfvehiclenumber.getText();
				///////////regarding clean my veh and tune 
				
								Long ExitTimeMS=System.currentTimeMillis();
				String query = "select * from park.detailtb where VehicleNumber = '"+tfvehiclenumber.getText()+"'";
				try {
					Statement st23 = (Statement) con.createStatement();
					ResultSet r =st23.executeQuery(query);
					double Rs;
					while(r.next()) {
						
						
						SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
						String date = sdf.format(new java.util.Date());
						LocalTime t = LocalTime.now();
						String time = t.toString();
						Long l = System.currentTimeMillis();
						String L=l.toString();
						
						/////////////////////////////////////////////////////////////////////////////////To take all data and put in deleteTB
							
							String FirstName= r.getString(1);
							String LastName= r.getString(2);
							String VehicleNumberV= r.getString(3);
							String VehicleTypeV= r.getString(4);
							String eMail= r.getString(5);
							String MobileNumber= r.getString(6);
							String EntryTime= r.getString(7);
							String ExitTime= time;
							String EntryDate= r.getString(9);
							String ExitDate= date;
							String EntryTimeMSV= r.getString(11);
							String ExitTimeMSV= L;
							String RandomNumber= r.getString(13);
							int slot= r.getInt(14);
							Statement s=(Statement) con.createStatement();
							String q= "insert into park.deletetb (FirstName,LastName,VehicleNumber,VehicleType,eMail,MobileNumber,EntryTime,ExitTime,EntryDate,ExitDate,EntryTimeMS,ExitTimeMS,RandomNumber,slot) "
									+ "values('"+FirstName+"','"+LastName+"','"+VehicleNumber+"','"+VehicleTypeV+"','"+eMail+"','"+MobileNumber+"','"+EntryTime+"','"+ExitTime+"','"+EntryDate+"','"+ExitDate+"','"+EntryTimeMSV+"','"+ExitTimeMS+"','"+RandomNumber+"','"+slot+"')";
							s.executeUpdate(q);
							JOptionPane.showMessageDialog(null,"Record added successfully");
						////////////////////////////////////////////////////////setting the bean	
							
						DeleteDataBean db = new DeleteDataBean();
						db.setFirstName(FirstName);
						db.setLastName(LastName);
						db.setVehicleNumberV(VehicleNumberV);
						db.setVehicleTypeV(VehicleTypeV);
						db.seteMail(eMail);
						db.setMobileNumber(MobileNumber);
						db.setEntryTime(EntryTime);
						db.setExitTime(ExitTime);
						db.setEntryDate(EntryDate);
						db.setExitDate(ExitDate);
						db.setEntryTimeMSV(EntryTimeMSV);
						db.setExitTimeMSV(ExitTimeMSV);
						db.setRandomNumber(RandomNumber);
						db.setSlot(slot);
						
						////////////////////////////////////////////////////////setting the bean
						//////////////////////////////////////////////////for pdf
						
						

						
						//////////////////////////////////////////////////////////////////////////////////To take all data and put in deleteTB
						long EntryTimeMS=Long.parseLong(r.getString(11));
						double Hr=(double)(ExitTimeMS-EntryTimeMS)/(1000*60*60);
						String VehicleType = r.getString(4);
						if(VehicleType.equals("2")) {
							if(Hr<=4) {
								Rs=12.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
								
								
							}
							else if(Hr>4&&Hr<=8) {
								Rs=24.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>8&&Hr<=12) {
								Rs=36.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>12&&Hr<=16) {
								Rs=48.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>16&&Hr<=20) {
								Rs=60.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>20&&Hr<=24) {
								Rs=72.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else {
								Rs=500.0;
								JOptionPane.showMessageDialog(null,"Fine Generated is = Rs. "+Rs);
							}
							
							String q12= "insert into park.revenueforpms (vehiclenumber , billpaid ,paymentdate,paymenttime ) "
									+ "values('"+VehicleNumberV+"','"+Rs+"','"+ExitDate+"','"+ExitTime+"')";
							s.executeUpdate(q12);
							JOptionPane.showMessageDialog(null,"Record added successfully");
							
							standard2w d;
							try {
								d = new standard2w();
								d.delete(VehicleNumber);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						else if(VehicleType.equals("4")) {
							if(Hr<=4) {
								Rs=18.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>4&&Hr<=8) {
								Rs=36.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>8&&Hr<=12) {
								Rs=54.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>12&&Hr<=16) {
								Rs=72.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>16&&Hr<=20) {
								Rs=90.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else if(Hr>20&&Hr<=24) {
								Rs=108.0;
								JOptionPane.showMessageDialog(null,"Bill Generated is = Rs. "+Rs);
							}
							else {
								Rs=500.0;
							
								JOptionPane.showMessageDialog(null,"Fine Generated is = Rs. "+Rs);
								
								
								
								
							}
							
							String q21= "insert into park.revenueforpms (vehiclenumber , billpaid ,paymentdate ,paymenttime ) "
									+ "values('"+VehicleNumberV+"','"+Rs+"','"+ExitDate+"','"+ExitTime+"')";
							s.executeUpdate(q21);
							JOptionPane.showMessageDialog(null,"Record added successfully");
							
							
							standard4w d;
							try {
								d = new standard4w();
								d.delete(VehicleNumber);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					/////////////////////To insert the data first into deleted table
					
					
					
					String qq="Delete from  park.detailtb where VehicleNumber = '"+VehicleNumber+"' " ;
					Statement stm = (Statement) con.createStatement();
					stm.executeUpdate(qq);
					JOptionPane.showMessageDialog(null,"Data deleted Successfully");
					String qq1="Delete from  park.messengertb where VehicleNumber = '"+VehicleNumber+"' " ;
					Statement stm1 = (Statement) con.createStatement();
					stm.executeUpdate(qq1);
				
				} catch (Exception e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProceedToPayment.setBackground(Color.pink);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
			
				lblProceedToPayment.setBackground(new Color(255,255,204));
			}
		});
		lblProceedToPayment.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		lblProceedToPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblProceedToPayment.setBounds(427, 457, 323, 73);
		contentPane.add(lblProceedToPayment);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanelDashboard a =new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
			label.setBackground(Color.red);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			label.setBackground(new Color(255,255,204));
			}
		});
		label.setBackground(new Color(255, 255, 204));
		label.setIcon(new ImageIcon(OfflinePayment.class.getResource("/img_Driver/back-arrow.png")));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label.setBounds(1015, 0, 125, 73);
		contentPane.add(label);
	}
}
