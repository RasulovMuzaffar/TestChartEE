package ivc.uty.view.start;

import ivc.uty.model.bean.MyBeanInterface;
import ivc.uty.utils.json.ConvertJson;
import ivc.uty.utils.ws.WSServerEndpoint;

import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ivc.uty.utils.ws.WSServerEndpoint.usersSession;


@Named
public class StChart {

    //    @EJB(lookup = "java:module/myBean")
//    @Inject
//    private MyBeanInterface mbi;
    public void sendChartWithStart() throws NamingException {
        Logger.getLogger(StChart.class.getName()).log(Level.SEVERE, "ststst");
        InitialContext ctx = new InitialContext();
        MyBeanInterface mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
//        System.out.println("stchart>> " + mbi);

        ConvertJson convertJson = new ConvertJson();
        String jsonStr = convertJson.convertData(mbi.findLast24HDatas(7200));

//        WSServerEndpoint wsse = new WSServerEndpoint();
//
//        WSServerEndpoint.armUsers.stream().forEach(x -> {
////            System.out.println(x.getUserProperties().size());
////            System.out.println("+++++++++++++++++++++++ "+x.getUserProperties().get("usrSession"));
////            System.out.println("********************** "+usersSession.get(x.getUserProperties().get("usrSession")));
//            try {
//                x.getBasicRemote().sendText(jsonStr);
//                wsse.prolongSess(x);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
