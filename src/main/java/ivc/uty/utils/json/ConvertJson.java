package ivc.uty.utils.json;

import ivc.uty.model.bean.MyBeanInterface;
import ivc.uty.model.entities.SprUsers;
import ivc.uty.model.entities.Tbl5065;
import ivc.uty.utils.ws.WSServerEndpoint;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ConvertJson {

    InitialContext ctx;
    MyBeanInterface mbi;

    public String convertData(List<Tbl5065> list) {
        try {
            ctx = new InitialContext();
            mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        JSONArray array = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        for (Tbl5065 t : list) {
            JSONObject object = new JSONObject();
            object.put("id", t.getId());
            object.put("gruty", t.getGruty());
            object.put("grutykr", t.getGrutykr());
            object.put("grutypl", t.getGrutypl());
            object.put("grutypv", t.getGrutypv());
            object.put("grutycs", t.getGrutycs());
            object.put("grutypr", t.getGrutypr());
            object.put("grutydr", t.getGrutydr());

            object.put("poruty", t.getPoruty());
            object.put("porutykr", t.getPorutykr());
            object.put("porutypl", t.getPorutypl());
            object.put("porutypv", t.getPorutypv());
            object.put("porutycs", t.getPorutycs());
            object.put("porutypr", t.getPorutypr());
            object.put("porutydr", t.getPorutydr());

            object.put("summuty", t.getSummuty());

            object.put("grchuj", t.getGrchuj());
            object.put("grchujkr", t.getGrchujkr());
            object.put("grchujpl", t.getGrchujpl());
            object.put("grchujpv", t.getGrchujpv());
            object.put("grchujcs", t.getGrchujcs());
            object.put("grchujpr", t.getGrchujpr());
            object.put("grchujdr", t.getGrchujdr());

            object.put("porchuj", t.getPorchuj());
            object.put("porchujkr", t.getPorchujkr());
            object.put("porchujpl", t.getPorchujpl());
            object.put("porchujpv", t.getPorchujpv());
            object.put("porchujcs", t.getPorchujcs());
            object.put("porchujpr", t.getPorchujpr());
            object.put("porchujdr", t.getPorchujdr());

            object.put("summchuj", t.getSummchuj());
            object.put("upddate", sdf.format(t.getUpddate()));
            array.add(object);
        }
        return array.toJSONString();
//        SprUsers u = mbi.findUserByLoginPass();

//        WSServerEndpoint wsse = new WSServerEndpoint();
//        WSServerEndpoint.armUsers.stream().forEach(x -> {
//            System.out.println(x.getUserProperties().size());
//            try {
//                x.getBasicRemote().sendText(array.toJSONString());
////                wsse.prolongSess(x);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
