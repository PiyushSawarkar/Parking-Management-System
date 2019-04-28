
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class standard2w {
	Connection con =null;
	int slot;

	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public standard2w()throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {
			
		}
		con=DriverManager.getConnection("jdbc:mysql://localHost:3306/slot", "root", "root");
	}
	public void insert(String i,String n) throws SQLException {
	
		String vehiclenumber=n;
		int slot = Integer.parseInt(i);
		String q="insert into slot.standard2w (slot,vehiclenumber) values ('"+slot+"' ,'"+vehiclenumber+"') ";///////////////////////////////////////////////INSERT
		Statement s = con.createStatement();
		s.executeUpdate(q);
		
	}
	public void insert(String vehiclenumber) throws SQLException {
		String q12="select count(*) from  slot.standard2w ";//////////////////////////////////counter of rows
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(q12);
		int n12=0;
		if(rs.next()) {
			n12=rs.getInt(1);
			System.out.println(n12);
		}////////////////////////////////////////////////////////////////////counter of rows
		if(n12<10) { 
			
			//this would permit creation of only 6 records
			String u ="select * from  slot.standard2w where vehiclenumber ='"+0+"' ";
			Statement s =con.createStatement();
			ResultSet rs114= s.executeQuery(u);
			int flag=0;	
			int status;
			while(rs114.next()) {
					flag=1;
				}
				if(flag==1) {
					status=1;// such slots are avaialble for new parking i.e. with name =0
				}
				else{
					status=0;///slot with name =0 not available a fresh park to allot
				}
			if(status==1) {
				String n = vehiclenumber;
				String zero="0";
				String ui = "update  slot.standard2w set vehiclenumber  = '"+n+" ' where vehiclenumber ='"+zero+"'";/////////////////////////////////////////////////UPDATE
				Statement s12= con.createStatement();
				s12.executeUpdate(ui);	
			}
			else {
				
				
				String q121="select count(*) from  slot.standard2w ";//////////////////////////////////counter of rows
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery(q121);
				int n121=0;
				while(rs1.next()) {
					n121=rs1.getInt(1);
					String slotAlot=Integer.toString(n121+1);///bussiness logic
					insert(slotAlot, vehiclenumber);///businesslogic//////////////////////////////////////////using insert to put in a fresh record
					setSlot(n121+1);
				}////////////////////////////////////////////////////////////////////counter of rows
				
				
			}
			
			
			
			
			
		}
		else {
			System.out.println("No slots available");
		}
		
	}
	public void delete(String id) throws SQLException {
		/*String idd=id;
		String q1="delete  from testDemo.table where id = '"+idd+"' ";////////////////////////////////////////////////////////////////////DELETE
		
		Statement s =con.createStatement();
		s.executeUpdate(q1);*///conventional procedure to delete
		String idd=id;
		String u ="select * from slot.standard2w where vehiclenumber ='"+idd+"' ";
		Statement s =con.createStatement();
		ResultSet rs= s.executeQuery(u);
/*		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
		}*///in here loop directly jumps to that very locations as per condition//////////////////////////////////////////////////////////////CHECK-1
		/*int flag=0;	
		while(rs.next()) {
				flag=1;
			}
			if(flag==1) {
				System.out.println("Data present");
			}
			else{
				System.out.println("data absent");
				
			}*///the way to search////////////////////////////////////////////////////////////////////////////////////////////////////////////CHECK-2
		if(rs.next()) {
		String slot = rs.getString(1);	
		int slo  = Integer.parseInt(slot);
		
		String newName = "0";
		String ui = "update slot.standard2w  set vehiclenumber  = '"+newName+" ' where slot ='"+slo+"'";/////////////////////////////////////////////////UPDATE
		Statement s12= con.createStatement();
		s12.executeUpdate(ui);
		
		}
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		standard2w d= new standard2w();
		/*d.insert("1", "piyush");
		d.insert("2", "rahul");
		d.insert("3", "pankaj");*/
		//d.insert("4","suraj");
		//d.delete("2");
		//d.insert("2","Mahesh");
		//d.delete("2");
		//d.delete("9");
		/*String id="2";
		d.delete(id);*/
		/*String nme = "Makhan";
		d.insert(nme);*/
		//d.insert("manish");
		//d.delete("5");
		//d.insert("Steve");
		//d.delete("2");
		//d.insert("Bill");
		//d.insert("ibm");
		//d.insert("Sundar");
		//d.insert("mike");
		//d.insert("mh04jj5332");
		/*d.insert("mhjkio");
		d.insert("kj87");
		d.insert("mddeu");
		d.insert("nmduedn");*/
		//d.delete("kj87");
		//d.insert("09opi");
		//d.delete("mhjkio");
		//d.insert("vfbg");
		//d.insert("mknjbh");
		//d.insert("kjh");
		
		/*d.insert("12");
		d.insert("78");
		d.insert("90");
		d.insert("920");
		d.insert("90221");
		d.insert("9220");*/
		//d.delete("12");
		//d.insert("45");
	//	d.insert("111");
		//d.insert("8978");
		//d.delete("111");
	}
}

