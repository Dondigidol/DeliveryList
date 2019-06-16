package webSockets;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

public class DeliveriesSocket {
    private Session session;

    public DeliveriesSocket() {

    }

    @OnWebSocketConnect
    public void onOpen() {

    }

    @OnWebSocketMessage
    public void onMessage() {

    }

    @OnWebSocketClose
    public void onClose() {

    }

    @OnWebSocketError
    public void onError() {

    }

}
