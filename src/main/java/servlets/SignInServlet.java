package servlets;

import interfaces.ADService;
import interfaces.DBService;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import services.ADServiceImpl;
import webSockets.SignInWebSocket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInServlet", urlPatterns = {"/signin"})
public class SignInServlet extends WebSocketServlet {

    private static final int LOGOUT_TIME = 10 * 60 * 1000;

    public SignInServlet() {

    }


    /*    public void doPost(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            try{
                ADService adService = new ADServiceImpl(login, password);
                if (adService.getUserInfo()!=null){
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.setCharacterEncoding("windows-1251");
                    response.getWriter().println(adService.getUserInfo());
                } else {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }*/
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, res) -> new SignInWebSocket());
    }

}
