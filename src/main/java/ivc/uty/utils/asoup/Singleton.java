package ivc.uty.utils.asoup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Singleton {
    private static volatile Singleton ourInstance;

    private Singleton() {
    }

    public static void getOurInstance() {
        System.out.println(" ----------------------------------------- com.Singleton.getOurInstance() Start");
        if (ourInstance == null) {
            ourInstance = new Singleton();
            System.out.println("im in singleton!!!");
//            WriteService writeService = new WriteService();
//            writeService.start();
            ReadService readService = new ReadService();
            readService.start();
            gt();
        }
        System.out.println(" ----------------------------------------- com.Singleton.getOurInstance() End ");
    }

    private static void gt() {
        Calendar cur = Calendar.getInstance();
        SimpleDateFormat sdfH = new SimpleDateFormat("HH");
        SimpleDateFormat sdfM = new SimpleDateFormat("mm");
        int h = Integer.parseInt(sdfH.format(cur.getTime()));
        int m = Integer.parseInt(sdfM.format(cur.getTime()));


        int interval = 15;
        if (m < 46) {
            int d = m % interval;
            cur.set(Calendar.HOUR_OF_DAY, h);
            cur.set(Calendar.MINUTE, m + interval - d - 1);
            cur.set(Calendar.SECOND, 0);
        } else {
            cur.set(Calendar.HOUR_OF_DAY, h + 1);
            cur.set(Calendar.MINUTE, 0);
            cur.set(Calendar.SECOND, 0);
        }

//        cur.set(Calendar.HOUR_OF_DAY,7);
//        cur.set(Calendar.MINUTE, 48);
//        cur.set(Calendar.SECOND, 0);
        Date startTime = cur.getTime();
        System.out.println(startTime);
//        Timer t = new Timer();
//        t.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("im in gt!!!");
////                Singleton.getOurInstance();
//                startingService();
//            }
//        }, startTime);

        final ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> {
            startingService();
        }, startTime.getTime() - new Date().getTime(), MILLISECONDS);
    }

    private static void startingService() {
        WriteService writeService = new WriteService();
        writeService.start();
    }
}
