package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletResponse responce,
                       HttpServletRequest request) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
    }

}
