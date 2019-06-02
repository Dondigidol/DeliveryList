package webSockets;

import interfaces.ADService;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import services.ADServiceImpl;

import java.io.IOException;

@WebSocket
public class AuthorizationSocket {
    private Session session;
    private ADService adService;

    public AuthorizationSocket() {
        this.adService = new ADServiceImpl();
    }

    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.session = session;
        System.out.println(session.getRemoteAddress().getHostString() + " connected");
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
        String login = data.split(":")[0];
        String password = data.split(":")[1];
        try {
            adService.setLogin(login);
            adService.setPassword(password);
            adService.serviceInitialization();
            sendMessage("OK");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            sendMessage("Login or password is wrong!");
        }

    }

    @OnWebSocketClose
    public void onClose(int StatusCode, String reason) {
        System.out.println(session.getRemoteAddress().getHostString() + " closed");
    }

    public void sendMessage(String data) {
        try {
            session.getRemote().sendString(data);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    @OnWebSocketError
    public void onError(Throwable error) {
        System.out.println(session.getRemoteAddress().getHostName() + ": " + error.getLocalizedMessage());
    }





}
