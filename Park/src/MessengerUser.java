
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MessengerUser extends JFrame {
	private JPanel contentPane;
	private JTable table;
	//public String vehNum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessengerUser frame = new MessengerUser();
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
	private JTextField textField;
	private JTextField vehNum;
	public MessengerUser() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setBackground(new Color(255, 255, 204));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserPanelDashboard u  =new UserPanelDashboard();
				u.setVisible(true);
				u.setLocationRelativeTo(null);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
			label.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(Color.WHITE);
			}
		});
		label.setIcon(new ImageIcon(MessengerUser.class.getResource("/img_Driver/back-arrow.png")));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label.setBounds(1118, 0, 112, 81);
		contentPane.add(label);
		
		JLabel lblMessenger = new JLabel("  Messenger");
		lblMessenger.setForeground(new Color(255, 255, 255));
		lblMessenger.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessenger.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		lblMessenger.setBackground(new Color(51, 0, 102));
		lblMessenger.setOpaque(true);
		lblMessenger.setBounds(0, 0, 1227, 81);
		contentPane.add(lblMessenger);
		
		JLabel lblLoadRecievedMessages = new JLabel("Load Recieved Messages");
		lblLoadRecievedMessages.setBackground(new Color(255, 255, 204));
		lblLoadRecievedMessages.setOpaque(true);
		lblLoadRecievedMessages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String vehnum = vehNum.getText();//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////this would be taken from that bean
					
					String query1 ="select * from park.messengertb where recever = '"+vehnum+"' ";//where to = '"+to+"'
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs1 = stmt.executeQuery(query1);
				
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e23) {
					// TODO: handle exception
				}
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLoadRecievedMessages.setBackground(Color.pink);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			lblLoadRecievedMessages.setBackground(new Color(255,255,204));
			
			}
		});
		lblLoadRecievedMessages.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		lblLoadRecievedMessages.setBounds(10, 94, 301, 44);
		contentPane.add(lblLoadRecievedMessages);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 157, 637, 530);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCompose = new JLabel("Compose");
		lblCompose.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblCompose.setBounds(708, 236, 139, 44);
		contentPane.add(lblCompose);
		
		JLabel lblSendMessage = new JLabel("Send Message To admin");
		lblSendMessage.setBackground(new Color(255, 255, 204));
		lblSendMessage.setOpaque(true);
		lblSendMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				String date = sdf.format(new java.util.Date());
				LocalTime t = LocalTime.now();
				String time = t.toString();
				
				
				String senderr =vehNum.getText() ; //vehicle number must appear here
				String recever = "admin";
				String content = textField.getText();
				String q= "insert into  park.messengertb (sender , recever ,content ,  sendingdate , sendingtime) "
						+ "values('"+senderr+"','"+recever+"' ,'"+content+"', '"+date+"' , '"+time+"')";
				Statement stm;
				try {
					stm = (Statement) con.createStatement();
					stm.executeUpdate(q);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"Data sent Successfully");
			
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
			lblSendMessage.setBackground(Color.pink);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSendMessage.setBackground(new Color(255,255,204));
			
			}
		});
		lblSendMessage.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblSendMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendMessage.setBounds(744, 469, 386, 128);
		contentPane.add(lblSendMessage);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(708, 310, 438, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterYourVehocle = new JLabel("Enter your Vehicle Number");
		lblEnterYourVehocle.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblEnterYourVehocle.setBounds(708, 111, 438, 44);
		contentPane.add(lblEnterYourVehocle);
		
		vehNum = new JTextField();
		vehNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vehNum.setColumns(10);
		vehNum.setBounds(708, 185, 438, 38);
		contentPane.add(vehNum);
	}
}
