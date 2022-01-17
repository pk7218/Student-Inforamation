import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.util.Scanner;
/*commands to enter in database mysql
 * mysql -u root -p password
  use databasename;
 
 
 * 
 * */
public class JdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("oracle.jdbc.driver.OracleDriver");//For oracle DBMS 
		String url="jdbc:mysql://127.0.0.1:3306/firstproject";
		String uname="root";
		String pass="";
		
		//Step1:search and  load the appropreate driver(by using forName function)
//		  user driver manager to form the connection with database
//		  write queries(here in this project i had used createStatement method you can use also prepared statement)

		Scanner sc=new Scanner(System.in);
		
//		do{
//			System.out.println("would u like to insert one more record.!(y/n)");
//			String ch=sc.next();
//			
//			if(ch.matches("y"))
//			{
//				
//			}
//			else
//			{
//				break;
//			}
//			
//			
//		}while(sc.hasNext());

		try {
			Connection con= DriverManager.getConnection(url,uname,pass);
			if(con.isClosed())
			{
				System.out.println("SOmething went wrong.!");
			}
			else{
				java.sql.Statement statement=con.createStatement();
//				instead of above create stetement you can use 
				PreparedStatement pst=con.prepareStatement("youe sql query");
//				pst.
				System.out.println("Enter in your name.!");
				String name=sc.next();
				System.out.println("last name");
				String lastName=sc.next();
				System.out.println("Gender m/f");//in working condition
				String gender=sc.next();
				if(gender.matches("m"))
					gender="male";
				else
					gender="female";
			    //Insert query passing
				statement.executeUpdate("Insert into student_master values(0,'"+name+"','"+lastName+"','"+gender+"','1998-07-01', now())");

				ResultSet resultset=statement.executeQuery("select * from student_master");
			    
				System.out.format("%40s%n", "Student Table");
				System.out.println("---------------------------------------------------------------------");
				System.out.format("%-5s%-9s%-10s%-10s%-15s%-20s%n","rNo","Name","Sir Name","Gender","DOB","Record inseted date"); 
				System.out.println("---------------------------------------------------------------------");
				while(resultset.next())
				{    
					//formatting the the out put
					 System.out.format("%-4s%-10s%-10s%-10s%-15s%-20s", 
							 resultset.getString("id"),
							 resultset.getString("fname"),
							 resultset.getString("lname"),
							 resultset.getString("gender"),
							 resultset.getString("DOB"),
							 resultset.getString("recInsertionDate"));
					         System.out.println("\n");

				}
//				System.out.format("%-10s%07d%10.3f%n", "Student Table\n",10,10f);
//				
			}
		}		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch
		(Exception e)
		{
			System.out.println("Something went Wrong..!");
		}
		

	}

}
