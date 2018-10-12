package ivc.uty.utils.json;

import ivc.uty.model.bean.MyBeanInterface;
import ivc.uty.model.entities.SprUsers;
import ivc.uty.utils.ws.WSServerEndpoint;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

import static ivc.uty.utils.ws.WSServerEndpoint.usersSession;

public class SendMyData {
    private InitialContext ctx;
    private MyBeanInterface mbi;

    public void getMyStDatas(String stId, String login) {
        System.out.println("getMyStDatas(String stId, String login) " + stId + " " + login);
        try {
            ctx = new InitialContext();
            mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        WSServerEndpoint wsse = new WSServerEndpoint();

        SprUsers user = mbi.findUserByLogin(login);
        ConvertJson convertJson = new ConvertJson();
        String data = convertJson.convertData(mbi.findLast24HDatas(Integer.parseInt(stId)));
        WSServerEndpoint.armUsers.stream().forEach(x -> {
            if (x.getUserProperties().containsValue(user)) {
                try {
                    x.getBasicRemote().sendText(data);
                    wsse.prolongSess(x);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
