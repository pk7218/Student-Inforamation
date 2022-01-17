import java.sql.*;
import com.mysql.jdbc.Statement;

public class DbConnection
{
		private String url,uname, pass;
		private static Connection con;

	

	DbConnection(String pathJdbcClassFile,String url,String uname,String pass)
	{
		try
		{
			Class.forName(pathJdbcClassFile);
			this.pass=pass;
			this.url=url;
			this.uname=uname;
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public void setConnectionString(String url,String uname,String pass)
	{
		this.url=url;
		this.uname=uname;
		this.pass=pass;
	}
	private String getUser()
	{		
		return uname;
	}

	private String getPassword() {

		return pass;
	}

	public String getConnectionString1()
	{
		String url="jdbc:mysql://locahost:3306/firstproject",uname="root",pass="";
		String conStr=url+","+uname+","+pass;	
		return conStr;
	}
	public Connection getdbConnection()
	{
		
		try {
             
			con = DriverManager.getConnection(url,getUser(),getPassword());
			return con;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}

	public boolean insert(String query)
	{  
		boolean flag=false;
		try {
            
			Connection con=getdbConnection();
			java.sql.Statement 	st=con.createStatement();

			st.executeUpdate(query);
			flag=true;

		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return flag;
	}
	public ResultSet GetData(String query)
	{
		ResultSet set=null;
		Connection con=getdbConnection();
		java.sql.Statement st;
		try {
			st = con.createStatement();
			set=st.executeQuery(query);
			return set;

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return set;
	}
}
