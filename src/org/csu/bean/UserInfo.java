package org.csu.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfo {
    private String username;
    private String password;

    private boolean Login;

    private static String findUserByUsernameAndPasswordSQL =
            "select * from user_info where username = ? and password = ?";

    public UserInfo(){

    }
    public UserInfo(String username,String password)
    {
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/demo","root","02130708Wc");
            PreparedStatement preparedStatement = connection.prepareStatement(findUserByUsernameAndPasswordSQL);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())  Login = true;
            else Login = false;

            preparedStatement.close();
            connection.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if(username == null||username.equals("")){
            return false;
        }
        if(password ==null||password.equals("")){
            return false;
        }
        else if(Login){
            return true;
        }
        else if(!Login){
            return false;
        }
        else {
            return false;
        }
    }
}
