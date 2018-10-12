package ivc.uty.utils.ws;

import ivc.uty.model.entities.SprUsers;
import ivc.uty.utils.json.SendMyData;
import ivc.uty.view.start.StChart;

import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.*;

import static ivc.uty.utils.ws.WsServerConfigurator.hs;
import static ivc.uty.view.start.Start.sessionTimeoutFromWebXml;

@ServerEndpoint(value = "/ws", configurator = WsServerConfigurator.class)
public class WSServerEndpoint {
    public static final Set<Session> armUsers = Collections.synchronizedSet(new HashSet<Session>());
    public static final Map<Session, HttpSession> usersSession = new HashMap<>();
    public static Map<String, String> usersData = new HashMap<>();
    public static Map<String,Session> uS = new HashMap<>();

    @OnOpen

    public void onOpen(EndpointConfig endpointConfig, Session userSession) {
        userSession.getUserProperties().put("usrSession", endpointConfig.getUserProperties().get("usrSession"));
        armUsers.add(userSession);
        uS.put(String.valueOf(userSession.getUserProperties().get("user")),userSession);
        System.out.println("Client is connected...");
        System.out.println(armUsers.size());
        StChart stChart = new StChart();
        try {
            stChart.sendChartWithStart();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session userSession) {
//idSt|user
        String[] str = message.split("\u0003");
        if (str[0].equals("idSt")) {
            SendMyData smd = new SendMyData();
            String[] s = str[1].split("\\|");

            usersData.remove(s[1]);
            usersData.put(s[1], s[0]);

            smd.getMyStDatas(s[0], s[1]);
        }
        if (str[0].equals("sessions")) {
            usersSession.put(userSession, hs);
        }
    }

    @OnClose
    public void onClose(Session userSession) {
        System.out.println("Client is disconnected...");
        armUsers.remove(userSession);
        usersData.remove(userSession.getUserProperties().get("user"));
        uS.remove(userSession.getUserProperties().get("user"));
        System.out.println(armUsers.size());
    }

    @OnError
    public void onError(Throwable t) {

    }

    public void prolongSess(Session userSession) {
        if (usersSession.containsKey(userSession)) {
            usersSession.get(userSession).setMaxInactiveInterval(Integer.parseInt(sessionTimeoutFromWebXml.trim()) * 60);
        }
    }
}
