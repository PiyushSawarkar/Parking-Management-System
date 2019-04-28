
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.Cursor;
public class SendMailAdminDashboard extends JFrame {

	public JPanel contentPane;
	public JTextField mailID;
	public JTextField subject;
	public JTextArea message;
	public void sendMail() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String mailId=mailID.getText();
		String Subject=subject.getText();
		String MessageToSend=message.getText();
		
	
			final String username = "piyush.parkProject@gmail.com"; // enter your mail id
			final String password = "123456@piyush";// enter ur password
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
				
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {
				///
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("piyush.parkProject@gmail.com")); // same email id
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailId));// whom u have to send mails that person id
				message.setSubject(Subject);
				message.setText(MessageToSend);

				Transport.send(message);

		//	System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	
			public void run() {
				try {
					SendMailAdminDashboard frame = new SendMailAdminDashboard();
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
	public SendMailAdminDashboard() {
		setBackground(new Color(204, 204, 255));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 280, 612);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SendMailAdminDashboard.class.getResource("/img_Driver/email (1).png")));
		label.setBounds(57, 80, 146, 153);
		panel.add(label);
		
		JLabel lblMessagingSystem = new JLabel("Messaging System");
		lblMessagingSystem.setForeground(new Color(255, 255, 255));
		lblMessagingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessagingSystem.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		lblMessagingSystem.setBounds(30, 0, 205, 72);
		panel.add(lblMessagingSystem);
		
		JLabel lblPiyushparkprojectgmailcom = new JLabel("piyush.parkProject@gmail.com");
		lblPiyushparkprojectgmailcom.setForeground(new Color(255, 255, 255));
		lblPiyushparkprojectgmailcom.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblPiyushparkprojectgmailcom.setBounds(12, 567, 237, 32);
		panel.add(lblPiyushparkprojectgmailcom);
		
		JLabel label_3 = new JLabel("From ,");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 36));
		label_3.setBounds(30, 474, 135, 54);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("sent");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		label_4.setBounds(30, 436, 114, 32);
		panel.add(label_4);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		lblAdmin.setBounds(73, 269, 114, 32);
		panel.add(lblAdmin);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setBorder(null);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			AdminPanelDashboard a = new AdminPanelDashboard();
			a.setVisible(true);
			a.setLocationRelativeTo(null);
			dispose();
			}
			
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(SendMailAdminDashboard.class.getResource("/img_Driver/cancel.png")));
		label_1.setBounds(792, 1, 56, 47);
		contentPane.add(label_1);
		
		JLabel lblTo = new JLabel("To ,");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 36));
		lblTo.setBounds(286, 13, 89, 40);
		contentPane.add(lblTo);
		
		mailID = new JTextField();
		mailID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		mailID.setHorizontalAlignment(SwingConstants.CENTER);
		mailID.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		mailID.setBounds(330, 136, 430, 40);
		contentPane.add(mailID);
		mailID.setColumns(10);
		
		JLabel lblEnterEmailAddress = new JLabel("Enter e-Mail Address ");
		lblEnterEmailAddress.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblEnterEmailAddress.setBounds(330, 94, 229, 29);
		contentPane.add(lblEnterEmailAddress);
		
		JLabel label_2 = new JLabel("");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				sendMail();
				MailSentSuccess ms= new MailSentSuccess();
				ms.setVisible(true);
				ms.setLocationRelativeTo(null);
				
			}
		});
		label_2.setIcon(new ImageIcon(SendMailAdminDashboard.class.getResource("/img_Driver/send-button.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(769, 547, 68, 52);
		contentPane.add(label_2);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblMessage.setBounds(330, 328, 229, 29);
		contentPane.add(lblMessage);
		 message = new JTextArea();
		message.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		message.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		message.setBounds(330, 374, 430, 166);
		contentPane.add(message);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblSubject.setBounds(330, 212, 229, 29);
		contentPane.add(lblSubject);
		
		subject = new JTextField();
		subject.setHorizontalAlignment(SwingConstants.CENTER);
		subject.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		subject.setColumns(10);
		subject.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		subject.setBounds(330, 254, 430, 40);
		contentPane.add(subject);
	}
}
