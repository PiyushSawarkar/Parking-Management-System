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

public class MessengerAdmin extends JFrame {
	private JPanel contentPane;
	private JTable table;
	public String vehiclenumber;
	//public JTextField tf;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessengerAdmin frame = new MessengerAdmin();
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
	private JTextField tf;
	public MessengerAdmin() {
		
		
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
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				AdminPanelDashboard a =new AdminPanelDashboard();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(new ImageIcon(MessengerAdmin.class.getResource("/img_Driver/back-arrow.png")));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		label.setBounds(1097, 0, 133, 81);
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
		lblLoadRecievedMessages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String to = "admin";
					
					String query1 ="select * from park.messengertb where recever = '"+to+"' ";//where to = '"+to+"'
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs1 = stmt.executeQuery(query1);
				
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e23) {
					// TODO: handle exception
				}
			
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
		
		JLabel lblSelectVehicleTo = new JLabel("Select Vehicle to send Messages");
		lblSelectVehicleTo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSelectVehicleTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String name1 = (table.getModel().getValueAt(row, 0)).toString();
				
				try {
					String query1 ="select * from park.messengertb where sender = '"+name1+"'";
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs11 = stmt.executeQuery(query1);
					while(rs11.next()) {
						
						
						
						
						vehiclenumber=rs11.getString(1);
						tf.setText(vehiclenumber);
						
					}
				} catch (Exception e12) {
					// TODO: handle exception
				}
				
				
			}
		});
		lblSelectVehicleTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectVehicleTo.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		lblSelectVehicleTo.setBounds(681, 94, 405, 44);
		contentPane.add(lblSelectVehicleTo);
		
		JLabel lblVehicleSelected = new JLabel("Vehicle Selected ");
		lblVehicleSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleSelected.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblVehicleSelected.setBounds(708, 195, 169, 44);
		contentPane.add(lblVehicleSelected);
		
		JLabel lblCompose = new JLabel("Compose");
		lblCompose.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblCompose.setBounds(713, 309, 139, 44);
		contentPane.add(lblCompose);
		
		JLabel lblSendMessage = new JLabel("Send Message");
		lblSendMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				String date = sdf.format(new java.util.Date());
				LocalTime t = LocalTime.now();
				String time = t.toString();
				
					
				String vehnum =tf.getText();
				String senderr = "admin";
				String content = textField.getText();
				String q= "insert into  park.messengertb (sender , recever ,content ,  sendingdate , sendingtime) "
						+ "values('"+senderr+"','"+vehnum+"' ,'"+content+"', '"+date+"' , '"+time+"')";
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
		});
		lblSendMessage.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		lblSendMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendMessage.setBounds(821, 448, 238, 128);
		contentPane.add(lblSendMessage);
		
		JLabel lblClickHere = new JLabel("click here");
		lblClickHere.setBounds(1026, 151, 60, 16);
		contentPane.add(lblClickHere);
		
		JLabel lblNote = new JLabel("Note : First Load data and select click on the sender then click on select vehicle to send message . ");
		lblNote.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		lblNote.setBounds(649, 603, 578, 71);
		contentPane.add(lblNote);
		
		textField = new JTextField();
		textField.setBounds(708, 380, 438, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		tf = new JTextField();
		tf.setHorizontalAlignment(SwingConstants.CENTER);
		tf.setEditable(false);
		tf.setBounds(889, 195, 257, 44);
		contentPane.add(tf);
		tf.setColumns(10);
	}
}
