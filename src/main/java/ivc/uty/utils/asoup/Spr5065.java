package ivc.uty.utils.asoup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ivc.uty.utils.asoup.ReadService.mapDatas;

public class Spr5065 {
    final static String RTH = "СОБСТВ-УТИ";
    final static String HEAD = "ПОНОМЕРНОЕ НАЛИЧИЕ ВАГОНОВ\\s+(?<st>[A-ZА-Яa-zа-я]{3,10})";
    final static String RTHGR = "СОСТ=ГР";
    final static String RTHPOR = "СОСТ=ПОР";
    final static String BODY = "ИТОГО :КОЛИЧЕСТВО ВАГОНОВ =(?<amount>\\d{0,5})";
    final static String KR = "(20)";
    final static String PL = "(40)";
    final static String PV = "(60)";
    final static String CS = "(70)";
    final static String PR = "(90)";

    final static String CHUKUR = "чукурсай";
    final static String XAVAST = "хаваст";
    final static String BUXARA = "бухара";
    final static String KARSHI = "карши";
    final static String KOKAND = "коканд";

    final static String ERR_MESS = "(?<st>\\d{4}):\\s+Ю2";

    final static String FTG = "(96)";
    final static String ZRV = "(95)";

    protected boolean getData(String text) {
        System.out.println("im in SPR5065!!");
        String str = TextReplace.getReplace(text);
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(BODY);
        matcher = pattern.matcher(str);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(str);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        setMapDatas(str);

        /*
         * ERROR MESSAGE
         * */
//        if (str.contains("Ю2")) {
        Pattern pattern1;
        Matcher matcher1;
        pattern1 = Pattern.compile(ERR_MESS);
        matcher1 = pattern1.matcher(str);
        while (matcher1.find()) {
            mapDatas.put(matcher1.group("st") + "|error", 0);
            return true;
        }
//        }

        /*
         * СОБСТВ-УТИ
         * СОСТ=ГР
         * */
        if (str.contains(RTH) && str.contains(RTHGR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))) {
//            System.out.println("str.contains(RTH) && str.contains(RTHGR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))");
//            ReadService.amountUTYGr = -1;
            int amountUtyGr = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYGr = Integer.parseInt(matcher.group("amount"));
//                }
                amountUtyGr = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYGr", amountUtyGr);
//            System.out.println(ReadService.amountUTYGr);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ГР
         * 20
         * */
        if (str.contains(RTH) && str.contains(RTHGR) && str.contains(KR)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHGR) && str.contains(KR)");
//            ReadService.amountUTYGrKR20 = -1;
            int amountUTYGrKr20 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYGrKR20 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYGrKr20 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYGrKr20", amountUTYGrKr20);
//            System.out.println(ReadService.amountUTYGrKR20);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ГР
         * 40
         * */
        if (str.contains(RTH) && str.contains(RTHGR) && str.contains(PL)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHGR) && str.contains(PL)");
//            ReadService.amountUTYGrPl40 = -1;
            int amountUTYGrPl40 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYGrPl40 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYGrPl40 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYGrPl40", amountUTYGrPl40);
//            System.out.println(ReadService.amountUTYGrPl40);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ГР
         * 60
         * */
        if (str.contains(RTH) && str.contains(RTHGR) && str.contains(PV)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHGR) && str.contains(PV)");
//            ReadService.amountUTYGrPv60 = -1;
            int amountUTYGrPv60 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYGrPv60 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYGrPv60 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYGrPv60", amountUTYGrPv60);
//            System.out.println(ReadService.amountUTYGrPv60);
//            ReadService.iters++;
            return true;
        }

        /*
         * СОБСТВ-УТИ
         * СОСТ=ГР
         * 70
         * */
        if (str.contains(RTH) && str.contains(RTHGR) && str.contains(CS)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHGR) && str.contains(CS)");
//            ReadService.amountUTYGrCs70 = -1;
            int amountUTYGrCs70 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYGrCs70 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYGrCs70 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYGrCs70", amountUTYGrCs70);
//            System.out.println(ReadService.amountUTYGrCs70);
//            ReadService.iters++;
            return true;
        }

        /*
         * СОБСТВ-УТИ
         * СОСТ=ГР
         * 90
         * */
        if (str.contains(RTH) && str.contains(RTHGR) && str.contains(PR)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHGR) && str.contains(PR)");
//            ReadService.amountUTYGrPr90 = -1;
            int amountUTYGrPr90 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYGrPr90 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYGrPr90 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYGrPr90", amountUTYGrPr90);
//            System.out.println(ReadService.amountUTYGrPr90);
//            ReadService.iters++;
            return true;
        }
        /////////////////////////////////////////////////////////////////////////////////
        /*
         * СОБСТВ-УТИ
         * СОСТ=ПОР
         * */
        if (str.contains(RTH) && str.contains(RTHPOR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))) {
//            System.out.println("str.contains(RTH) && str.contains(RTHPOR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))");
//            ReadService.amountUTYPor = -1;
            int amountUTYPor = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYPor = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYPor = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYPor", amountUTYPor);
//            System.out.println(ReadService.amountUTYPor);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ПОР
         * 20
         * */
        if (str.contains(RTH) && str.contains(RTHPOR) && str.contains(KR)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHPOR) && str.contains(KR)");
//            ReadService.amountUTYPorKR20 = -1;
            int amountUTYPorKr20 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYPorKR20 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYPorKr20 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYPorKr20", amountUTYPorKr20);
//            System.out.println(ReadService.amountUTYPorKR20);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ПОР
         * 40
         * */
        if (str.contains(RTH) && str.contains(RTHPOR) && str.contains(PL)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHPOR) && str.contains(PL)");
//            ReadService.amountUTYPorPl40 = -1;
            int amountUTYPorPl40 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYPorPl40 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYPorPl40 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYPorPl40", amountUTYPorPl40);
//            System.out.println(ReadService.amountUTYPorPl40);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ПОР
         * 60
         * */
        if (str.contains(RTH) && str.contains(RTHPOR) && str.contains(PV)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHPOR) && str.contains(PV)");
//            ReadService.amountUTYPorPv60 = -1;
            int amountUTYPorPv60 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYPorPv60 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYPorPv60 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYPorPv60", amountUTYPorPv60);
//            System.out.println(ReadService.amountUTYPorPv60);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ПОР
         * 70
         * */
        if (str.contains(RTH) && str.contains(RTHPOR) && str.contains(CS)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHPOR) && str.contains(CS)");
//            ReadService.amountUTYPorCs70 = -1;
            int amountUTYPorCs70 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYPorCs70 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYPorCs70 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYPorCs70", amountUTYPorCs70);
//            System.out.println(ReadService.amountUTYPorCs70);
//            ReadService.iters++;
            return true;
        }
        /*
         * СОБСТВ-УТИ
         * СОСТ=ПОР
         * 90
         * */
        if (str.contains(RTH) && str.contains(RTHPOR) && str.contains(PR)) {
//            System.out.println("str.contains(RTH) && str.contains(RTHPOR) && str.contains(PR)");
//            ReadService.amountUTYPorPr90 = -1;
            int amountUTYPorPr90 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountUTYPorPr90 = Integer.parseInt(matcher.group("amount"));
//                }
                amountUTYPorPr90 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountUTYPorPr90", amountUTYPorPr90);
//            System.out.println(ReadService.amountUTYPorPr90);
//            ReadService.iters++;
            return true;
        }
        /////////////////////////////////////////////////////////////////////////////////
        /*
         * ЧУЖ
         * СОСТ=ГР
         * */
        if (!str.contains(RTH) && str.contains(RTHGR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHGR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))");
//            ReadService.amountOtherGr = -1;
            int amountOtherGr = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherGr = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherGr = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherGr", amountOtherGr);
//            System.out.println(ReadService.amountOtherGr);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ГР
         * 20
         * */
        if (!str.contains(RTH) && str.contains(RTHGR) && str.contains(KR)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHGR) && str.contains(KR)");
//            ReadService.amountOtherGrKR20 = -1;
            int amountOtherGrKr20 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherGrKR20 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherGrKr20 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherGrKr20", amountOtherGrKr20);
//            System.out.println(ReadService.amountOtherGrKR20);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ГР
         * 40
         * */
        if (!str.contains(RTH) && str.contains(RTHGR) && str.contains(PL)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHGR) && str.contains(PL)");
//            ReadService.amountOtherGrPl40 = -1;
            int amountOtherGrPl40 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherGrPl40 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherGrPl40 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherGrPl40", amountOtherGrPl40);
//            System.out.println(ReadService.amountOtherGrPl40);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ГР
         * 60
         * */
        if (!str.contains(RTH) && str.contains(RTHGR) && str.contains(PV)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHGR) && str.contains(PV)");
//            ReadService.amountOtherGrPv60 = -1;
            int amountOtherGrPv60 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherGrPv60 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherGrPv60 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherGrPv60", amountOtherGrPv60);
//            System.out.println(ReadService.amountOtherGrPv60);
//            ReadService.iters++;
            return true;
        }

        /*
         * ЧУЖ
         * СОСТ=ГР
         * 70
         * */
        if (!str.contains(RTH) && str.contains(RTHGR) && str.contains(CS)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHGR) && str.contains(CS)");
//            ReadService.amountOtherGrCs70 = -1;
            int amountOtherGrCs70 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherGrCs70 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherGrCs70 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherGrCs70", amountOtherGrCs70);
//            System.out.println(ReadService.amountOtherGrCs70);
//            ReadService.iters++;
            return true;
        }

        /*
         * ЧУЖ
         * СОСТ=ГР
         * 90
         * */
        if (!str.contains(RTH) && str.contains(RTHGR) && str.contains(PR)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHGR) && str.contains(PR)");
//            ReadService.amountOtherGrPr90 = -1;
            int amountOtherGrPr90 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherGrPr90 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherGrPr90 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherGrPr90", amountOtherGrPr90);
//            System.out.println(ReadService.amountOtherGrPr90);
//            ReadService.iters++;
            return true;
        }
        /////////////////////////////////////////////////////////////////////////////////
        /*
         * ЧУЖ
         * СОСТ=ПОР
         * */
        if (!str.contains(RTH) && str.contains(RTHPOR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHPOR) && !(str.contains(KR) || str.contains(PL) || str.contains(PV) || str.contains(CS) || str.contains(PR))");
//            ReadService.amountOtherPor = -1;
            int amountOtherPor = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherPor = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherPor = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherPor", amountOtherPor);
//            System.out.println(ReadService.amountOtherPor);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ПОР
         * 20
         * */
        if (!str.contains(RTH) && str.contains(RTHPOR) && str.contains(KR)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHPOR) && str.contains(KR)");
//            ReadService.amountOtherPorKR20 = -1;
            int amountOtherPorKr20 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherPorKR20 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherPorKr20 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherPorKr20", amountOtherPorKr20);
//            System.out.println(ReadService.amountOtherPorKR20);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ПОР
         * 40
         * */
        if (!str.contains(RTH) && str.contains(RTHPOR) && str.contains(PL)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHPOR) && str.contains(PL)");
//            ReadService.amountOtherPorPl40 = -1;
            int amountOtherPorPl40 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherPorPl40 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherPorPl40 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherPorPl40", amountOtherPorPl40);
//            System.out.println(ReadService.amountOtherPorPl40);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ПОР
         * 60
         * */
        if (!str.contains(RTH) && str.contains(RTHPOR) && str.contains(PV)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHPOR) && str.contains(PV)");
//            ReadService.amountOtherPorPv60 = -1;
            int amountOtherPorPv60 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherPorPv60 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherPorPv60 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherPorPv60", amountOtherPorPv60);
//            System.out.println(ReadService.amountOtherPorPv60);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ПОР
         * 70
         * */
        if (!str.contains(RTH) && str.contains(RTHPOR) && str.contains(CS)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHPOR) && str.contains(CS)");
//            ReadService.amountOtherPorCs70 = -1;
            int amountOtherPorCs70 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherPorCs70 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherPorCs70 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherPorCs70", amountOtherPorCs70);
//            System.out.println(ReadService.amountOtherPorCs70);
//            ReadService.iters++;
            return true;
        }
        /*
         * ЧУЖ
         * СОСТ=ПОР
         * 90
         * */
        if (!str.contains(RTH) && str.contains(RTHPOR) && str.contains(PR)) {
//            System.out.println("!str.contains(RTH) && str.contains(RTHPOR) && str.contains(PR)");
//            ReadService.amountOtherPorPr90 = -1;
            int amountOtherPorPr90 = 0;
            while (matcher.find()) {
//                if (!matcher.group("amount").isEmpty() || matcher.group("amount") != null) {
//                    ReadService.amountOtherPorPr90 = Integer.parseInt(matcher.group("amount"));
//                }
                amountOtherPorPr90 = Integer.parseInt(matcher.group("amount"));
            }
            mapDatas.put(getStCode(str) + "|amountOtherPorPr90", amountOtherPorPr90);
//            System.out.println(ReadService.amountOtherPorPr90);
//            ReadService.iters++;
            return true;
        }
        return false;
    }

    private int getStCode(String str) {
        int code = 0;
        if (str.toLowerCase().contains(CHUKUR)) {
            System.out.println("chukur");
            code = 7200;
        }
        if (str.toLowerCase().contains(XAVAST)) {
            System.out.println("xavast");
            code = 7258;
        }
        if (str.toLowerCase().contains(BUXARA)) {
            System.out.println("bukhara");
            code = 7300;
        }
        if (str.toLowerCase().contains(KARSHI)) {
            System.out.println("karshi");
            code = 7331;
        }
        if (str.toLowerCase().contains(KOKAND)) {
            System.out.println("kokand");
            code = 7400;
        }
        return code;
    }
}
