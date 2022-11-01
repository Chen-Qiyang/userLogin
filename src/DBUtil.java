import java.sql.*;

public class DBUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/demo";
    private static String username = "root";
    private static String password = "02130708Wc";

    public static Connection getConnection()throws Exception{
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);
        }catch (Exception e)
        {
            throw e;
        }
    }
    public static void closeConnection(Connection connection) throws Exception{
        if(connection != null)
        {
            connection.close();
        }
    }
    public static void closeStatement(Statement statement)throws Exception{
        if(statement != null)
        {
            statement.close();
        }
    }
    public static void closePreparedStatement(PreparedStatement preparedStatement)throws Exception {
        if(preparedStatement != null)
        {
            preparedStatement.close();
        }
    }
    public static void closeResultSet(ResultSet resultSet)throws Exception{
        if(resultSet != null)
        {
            resultSet.close();
        }
    }
}
