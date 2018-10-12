package ivc.uty.utils.ws;

import ivc.uty.model.entities.SprUsers;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class WsServerConfigurator extends ServerEndpointConfig.Configurator {
    public static HttpSession hs;

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession session = (HttpSession) request.getHttpSession();
        SprUsers u = (SprUsers) session.getAttribute("user");
        hs = session;
        sec.getUserProperties().put("usrSession", u);
        sec.getUserProperties().put("user", u.getLogin());
//        sec.getUserProperties().put("usrSession", session);
    }
}
