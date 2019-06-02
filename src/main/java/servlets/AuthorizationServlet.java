package servlets;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import webSockets.AuthorizationSocket;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AuthorizationServlet", urlPatterns = {"/signin"})
public class AuthorizationServlet extends WebSocketServlet {
    private static final int LOGOUT_TIME = 1 * 60 * 1000;

    public AuthorizationServlet() {

    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, res) -> new AuthorizationSocket());

    }

}
