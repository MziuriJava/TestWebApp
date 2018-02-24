package ge.mziuri.testwebapp.dao;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean logIn(String username, String password) {
        if (username.equals("vinme") && password.equals("rame")) {
            return true;
        } else {
            return false;
        }
    }
}
