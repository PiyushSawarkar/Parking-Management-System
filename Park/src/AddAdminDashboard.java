import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
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
//import pdfTest.*;
public class AddAdminDashboard extends JFrame {

	private JPanel contentPane;
	private JTextField tffirstname;
	private JTextField tflastname;
	private JTextField tfvehiclenumber;
	private JTextField tfvehicletype;
	private JTextField tfemail;
	private JTextField tfmobilenumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdminDashboard frame = new AddAdminDashboard();
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
	Connection con=null;
	public AddAdminDashboard() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 759);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 204));
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanelDashboard a = new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		lblX.setIcon(new ImageIcon(AddAdminDashboard.class.getResource("/img_Driver/back-arrow.png")));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblX.setBounds(892, 0, 106, 53);
		contentPane.add(lblX);
		
		JLabel lblNewRegistrationPage = new JLabel("New Registration Page");
		lblNewRegistrationPage.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 41));
		lblNewRegistrationPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewRegistrationPage.setBounds(252, 48, 511, 59);
		contentPane.add(lblNewRegistrationPage);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblFirstName.setBounds(91, 162, 172, 29);
		contentPane.add(lblFirstName);
		
		tffirstname = new JTextField();
		tffirstname.setBackground(new Color(255, 255, 204));
		tffirstname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tffirstname.setHorizontalAlignment(SwingConstants.CENTER);
		tffirstname.setForeground(Color.DARK_GRAY);
		tffirstname.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		tffirstname.setBounds(267, 162, 647, 29);
		contentPane.add(tffirstname);
		tffirstname.setColumns(10);
		
		tflastname = new JTextField();
		tflastname.setBackground(new Color(255, 255, 204));
		tflastname.setHorizontalAlignment(SwingConstants.CENTER);
		tflastname.setForeground(Color.DARK_GRAY);
		tflastname.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		tflastname.setColumns(10);
		tflastname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tflastname.setBounds(267, 240, 647, 29);
		contentPane.add(tflastname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblLastName.setBounds(91, 240, 172, 29);
		contentPane.add(lblLastName);
		
		tfvehiclenumber = new JTextField();
		tfvehiclenumber.setBackground(new Color(255, 255, 204));
		tfvehiclenumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfvehiclenumber.setForeground(Color.DARK_GRAY);
		tfvehiclenumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		tfvehiclenumber.setColumns(10);
		tfvehiclenumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tfvehiclenumber.setBounds(267, 320, 647, 29);
		contentPane.add(tfvehiclenumber);
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number");
		lblVehicleNumber.setForeground(Color.DARK_GRAY);
		lblVehicleNumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblVehicleNumber.setBounds(91, 320, 172, 29);
		contentPane.add(lblVehicleNumber);
		
		tfvehicletype = new JTextField();
		tfvehicletype.setBackground(new Color(255, 255, 204));
		tfvehicletype.setHorizontalAlignment(SwingConstants.CENTER);
		tfvehicletype.setForeground(Color.DARK_GRAY);
		tfvehicletype.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		tfvehicletype.setColumns(10);
		tfvehicletype.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tfvehicletype.setBounds(267, 410, 647, 29);
		contentPane.add(tfvehicletype);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setForeground(Color.DARK_GRAY);
		lblVehicleType.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblVehicleType.setBounds(91, 410, 172, 29);
		contentPane.add(lblVehicleType);
		
		tfemail = new JTextField();
		tfemail.setBackground(new Color(255, 255, 204));
		tfemail.setHorizontalAlignment(SwingConstants.CENTER);
		tfemail.setForeground(Color.DARK_GRAY);
		tfemail.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		tfemail.setColumns(10);
		tfemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tfemail.setBounds(267, 496, 647, 29);
		contentPane.add(tfemail);
		
		JLabel lblEmail = new JLabel("e-Mail");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblEmail.setBounds(91, 496, 172, 29);
		contentPane.add(lblEmail);
		
		tfmobilenumber = new JTextField();
		tfmobilenumber.setBackground(new Color(255, 255, 204));
		tfmobilenumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfmobilenumber.setForeground(Color.DARK_GRAY);
		tfmobilenumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		tfmobilenumber.setColumns(10);
		tfmobilenumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		tfmobilenumber.setBounds(267, 593, 647, 29);
		contentPane.add(tfmobilenumber);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setForeground(Color.DARK_GRAY);
		lblMobileNumber.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblMobileNumber.setBounds(91, 593, 172, 29);
		contentPane.add(lblMobileNumber);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int VehicleType=Integer.parseInt(tfvehicletype.getText());
				if(VehicleType==2) {
				//for vehicle of type 2
				
				try {
					
					
						SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
						String date = sdf.format(new java.util.Date());
						LocalTime t = LocalTime.now();
						String time = t.toString();
						Long l = System.currentTimeMillis();
						String L=l.toString();
						Statement s= con.createStatement();
						standard2w d =  new standard2w();
					
						
							String FirstName=tffirstname.getText(),LastName=tflastname.getText(),VehicleNumber=tfvehiclenumber.getText(),eMail=tfemail.getText(),MobileNumber=tfmobilenumber.getText(),EntryTime=time,ExitTime="",EntryDate=date,ExitDate="",EntryTimeMS=L,ExitTimeMS="",RandomNumber="";
							d.insert(VehicleNumber);
							int slot  = d.getSlot();
							String q= "insert into park.detailtb (FirstName,LastName,VehicleNumber,VehicleType,eMail,MobileNumber,EntryTime,ExitTime,EntryDate,ExitDate,EntryTimeMS,ExitTimeMS,RandomNumber,slot) "
									+ "values('"+FirstName+"','"+LastName+"','"+VehicleNumber+"','"+VehicleType+"','"+eMail+"','"+MobileNumber+"','"+EntryTime+"','"+ExitTime+"','"+EntryDate+"','"+ExitDate+"','"+EntryTimeMS+"','"+ExitTimeMS+"','"+RandomNumber+"','"+slot+"')";
							s.executeUpdate(q);
							JOptionPane.showMessageDialog(null,"Record added successfully");
						///////////////////////////////////////////////////////////////////////////////////////////////////////////////////use a jframe
							
							UserBean db = new UserBean();
							db.setFirstName(FirstName);
							db.setLastName(LastName);
							db.setVehicleNumberV(VehicleNumber);
							db.setVehicleTypeV(Integer.toString(VehicleType));
							db.seteMail(eMail);
							db.setMobileNumber(MobileNumber);
							db.setEntryTime(EntryTime);
							//db.setExitTime(ExitTime);
							db.setEntryDate(EntryDate);
							//db.setExitDate(ExitDate);
							db.setEntryTimeMSV(EntryTimeMS);
							//db.setExitTimeMSV(ExitTimeMSV);
							//db.setRandomNumber(RandomNumber);
							db.setSlot(slot);
							
							/*pdfmail p = new pdfmail();
							p.generatePdfMail(db);
							*/
							pdfmail p =new pdfmail();
							p.generatePdfMail(db);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				}//end of if()
				
				//code for four wheeler
				else if (VehicleType==4){
					try {
							SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
							String date = sdf.format(new java.util.Date());
							LocalTime t = LocalTime.now();
							String time = t.toString();
							Long l = System.currentTimeMillis();
							String L=l.toString();
							Statement s= con.createStatement();
							standard4w d =  new standard4w();
							
							
							
						
								String FirstName=tffirstname.getText(),LastName=tflastname.getText(),VehicleNumber=tfvehiclenumber.getText(),eMail=tfemail.getText(),MobileNumber=tfmobilenumber.getText(),EntryTime=time,ExitTime="",EntryDate=date,ExitDate="",EntryTimeMS=L,ExitTimeMS="",RandomNumber="";
								d.insert(VehicleNumber);
								int slot  = d.getSlot();
								
								String q= "insert into park.detailtb (FirstName,LastName,VehicleNumber,VehicleType,eMail,MobileNumber,EntryTime,ExitTime,EntryDate,ExitDate,EntryTimeMS,ExitTimeMS,RandomNumber,slot) "
										+ "values('"+FirstName+"','"+LastName+"','"+VehicleNumber+"','"+VehicleType+"','"+eMail+"','"+MobileNumber+"','"+EntryTime+"','"+ExitTime+"','"+EntryDate+"','"+ExitDate+"','"+EntryTimeMS+"','"+ExitTimeMS+"','"+RandomNumber+"','"+slot+"')";
								s.executeUpdate(q);
								JOptionPane.showMessageDialog(null,"Record added successfully");
							
							
								UserBean db = new UserBean();
								db.setFirstName(FirstName);
								db.setLastName(LastName);
								db.setVehicleNumberV(VehicleNumber);
								db.setVehicleTypeV(Integer.toString(VehicleType));
								db.seteMail(eMail);
								db.setMobileNumber(MobileNumber);
								db.setEntryTime(EntryTime);
								//db.setExitTime(ExitTime);
								db.setEntryDate(EntryDate);
								//db.setExitDate(ExitDate);
								db.setEntryTimeMSV(EntryTimeMS);
								//db.setExitTimeMSV(ExitTimeMSV);
								//db.setRandomNumber(RandomNumber);
								db.setSlot(slot);
								
								/*pdfmail p = new pdfmail();
								p.generatePdfMail(db);
								*/
								pdfmail p =new pdfmail();
								p.generatePdfMail(db);
						
					}catch(Exception e) {
						e.printStackTrace();
						
					}
				
				}
				else {
					
					JOptionPane.showMessageDialog(null, "wrong type of vehicle ");
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////jframe here
				}
			}
		});
		lblRegister.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(327, 687, 350, 59);
		contentPane.add(lblRegister);

}
}