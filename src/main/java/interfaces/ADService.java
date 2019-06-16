package interfaces;

import dataSets.User;

import javax.naming.NamingException;

public interface ADService {
    User getUserInfo() throws Exception;

    void setLogin(String login);

    void setPassword(String password);

    void serviceInitialization() throws Exception;
}
