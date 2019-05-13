package services;

import dbServices.dataSets.User;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class ADService {
    private static DirContext ldapContext;

    private static String login;
    private static String password;

    public ADService(String login, String password){
            this.login = login;
            this.password = password;
            serviceInitialization();
    }

    public void serviceInitialization(){
        try {
            Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
            ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            ldapEnv.put(Context.PROVIDER_URL, "ldap://blogon2.hq.ru.corp.leroymerlin.com:389");
            ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
            ldapEnv.put(Context.SECURITY_PRINCIPAL, "ru1000\\" + login); //"CN=ru1000\\it001.mag039,OU=Shops,OU=Leroy Merlin Vostok,DC=hq,DC=ru,DC=corp,DC=leroymerlin,DC=com");
            ldapEnv.put(Context.SECURITY_CREDENTIALS, password);
            ldapContext = new InitialDirContext(ldapEnv);
        } catch (NamingException e){
           e.getLocalizedMessage();
        }
    }

    public User getUserInfo(){
        User user = new User();
        try{
            SearchControls searchControls = new SearchControls();
            String returnedAtts[]={"samAccountName", "givenName", "sn", "title"};
            searchControls.setReturningAttributes(returnedAtts);
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            String searchFilter = "(&(samAccountName=" + login + "))";
            String searchBase = "ou=Shops,ou=Leroy Merlin Vostok,dc=hq,dc=ru,dc=corp,dc=leroymerlin,dc=com";
            int totalResults= 0;
            NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchControls);

            if (answer.hasMoreElements()){
                SearchResult sr = answer.next();
                user.setLogin(sr.getAttributes().get("samaccountname").get(0).toString());
                user.setUserName(sr.getAttributes().get("givenName").get(0).toString());
                user.setUserSurname(sr.getAttributes().get("sn").get(0).toString());
                user.setUserPosition(sr.getAttributes().get("title").get(0).toString());
            }
        } catch (NamingException e){
            e.getLocalizedMessage();
        }
        return user;

    }

}
