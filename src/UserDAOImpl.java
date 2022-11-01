import org.csu.bean.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements LoginUserDAO{
    private static String findUserByUsernameAndPasswordSQL =
            "select * from user_info where username = ? and password = ?";
    @Override
    public UserInfo findUserByUsernameAndPassword(UserInfo userInfo) {
        UserInfo result = null;
        try {
            Connection connection = DBUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(findUserByUsernameAndPasswordSQL);
            preparedStatement.setString(1,userInfo.getUsername());
            preparedStatement.setString(2,userInfo.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())   result=userInfo;
            else result = null;

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
