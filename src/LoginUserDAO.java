import org.csu.bean.UserInfo;

public interface LoginUserDAO {
    public UserInfo findUserByUsernameAndPassword(UserInfo userInfo);
}
