package ivc.uty.utils.asoup;

import ivc.uty.model.bean.MyBeanInterface;
import ivc.uty.model.entities.SprUsers;
import ivc.uty.model.entities.Stations;
import ivc.uty.model.entities.Tbl5065;
import ivc.uty.utils.json.ConvertJson;
import ivc.uty.utils.ws.WSServerEndpoint;

import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ivc.uty.utils.ws.WSServerEndpoint.uS;
import static ivc.uty.utils.ws.WSServerEndpoint.usersData;

@Named
//@ManagedBean
public class ReadService extends Thread {

//    @Inject
//    private MyBeanInterface mbi;

    private static final String IN_PATH = "C:\\soob\\in";

//    public static int amountUTYGr = 0;
//    public static int amountUTYGrKR20 = 0;
//    public static int amountUTYGrPl40 = 0;
//    public static int amountUTYGrPv60 = 0;
//    public static int amountUTYGrCs70 = 0;
//    public static int amountUTYGrPr90 = 0;
//    public static int amountUTYGrDr = 0;
//    public static int amountUTYPor = 0;
//    public static int amountUTYPorKr20 = 0;
//    public static int amountUTYPorPl40 = 0;
//    public static int amountUTYPorPv60 = 0;
//    public static int amountUTYPorCs70 = 0;
//    public static int amountUTYPorPr90 = 0;
//    public static int amountUTYPorDr = 0;
//    public static int amountOtherGr = 0;
//    public static int amountOtherGrKR20 = 0;
//    public static int amountOtherGrPl40 = 0;
//    public static int amountOtherGrPv60 = 0;
//    public static int amountOtherGrCs70 = 0;
//    public static int amountOtherGrPr90 = 0;
//    public static int amountOtherGrDr = 0;
//    public static int amountOtherPor = 0;
//    public static int amountOtherPorKR20 = 0;
//    public static int amountOtherPorPl40 = 0;
//    public static int amountOtherPorPv60 = 0;
//    public static int amountOtherPorCs70 = 0;
//    public static int amountOtherPorPr90 = 0;
//    public static int amountOtherPorDr = 0;

    public static int iters = 0;

    public static Map<String, Integer> mapDatas = new HashMap<>();

    private InitialContext ctx;
    private MyBeanInterface mbi;

    public void run() {
        System.out.println("im in READSERVICE!!!!!");
        try {
            ctx = new InitialContext();
            mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        readInPath();
    }

    private void readInPath() {
        System.out.println("im in readInPath!!!");
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Map<WatchKey, Path> keyMap = new HashMap<>();
            Path path = Paths.get(IN_PATH);

            keyMap.put(path.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE
            ), path);

            WatchKey watchKey;
            do {
                watchKey = service.take();
                final Path eventDir = keyMap.get(watchKey);

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    final Path eventPath = (Path) event.context();
                    File f = new File(eventDir + "\\" + eventPath);

                    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
                    ses.schedule(new Runnable() {
                        @Override
                        public void run() {
                            readFile(eventDir + "\\" + eventPath, "" + eventPath);
                        }
                    }, 1000, TimeUnit.MILLISECONDS);
                }
            } while (watchKey.reset());
        } catch (Exception e) {
            try {
                throw new Exception("непонятная ошибка!!!");
            } catch (Exception ex) {
                Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void readFile(String path, String fileName) {
        if (fileName.substring(0, 4).equalsIgnoreCase("0106")) {
            String str = "";

            StringBuilder sb = new StringBuilder();
            try {
//                System.out.println(path);
                Files.lines(Paths.get(path), Charset.forName("cp866")).forEach((p)->sb.append("\r\n").append(p));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(sb.toString());

//            try (FileInputStream fis = new FileInputStream(path)) {
//
//                byte[] buffer = new byte[fis.available()];
//
////                 считаем файл в буфер
//                fis.read(buffer, 0, fis.available());
//
////                str = new String(new String(buffer,"cp866").getBytes(),"utf-8");
//                str = new String(new String(buffer, "cp1251").getBytes(), "cp866");
//
//            } catch (IOException ex) {
//                System.out.println("exception in ReadOnDir : " + ex);
//            }
            System.out.println("-----------------------------------------------------------------------------------");
            Spr5065 spr5065 = new Spr5065();
            if (spr5065.getData(sb.toString()) == true) {
                if (mapDatas.size() == 120) {
                    Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, "write data to db " + mapDatas.size());

                    for (Stations s : mbi.findAllStations()) {
                        try {
                            System.out.println("====================>>> " + s.getName());
                            Tbl5065 tbl5065 = new Tbl5065();

                            int amountUTYGr = mapDatas.get(s.getId() + "|amountUTYGr") != null ? mapDatas.get(s.getId() + "|amountUTYGr") : mapDatas.get(s.getId() + "|error");
                            int amountUTYGrKr20 = mapDatas.get(s.getId() + "|amountUTYGrKr20") != null ? mapDatas.get(s.getId() + "|amountUTYGrKr20") : mapDatas.get(s.getId() + "|error");
                            int amountUTYGrPl40 = mapDatas.get(s.getId() + "|amountUTYGrPl40") != null ? mapDatas.get(s.getId() + "|amountUTYGrPl40") : mapDatas.get(s.getId() + "|error");
                            int amountUTYGrPv60 = mapDatas.get(s.getId() + "|amountUTYGrPv60") != null ? mapDatas.get(s.getId() + "|amountUTYGrPv60") : mapDatas.get(s.getId() + "|error");
                            int amountUTYGrCs70 = mapDatas.get(s.getId() + "|amountUTYGrCs70") != null ? mapDatas.get(s.getId() + "|amountUTYGrCs70") : mapDatas.get(s.getId() + "|error");
                            int amountUTYGrPr90 = mapDatas.get(s.getId() + "|amountUTYGrPr90") != null ? mapDatas.get(s.getId() + "|amountUTYGrPr90") : mapDatas.get(s.getId() + "|error");
                            int amountUTYPor = mapDatas.get(s.getId() + "|amountUTYPor") != null ? mapDatas.get(s.getId() + "|amountUTYPor") : mapDatas.get(s.getId() + "|error");
                            int amountUTYPorKr20 = mapDatas.get(s.getId() + "|amountUTYPorKr20") != null ? mapDatas.get(s.getId() + "|amountUTYPorKr20") : mapDatas.get(s.getId() + "|error");
                            int amountUTYPorPl40 = mapDatas.get(s.getId() + "|amountUTYPorPl40") != null ? mapDatas.get(s.getId() + "|amountUTYPorPl40") : mapDatas.get(s.getId() + "|error");
                            int amountUTYPorPv60 = mapDatas.get(s.getId() + "|amountUTYPorPv60") != null ? mapDatas.get(s.getId() + "|amountUTYPorPv60") : mapDatas.get(s.getId() + "|error");
                            int amountUTYPorCs70 = mapDatas.get(s.getId() + "|amountUTYPorCs70") != null ? mapDatas.get(s.getId() + "|amountUTYPorCs70") : mapDatas.get(s.getId() + "|error");
                            int amountUTYPorPr90 = mapDatas.get(s.getId() + "|amountUTYPorPr90") != null ? mapDatas.get(s.getId() + "|amountUTYPorPr90") : mapDatas.get(s.getId() + "|error");
                            int amountOtherGr = mapDatas.get(s.getId() + "|amountOtherGr") != null ? mapDatas.get(s.getId() + "|amountOtherGr") : mapDatas.get(s.getId() + "|error");
                            int amountOtherGrKr20 = mapDatas.get(s.getId() + "|amountOtherGrKr20") != null ? mapDatas.get(s.getId() + "|amountOtherGrKr20") : mapDatas.get(s.getId() + "|error");
                            int amountOtherGrPl40 = mapDatas.get(s.getId() + "|amountOtherGrPl40") != null ? mapDatas.get(s.getId() + "|amountOtherGrPl40") : mapDatas.get(s.getId() + "|error");
                            int amountOtherGrPv60 = mapDatas.get(s.getId() + "|amountOtherGrPv60") != null ? mapDatas.get(s.getId() + "|amountOtherGrPv60") : mapDatas.get(s.getId() + "|error");
                            int amountOtherGrCs70 = mapDatas.get(s.getId() + "|amountOtherGrCs70") != null ? mapDatas.get(s.getId() + "|amountOtherGrCs70") : mapDatas.get(s.getId() + "|error");
                            int amountOtherGrPr90 = mapDatas.get(s.getId() + "|amountOtherGrPr90") != null ? mapDatas.get(s.getId() + "|amountOtherGrPr90") : mapDatas.get(s.getId() + "|error");
                            int amountOtherPor = mapDatas.get(s.getId() + "|amountOtherPor") != null ? mapDatas.get(s.getId() + "|amountOtherPor") : mapDatas.get(s.getId() + "|error");
                            int amountOtherPorKr20 = mapDatas.get(s.getId() + "|amountOtherPorKr20") != null ? mapDatas.get(s.getId() + "|amountOtherPorKr20") : mapDatas.get(s.getId() + "|error");
                            int amountOtherPorPl40 = mapDatas.get(s.getId() + "|amountOtherPorPl40") != null ? mapDatas.get(s.getId() + "|amountOtherPorPl40") : mapDatas.get(s.getId() + "|error");
                            int amountOtherPorPv60 = mapDatas.get(s.getId() + "|amountOtherPorPv60") != null ? mapDatas.get(s.getId() + "|amountOtherPorPv60") : mapDatas.get(s.getId() + "|error");
                            int amountOtherPorCs70 = mapDatas.get(s.getId() + "|amountOtherPorCs70") != null ? mapDatas.get(s.getId() + "|amountOtherPorCs70") : mapDatas.get(s.getId() + "|error");
                            int amountOtherPorPr90 = mapDatas.get(s.getId() + "|amountOtherPorPr90") != null ? mapDatas.get(s.getId() + "|amountOtherPorPr90") : mapDatas.get(s.getId() + "|error");

                            tbl5065.setGruty(amountUTYGr);
                            tbl5065.setGrutykr(amountUTYGrKr20);
                            tbl5065.setGrutypl(amountUTYGrPl40);
                            tbl5065.setGrutypv(amountUTYGrPv60);
                            tbl5065.setGrutycs(amountUTYGrCs70);
                            tbl5065.setGrutypr(amountUTYGrPr90);

                            int grutydr = amountUTYGr - amountUTYGrKr20 - amountUTYGrPl40 -
                                    amountUTYGrPv60 - amountUTYGrCs70 - amountUTYGrPr90;
                            tbl5065.setGrutydr(grutydr);

                            tbl5065.setPoruty(amountUTYPor);
                            tbl5065.setPorutykr(amountUTYPorKr20);
                            tbl5065.setPorutypl(amountUTYPorPl40);
                            tbl5065.setPorutypv(amountUTYPorPv60);
                            tbl5065.setPorutycs(amountUTYPorCs70);
                            tbl5065.setPorutypr(amountUTYPorPr90);
                            int porutydr = amountUTYPor - amountUTYPorKr20 - amountUTYPorPl40 -
                                    amountUTYPorPv60 - amountUTYPorCs70 - amountUTYPorPr90;
                            tbl5065.setPorutydr(porutydr);

                            tbl5065.setSummuty(amountUTYGr + amountUTYPor);


                            tbl5065.setGrchuj(amountOtherGr);
                            tbl5065.setGrchujkr(amountOtherGrKr20);
                            tbl5065.setGrchujpl(amountOtherGrPl40);
                            tbl5065.setGrchujpv(amountOtherGrPv60);
                            tbl5065.setGrchujcs(amountOtherGrCs70);
                            tbl5065.setGrchujpr(amountOtherGrPr90);
                            int grchujdr = amountOtherGr - amountOtherGrKr20 - amountOtherGrPl40 -
                                    amountOtherGrPv60 - amountOtherGrCs70 - amountOtherGrPr90;
                            tbl5065.setGrchujdr(grchujdr);

                            tbl5065.setPorchuj(amountOtherPor);
                            tbl5065.setPorchujkr(amountOtherPorKr20);
                            tbl5065.setPorchujpl(amountOtherPorPl40);
                            tbl5065.setPorchujpv(amountOtherPorPv60);
                            tbl5065.setPorchujcs(amountOtherPorCs70);
                            tbl5065.setPorchujpr(amountOtherPorPr90);
                            int porchujdr = amountOtherPor - amountOtherPorKr20 - amountOtherPorPl40 -
                                    amountOtherPorPv60 - amountOtherPorCs70 - amountOtherPorPr90;
                            tbl5065.setPorchujdr(porchujdr);

                            tbl5065.setSummchuj(amountOtherGr + amountOtherPor);
//                        System.out.println("mapDatas.get(st)>>> " + mapDatas.get("st"));

//                    try {
//                        ctx = new InitialContext();
//                        mbi = (MyBeanInterface) ctx.lookup("java:global/projectChart/myBean");

                            tbl5065.setStation(s);

                            mbi.save(tbl5065);

                            ConvertJson convertJson = new ConvertJson();
                            WSServerEndpoint wsse = new WSServerEndpoint();

                            for (Map.Entry<String, String> m : usersData.entrySet()) {
                                String jsonStr = convertJson.convertData(mbi.findLast24HDatas(Integer.parseInt(m.getValue())));
                                SprUsers user = mbi.findUserByLogin(m.getKey());

                                if (s.getId() == Integer.parseInt(m.getValue())) {
                                    uS.get(m.getKey()).getBasicRemote().sendText(jsonStr);
                                    wsse.prolongSess(uS.get(m.getKey()));
                                }
                            }
//                            WSServerEndpoint.armUsers.stream().forEach(x -> {
//                                for (Map.Entry<String, String> m : usersData.entrySet()) {
//                                    String jsonStr = convertJson.convertData(mbi.findLast24HDatas(Integer.parseInt(m.getValue())));
//                                    SprUsers user = mbi.findUserByLogin(m.getKey());
//
//                                    System.out.println(")))))))))))))) "+x.getUserProperties().size());
//                                    if (x.getUserProperties().containsValue(user)) {
//                                        try {
//                                            x.getBasicRemote().sendText(jsonStr);
////                wsse.prolongSess(x);
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//
//                                }
//                            });
//                    } catch (NamingException e) {
//                        Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, null, e);
//                    }
//                            try {
//                                Thread.sleep(1000);
//                            } catch (Exception e) {
//                            }
//                            Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, "STATION " + s.getName());
                        } catch (Exception e) {
                            Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, "STATION " + s.getName(), e);
                        }
                    }
                    System.out.println("BEFORE CLEAR---->>> " + mapDatas.size());
                    mapDatas.clear();
                    System.out.println("AFTER CLEAR---->>> " + mapDatas.size());
                    try {
                        deleteAllFilesFolder(IN_PATH);
                    } catch (Exception e) {
                        Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, "Files deleting exception ", e);
                    }
                }
            }
        }
    }

    public static void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) {
                myFile.delete();
//                try {
//                    if (Files.deleteIfExists(Paths.get(path)))
//                        System.out.println("file is deleted!");
//                } catch (IOException e) {
//                    Logger.getLogger(ReadService.class.getName()).log(Level.SEVERE, null, e);
//                }
            }
    }
}
