package servlets;

import dbServices.DBService;
import services.ADService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private final DBService dbService;

    public LoginServlet(DBService dbService){
        this.dbService = dbService;
    }


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ADService adService = new ADService(login, password);
        if (adService.getUserInfo()!=null){
            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding("windows-1251");
            response.getWriter().println(adService.getUserInfo());
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }


    }

}
