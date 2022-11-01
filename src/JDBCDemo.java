import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/demo","root","02130708Wc");
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO userinfo VALUES(1,'Bill Gates','bill@microsoft.com',55)";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Insert new user success.");
            }

            statement.close();
            connection.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
