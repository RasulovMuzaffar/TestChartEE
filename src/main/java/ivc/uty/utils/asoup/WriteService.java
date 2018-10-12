package ivc.uty.utils.asoup;

import ivc.uty.model.bean.MyBeanInterface;
import ivc.uty.model.entities.Stations;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ivc.uty.utils.asoup.ReadService.iters;

public class WriteService extends Thread {
    private static final String OUT_PATH = "C:\\soob\\out";

    private InitialContext ctx;
    private MyBeanInterface mbi;


    private List<RequestDatas> list;

    public List<RequestDatas> getList() {
        return list;
    }

    public void setList(List<RequestDatas> list) {
        this.list = list;
    }


    @Override
    public void run() {
        setRequestDatas();
        writeToPath();
    }

    private void setRequestDatas() {
        try {
            ctx = new InitialContext();
            mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        List<RequestDatas> l = new LinkedList<>();
        for (Stations s : mbi.findAllStations()) {
//            if (s.getId() == 7200) {
            l.add(new RequestDatas(s.getId() + "gr120", "(:212 0 " + s.getId() + " 29 0:5065 20 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr140", "(:212 0 " + s.getId() + " 29 0:5065 40 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr160", "(:212 0 " + s.getId() + " 29 0:5065 60 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr170", "(:212 0 " + s.getId() + " 29 0:5065 70 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr190", "(:212 0 " + s.getId() + " 29 0:5065 90 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr1", "(:212 0 " + s.getId() + " 29 0:5065 0 гр:)"));
            l.add(new RequestDatas(s.getId() + "por120", "(:212 0 " + s.getId() + " 29 0:5065 20 пор:)"));
            l.add(new RequestDatas(s.getId() + "por140", "(:212 0 " + s.getId() + " 29 0:5065 40 пор:)"));
            l.add(new RequestDatas(s.getId() + "por160", "(:212 0 " + s.getId() + " 29 0:5065 60 пор:)"));
            l.add(new RequestDatas(s.getId() + "por170", "(:212 0 " + s.getId() + " 29 0:5065 70 пор:)"));
            l.add(new RequestDatas(s.getId() + "por190", "(:212 0 " + s.getId() + " 29 0:5065 90 пор:)"));
            l.add(new RequestDatas(s.getId() + "por1", "(:212 0 " + s.getId() + " 29 0:5065 0 пор:)"));
            l.add(new RequestDatas(s.getId() + "gr220", "(:212 0 " + s.getId() + ":5065 20 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr240", "(:212 0 " + s.getId() + ":5065 40 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr260", "(:212 0 " + s.getId() + ":5065 60 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr270", "(:212 0 " + s.getId() + ":5065 70 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr290", "(:212 0 " + s.getId() + ":5065 90 гр:)"));
            l.add(new RequestDatas(s.getId() + "gr2", "(:212 0 " + s.getId() + ":5065 0 гр:)"));
            l.add(new RequestDatas(s.getId() + "por220", "(:212 0 " + s.getId() + ":5065 20 пор:)"));
            l.add(new RequestDatas(s.getId() + "por240", "(:212 0 " + s.getId() + ":5065 40 пор:)"));
            l.add(new RequestDatas(s.getId() + "por260", "(:212 0 " + s.getId() + ":5065 60 пор:)"));
            l.add(new RequestDatas(s.getId() + "por270", "(:212 0 " + s.getId() + ":5065 70 пор:)"));
            l.add(new RequestDatas(s.getId() + "por290", "(:212 0 " + s.getId() + ":5065 90 пор:)"));
            l.add(new RequestDatas(s.getId() + "por2", "(:212 0 " + s.getId() + ":5065 0 пор:)"));
//            }
        }
        setList(l);
    }

    private void writeToPath() {
//        try {
//            ctx = new InitialContext();
//            mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
//                System.out.println(">>>>>>>>> " + getList().size());
                for (Stations s : mbi.findAllStations()) {
                    writeToPathService(s.getId() + "gr120", "(:212 0 " + s.getId() + " 29 0:5065 20 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr140", "(:212 0 " + s.getId() + " 29 0:5065 40 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr160", "(:212 0 " + s.getId() + " 29 0:5065 60 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr170", "(:212 0 " + s.getId() + " 29 0:5065 70 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr190", "(:212 0 " + s.getId() + " 29 0:5065 90 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr1", "(:212 0 " + s.getId() + " 29 0:5065 0 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "por120", "(:212 0 " + s.getId() + " 29 0:5065 20 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por140", "(:212 0 " + s.getId() + " 29 0:5065 40 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por160", "(:212 0 " + s.getId() + " 29 0:5065 60 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por170", "(:212 0 " + s.getId() + " 29 0:5065 70 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por190", "(:212 0 " + s.getId() + " 29 0:5065 90 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por1", "(:212 0 " + s.getId() + " 29 0:5065 0 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr220", "(:212 0 " + s.getId() + ":5065 20 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr240", "(:212 0 " + s.getId() + ":5065 40 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr260", "(:212 0 " + s.getId() + ":5065 60 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr270", "(:212 0 " + s.getId() + ":5065 70 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr290", "(:212 0 " + s.getId() + ":5065 90 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "gr2", "(:212 0 " + s.getId() + ":5065 0 гр:)");
                    holdMess();
                    writeToPathService(s.getId() + "por220", "(:212 0 " + s.getId() + ":5065 20 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por240", "(:212 0 " + s.getId() + ":5065 40 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por260", "(:212 0 " + s.getId() + ":5065 60 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por270", "(:212 0 " + s.getId() + ":5065 70 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por290", "(:212 0 " + s.getId() + ":5065 90 пор:)");
                    holdMess();
                    writeToPathService(s.getId() + "por2", "(:212 0 " + s.getId() + ":5065 0 пор:)");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ie) {
                        Logger.getLogger(WriteService.class.getName()).log(Level.SEVERE, null, ie);
                    }
                }
//                for (RequestDatas rd : getList()) {
//                    writeToPathService(rd.getSprName(), rd.getSprData());
//                }

//                writeToPathService("5065gr120", "(:212 0 7200 29 0:5065 20 гр:)");
//                writeToPathService("5065gr140", "(:212 0 7200 29 0:5065 40 гр:)");
//                writeToPathService("5065gr160", "(:212 0 7200 29 0:5065 60 гр:)");
//                writeToPathService("5065gr170", "(:212 0 7200 29 0:5065 70 гр:)");
//                writeToPathService("5065gr190", "(:212 0 7200 29 0:5065 90 гр:)");
//                writeToPathService("5065gr1", "(:212 0 7200 29 0:5065 0 гр:)");
//                writeToPathService("5065por120", "(:212 0 7200 29 0:5065 20 пор:)");
//                writeToPathService("5065por140", "(:212 0 7200 29 0:5065 40 пор:)");
//                writeToPathService("5065por160", "(:212 0 7200 29 0:5065 60 пор:)");
//                writeToPathService("5065por170", "(:212 0 7200 29 0:5065 70 пор:)");
//                writeToPathService("5065por190", "(:212 0 7200 29 0:5065 90 пор:)");
//                writeToPathService("5065por1", "(:212 0 7200 29 0:5065 0 пор:)");
//                writeToPathService("5065gr220", "(:212 0 7200:5065 20 гр:)");
//                writeToPathService("5065gr240", "(:212 0 7200:5065 40 гр:)");
//                writeToPathService("5065gr260", "(:212 0 7200:5065 60 гр:)");
//                writeToPathService("5065gr270", "(:212 0 7200:5065 70 гр:)");
//                writeToPathService("5065gr290", "(:212 0 7200:5065 90 гр:)");
//                writeToPathService("5065gr2", "(:212 0 7200:5065 0 гр:)");
//                writeToPathService("5065por220", "(:212 0 7200:5065 20 пор:)");
//                writeToPathService("5065por240", "(:212 0 7200:5065 40 пор:)");
//                writeToPathService("5065por260", "(:212 0 7200:5065 60 пор:)");
//                writeToPathService("5065por270", "(:212 0 7200:5065 70 пор:)");
//                writeToPathService("5065por290", "(:212 0 7200:5065 90 пор:)");
//                writeToPathService("5065por2", "(:212 0 7200:5065 0 пор:)");
//                iters=0;
            }
        }, 0, 15, TimeUnit.MINUTES);
    }

    private void holdMess() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            Logger.getLogger(WriteService.class.getName()).log(Level.SEVERE, "hold Messages", ie);
        }
    }

    private void writeToPathService(final String spr, final String data) {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.schedule(new Runnable() {
            @Override
            public void run() {
                initFile(spr, data);
            }
        }, 1, TimeUnit.SECONDS);
    }

    private void initFile(String spr, String data) {
        try (OutputStream outputStream = new FileOutputStream(OUT_PATH + "\\0106a0" + spr);
             Writer outputStreamWriter = new OutputStreamWriter(outputStream, "Cp866");) {
            outputStreamWriter.write(data);
            System.out.println("file is created >> " + data + " >>> created date " + new Date());

//            WSServerEndpoint.armUsers.stream().forEach(x->{
//                try {
//                    x.getBasicRemote().sendObject(tblDao.findLast24HDatas().get(0));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (EncodeException e) {
//                    e.printStackTrace();
//                }
//            });
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WriteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
