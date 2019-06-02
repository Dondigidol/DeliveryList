package interfaces;

import dataSets.User;

public interface ADService {
    User getUserInfo() throws Exception;

    void setLogin(String login);

    void setPassword(String password);

    void serviceInitialization() throws Exception;
}
