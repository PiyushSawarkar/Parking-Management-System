

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;



import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class sendmail {
     

public void send2(String name,String em) {

    
    
    
	String email=em;
    final String username = "piyush.parkProject@gmail.com"; //ur email
    final String password = "123456@piyush";//ur Password

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("piyush.parkProject@gmail.com"));//ur email
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));//u will send to
        message.setSubject("Report_ParkingMgmtSystem");    
        message.setText("");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();


     
     
    //attached 1 --------------------------------------------
        String file = "C:\\Users\\piyush\\eclipse-workspace-PiyushS\\Park\\PDF's\\"+name;//Give The location where your PDF's folder is stored thats it...others all this Project would handle.
        String fileName = name;
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
    message.setContent(multipart);

       
        //System.out.println("sending");
        Transport.send(message);
        //System.out.println("Done");
        
   

            
}catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}
    




public class pdfmail {

	public void  generatePdfMail(UserBean db) {
		Document document = new Document();
		try {
			String fn=Long.toString((System.currentTimeMillis()/1000));
			String fnme=fn+"jfile.pdf";
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\piyush\\eclipse-workspace-PiyushS\\Park\\PDF's\\"+fnme));
			////Give The location where your PDF's folder is stored thats it...others all this Project would handle.
			document.open();
			document.add(new Paragraph("                 Parking Management System",FontFactory.getFont(FontFactory.TIMES_BOLD,23,Font.BOLD,BaseColor.BLACK)));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("                                         CopyRight 2018.All Rights Reserved.",FontFactory.getFont(FontFactory.TIMES_BOLD,13,Font.BOLD,BaseColor.BLACK)));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Registration Date : "+new Date().toString()));
			document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("User Detail and Slot details:- "));
			document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph("FirstName : "+db.getFirstName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("LastName : "+db.getLastName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Mobile Number : "+db.getMobileNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Vehicle Number : "+db.getVehicleNumberV()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Vehicle Type : "+db.getVehicleTypeV()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Slot Alloted : "+db.getSlot()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Your e-mail : "+db.geteMail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Entry Date : "+db.getEntryDate()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Entry time : "+db.getEntryTime()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Note : "));
			document.add(new Paragraph("1.Rs:12/=,18/= is the Rate for 2 Wheeler and 4 Wheeler vehicles per 4 Hr , respectively."));
			document.add(new Paragraph("2.A Complimentary Subscription to Clean My Vehicle and Tune My vehicle is provided for customers convinience. "));
			document.add(new Paragraph("3.The Parking Management System , for any kind of misconvinience to your vehicle , would be held responsible for none."));
			document.add(new Paragraph("4.Payment Method is OFFLINE till now."));
			document.add(new Paragraph("5.Importants updates would be mailed , so do keep a regular check on our updates."));
			document.add(new Paragraph("6.Parking is open till end of 24 th hour from the time of Parking so if vehicle is found in parking a strict action with Rs.500 Charge would be fired."));
			document.add(new Paragraph("7.User is provided an access to a unique messaging system , so that he can have any of his queries resolved with the Admin without a personal face-off."));
			document.add(new Paragraph("8.Admin may communincate via the Parking management system messenger OR via e-mail , if needed."));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ----------------------------------------------Happy Parking :) --------------------------------------------------"));
			
			document.close();
			sendmail s = new sendmail();
			
			s.send2(fnme,db.geteMail());
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
