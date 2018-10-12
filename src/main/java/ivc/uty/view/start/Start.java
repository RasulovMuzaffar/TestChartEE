package ivc.uty.view.start;


import ivc.uty.model.bean.MyBeanInterface;
import ivc.uty.model.entities.SprUsers;
import ivc.uty.model.entities.Surfing;
import ivc.uty.utils.asoup.Singleton;
import org.xml.sax.SAXException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

@WebServlet(name = "Start", urlPatterns = "/start")
public class Start extends HttpServlet {
    public static String sessionTimeoutFromWebXml;
    private InitialContext ctx;
    private MyBeanInterface mbi;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user");
        String password = request.getParameter("password");
        try {
            ctx = new InitialContext();
            mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        SprUsers user = mbi.findUserByLoginPass(login, password);
        if (user != null) {
//        Logger.getLogger(Start.class.getName()).log(Level.SEVERE, "asdasd");
            try {
                sessionTimeoutFromWebXml = XPathFactory.newInstance().newXPath().compile("web-app/session-config/session-timeout").evaluate(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getServletContext().getResourceAsStream("/WEB-INF/web.xml")));
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

            Surfing surfing = new Surfing();
            surfing.setUser(user);
            surfing.setIp(request.getRemoteAddr());
            mbi.save(surfing);

            request.getSession().setAttribute("user", user);
            request.setAttribute("stations", mbi.findAllStations());
            Singleton.getOurInstance();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }
}
