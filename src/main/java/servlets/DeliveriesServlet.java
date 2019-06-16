package servlets;

import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import webSockets.DeliveriesSocket;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DeliveriesServlet", urlPatterns = "{/deliveries}")
public class DeliveriesServlet extends WebSocketServlet {
    private static final int LOGOUT_TIME = 10 * 60 * 1000;

    public DeliveriesServlet() {

    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.setCreator((req, res) -> new DeliveriesSocket());
    }

}
