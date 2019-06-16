package servlets;

import interfaces.ADService;
import services.ADServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "AuthorizationServlet", urlPatterns = {"/signin"})
public class AuthorizationServlet extends HttpServlet {
    private static final int LOGOUT_TIME = 10 * 60 * 1000;

    public AuthorizationServlet() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            ADService adService = new ADServiceImpl(login, password);
            adService.serviceInitialization();
            response.sendRedirect("deliveries.html");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            //response.getWriter().println("Access denied!");
        }

    }

/*    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, res) -> new AuthorizationSocket());
    }*/

}
