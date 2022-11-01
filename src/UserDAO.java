import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
    private static String insertUserSQL =
                            "INSERT INTO userinfo VALUES(?,?,?,?,)";
    private static String updateUserSQL =
                            "UPDATE userinfo SET username = ?,email = ?,age = ? WHERE id = ?";
    private static String deleteUserSQL = "DELETE FROM userinfo WHERE id = ?";

    private static String selectUserSQL = "SELECT * FROM userinfo WHERE id = ?";

    private static String selectAllUserSQL = "SELECT * FROM userinfo";

    public boolean insertUser(User user)throws Exception
    {
        Connection connection = DBUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL);

        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getName());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setInt(4,user.getAge());

        int result = preparedStatement.executeUpdate();

        DBUtil.closePreparedStatement(preparedStatement);
        DBUtil.closeConnection(connection);

        return result == 1;
    }

    public boolean updateUser(User user)throws Exception
    {
        Connection connection = DBUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(updateUserSQL);

        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getName());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setInt(4,user.getAge());

        int result = preparedStatement.executeUpdate();

        DBUtil.closePreparedStatement(preparedStatement);
        DBUtil.closeConnection(connection);

        return result == 1;

    }

    public boolean deleteUser(int id)throws Exception
    {
        Connection connection = DBUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(deleteUserSQL);

        preparedStatement.setInt(1,id);

        int result = preparedStatement.executeUpdate();

        DBUtil.closePreparedStatement(preparedStatement);
        DBUtil.closeConnection(connection);

        return result == 1;
    }

    public User selectUser(int id)throws Exception
    {
        User user = new User();
        Connection connection = DBUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(selectUserSQL);

        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
        }

        DBUtil.closePreparedStatement(preparedStatement);
        DBUtil.closeConnection(connection);

        return user;
    }

    public ArrayList<User> selectAllUser()throws Exception
    {
        ArrayList<User> userList = new ArrayList<User>();

        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(selectAllUserSQL);

        while (resultSet.next()){
            User user = new User();

            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));

            userList.add(user);
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closeStatement(statement);
        DBUtil.closeConnection(connection);

        return userList;
    }
}
