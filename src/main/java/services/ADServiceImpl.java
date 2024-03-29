package services;


import dataSets.User;
import interfaces.ADService;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class ADServiceImpl implements ADService {
    private static DirContext ldapContext;

    private String login;
    private String password;

    public ADServiceImpl(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public ADServiceImpl() {

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void serviceInitialization() throws Exception {
        Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        ldapEnv.put(Context.PROVIDER_URL, "ldap://blogon2.hq.ru.corp.leroymerlin.com:389");
        ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        ldapEnv.put(Context.SECURITY_PRINCIPAL, "ru1000\\" + login); //"CN=ru1000\\it001.mag039,OU=Shops,OU=Leroy Merlin Vostok,DC=hq,DC=ru,DC=corp,DC=leroymerlin,DC=com");
        ldapEnv.put(Context.SECURITY_CREDENTIALS, password);
        ldapContext = new InitialDirContext(ldapEnv);
    }

    public User getUserInfo() throws NamingException {
        User user = new User();
        SearchControls searchControls = new SearchControls();
        String returnedAtts[] = {"samAccountName", "givenName", "sn", "title"};
        searchControls.setReturningAttributes(returnedAtts);
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        String searchFilter = "(&(samAccountName=" + login + "))";
        String searchBase = "ou=Shops,ou=Leroy Merlin Vostok,dc=hq,dc=ru,dc=corp,dc=leroymerlin,dc=com";
        NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchControls);

        if (answer.hasMoreElements()) {
            SearchResult sr = answer.next();
            user.setLogin(sr.getAttributes().get("samaccountname").get(0).toString());
            user.setUserName(sr.getAttributes().get("givenName").get(0).toString());
            user.setUserSurname(sr.getAttributes().get("sn").get(0).toString());
            user.setUserPosition(sr.getAttributes().get("title").get(0).toString());
        }
        return user;
    }

}
