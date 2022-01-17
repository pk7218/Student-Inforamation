import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*commands to enter in database mysql
 * mysql -u root -p password
  use mysql;
  use databasename;
  show tables;
 * 
 * */
public class JdbcDemo2 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		String url="jdbc:mysql://127.0.0.1:3306/firstproject";
		String uname="root";
		String pass="";
		DbConnection dbconnection=new DbConnection("com.mysql.jdbc.Driver",url,uname,pass);
		Scanner sc=new Scanner(System.in);
		int ch=0;
		String name,lastName,gender,DOB;
		ResultSet resultset;
		int size=0,id;
		A:do
		{
			System.out.println("Enter choice"
								+ "\n1 for add new Student."
								+ "\n2 for Update Student"
								+ "\n3 for Show a student Record."
								+ "\n4 for Show all Students"
								+ "\n5 for Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter in your name.!");
				name=sc.next();
				System.out.println("last name");
				lastName=sc.next();
				System.out.println("Enter BirthDate(YYYY-MM-DD)");
				DOB=sc.next();

				System.out.println("Gender m/f");//in working condition
				gender=sc.next();
				if(gender.matches("m"))
					gender="male";
				else
					gender="female";

				boolean flg=dbconnection.insert("Insert into student_master values(null,'"+name+"','"+lastName+"','"+gender+"','"+DOB+"', now())");
				if(flg)
				{
					System.out.println("Saving succeed.!\n");
				}
				else
				{
					System.out.println("not saved.!\n");
				}
				break;
			case 2:
				System.out.println("Enter student id");
				id=sc.nextInt();
				System.out.println("Enter in your name.!");
				name=sc.next();
				System.out.println("last name");
				lastName=sc.next();
				System.out.println("Enter BirthDate(YYYY-MM-DD)");
				DOB=sc.next();
				System.out.println("Gender m/f");//in working condition
				gender=sc.next();
				if(gender.matches("m"))
					gender="male";
				else
					gender="female";

				boolean flg1=dbconnection.insert("update student_master set fname='"+name+"',lname='"+lastName+"',gender='"+gender+"',DOB='"+DOB+"' where id="+id);
				if(flg1)
				{
					System.out.println("Updated successfully.!\n");
				}
				else
				{
					System.out.println("Failed to update.!\n");
				}

				break;
			case 3:
				size=0;
				System.out.println("Enter student id");
				id=sc.nextInt();
				resultset=dbconnection.GetData("Select * from student_master where id="+id);
				System.out.format("%40s%n", "--Student Table--");
				System.out.println("_______________________________________________________________________");
				System.out.format(" %-5s%-9s%-10s%-10s%-15s%-20s%n","rNo","Name","Sir Name","Gender","DOB","Record inseted date"); 
				System.out.println("_______________________________________________________________________");
				try {
					while(resultset.next())
					{    
						try {
							System.out.format(" %-4s%-10s%-10s%-10s%-15s%-20s%n", 
									resultset.getString("id"),
									resultset.getString("fname"),
									resultset.getString("lname"),
									resultset.getString("gender"),
									resultset.getString("DOB"),
									resultset.getString("recInsertionDate"));
							size++;
							System.out.println("_______________________________________________________________________");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      //Foramtting tag
				System.out.format("%-40s%n","Total records :"+size);
				System.out.println("_______________________________________________________________________\n");
				break;
			case 4:
				resultset=dbconnection.GetData("Select * from student_master");
				System.out.format("%40s%n", "--Student Table--");
				System.out.println("_______________________________________________________________________");
				System.out.format(" %-5s%-9s%-10s%-10s%-15s%-20s%n","rNo","Name","Sir Name","Gender","DOB","Record inseted date"); 
				System.out.println("_______________________________________________________________________");
				try {
					while(resultset.next())
					{    
						try {
							System.out.format(" %-4s%-10s%-10s%-10s%-15s%-20s%n", 
									resultset.getString("id"),
									resultset.getString("fname"),
									resultset.getString("lname"),
									resultset.getString("gender"),
									resultset.getString("DOB"),
									resultset.getString("recInsertionDate"));
							size++;
							System.out.println("_______________________________________________________________________");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.format("%-40s%n","Total records :"+size);
				System.out.println("_______________________________________________________________________\n");
				break;
			case 5:
				break A;
			default:
				break;
			}
		}while(ch>0);
	}

}
