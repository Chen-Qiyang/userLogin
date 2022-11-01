import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/demo","root","02130708Wc");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM userinfo";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                System.out.print(resultSet.getInt(1)+"\t");
                System.out.print(resultSet.getString(2)+"\t");
                System.out.print(resultSet.getString(3)+"\t");
                System.out.println(resultSet.getInt(4));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
