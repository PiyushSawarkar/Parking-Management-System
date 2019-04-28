


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.Statement;

import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginScreen extends JFrame {

	private JPanel contentPane;
	public JTextField u;
	public JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginScreen frame = new UserLoginScreen();
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
	 */Connection con =null;
	public UserLoginScreen() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {
			
		}
		con=DriverManager.getConnection("jdbc:mysql://localHost:3306/slot", "root", "root");
		
		
		setUndecorated(true);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.exit(0);
				dispose();
				Driver d = new Driver();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(Color.white);
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setIcon(new ImageIcon(UserLoginScreen.class.getResource("/img_Driver/error.png")));
		lblNewLabel.setBounds(764, 1, 68, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setOpaque(true);
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String query = "select * from park.detailtb where VehicleNumber = '"+p.getText()+"'";
				try {
					Statement st23 = (Statement) con.createStatement();
					ResultSet r =st23.executeQuery(query);
					int flag=0;
					while(r.next()) {
						flag=1;
						String FirstName= r.getString(1);
						String LastName= r.getString(2);
						String VehicleNumberV= r.getString(3);
						String VehicleTypeV= r.getString(4);
						String eMail= r.getString(5);
						String MobileNumber= r.getString(6);
						String EntryTime= r.getString(7);
						//String ExitTime= time;
						String EntryDate= r.getString(9);
						//String ExitDate= date;
						String EntryTimeMSV= r.getString(11);
						//String ExitTimeMSV= L;
						//String RandomNumber= r.getString(13);
						int slot= r.getInt(14);
						
						
						UserBean db = new UserBean();
						db.setFirstName(FirstName);
						db.setLastName(LastName);
						db.setVehicleNumberV(VehicleNumberV);
						db.setVehicleTypeV(VehicleTypeV);
						db.seteMail(eMail);
						db.setMobileNumber(MobileNumber);
						db.setEntryTime(EntryTime);
						//db.setExitTime(ExitTime);
						db.setEntryDate(EntryDate);
						//db.setExitDate(ExitDate);
						db.setEntryTimeMSV(EntryTimeMSV);
					//db.setExitTimeMSV(ExitTimeMSV);
						//db.setRandomNumber(RandomNumber);
						db.setSlot(slot);
						Mydetails m =  new Mydetails();
						m.getBean(db);
					}
					if(flag==1) {
						JOptionPane.showMessageDialog(null, "Record found");
						UserPanelDashboard d = new UserPanelDashboard();
						d.setVisible(true);
						d.setLocationRelativeTo(null);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Record Not found");
					}
				} catch (SQLException e23) {
					// TODO Auto-generated catch block
					e23.printStackTrace();
				}
			}
		});
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.DARK_GRAY);
		lblLogin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblLogin.setBounds(659, 576, 173, 61);
		contentPane.add(lblLogin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 33));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(438, 184, 188, 41);
		contentPane.add(lblUserName);
		
		u = new JTextField();
		u.setHorizontalAlignment(SwingConstants.CENTER);
		u.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		u.setForeground(Color.GRAY);
		u.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 31));
		u.setBounds(438, 261, 354, 41);
		contentPane.add(u);
		u.setColumns(10);
		
		p = new JPasswordField();
		p.setHorizontalAlignment(SwingConstants.CENTER);
		p.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		p.setForeground(Color.GRAY);
		p.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 39));
		p.setEchoChar('*');
		p.setBounds(438, 378, 354, 41);
		contentPane.add(p);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(-2, 1, 405, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(93, 47, 222, 143);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(UserLoginScreen.class.getResource("/img_Driver/admin-with-cogwheels (2).png")));
		
		JLabel lblAdmin = new JLabel("User");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 33));
		lblAdmin.setBounds(103, 203, 191, 41);
		panel.add(lblAdmin);
		
		JLabel lblHints = new JLabel("hints");
		lblHints.setIcon(new ImageIcon(UserLoginScreen.class.getResource("/img_Driver/lightbulb.png")));
		lblHints.setForeground(Color.WHITE);
		lblHints.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 23));
		lblHints.setBounds(28, 446, 133, 80);
		panel.add(lblHints);
		
		JLabel lblUsernameIsYour = new JLabel("Username is your First Name");
		lblUsernameIsYour.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblUsernameIsYour.setForeground(Color.WHITE);
		lblUsernameIsYour.setBounds(38, 540, 289, 33);
		panel.add(lblUsernameIsYour);
		
		JLabel lblPasswordIsYour = new JLabel("Password is your Vehicle Number");
		lblPasswordIsYour.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblPasswordIsYour.setForeground(Color.WHITE);
		lblPasswordIsYour.setBounds(37, 575, 296, 33);
		panel.add(lblPasswordIsYour);
		
		JLabel lblEnterCredentials = new JLabel("Enter Credentials ");
		lblEnterCredentials.setBackground(new Color(255, 255, 255));
		lblEnterCredentials.setForeground(Color.DARK_GRAY);
		lblEnterCredentials.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 34));
		lblEnterCredentials.setOpaque(true);
		lblEnterCredentials.setBounds(436, 68, 326, 74);
		contentPane.add(lblEnterCredentials);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setBounds(438, 220, 139, 41);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblPassword.setBounds(438, 337, 139, 41);
		contentPane.add(lblPassword);
	}
}
