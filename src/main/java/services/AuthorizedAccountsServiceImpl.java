package services;

import dataSets.User;
import interfaces.AuthorizedAccountsService;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class AuthorizedAccountsServiceImpl implements AuthorizedAccountsService {
    private LinkedList<User> authorizedUsers;

    public AuthorizedAccountsServiceImpl() {
        authorizedUsers = new LinkedList<User>();
    }

    public void addUser(User user) {
        authorizedUsers.add(user);
    }

    public void deleteUser(User user) {
        authorizedUsers.remove(user);
    }

    public int getUser(String login) {
        int isAuthorized = -1;
        int i = 0;
        for (User user : authorizedUsers) {
            if (user.getUserLogin() == login) {
                isAuthorized = i;
            }
            i++;
        }
        return isAuthorized;
    }


}
