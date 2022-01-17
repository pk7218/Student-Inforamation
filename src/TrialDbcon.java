
public class TrialDbcon
{
   public static void main(String[] args) {
	DbConnection d=new DbConnection();
	d.Insert("insert into student_master values(null,'tytyty','tytyty','male','1998-07-01',now())");
	System.out.println("done");
}
}
