package ivc.uty.utils.asoup;

public class TextReplace {
    public static String getReplace(String str) {
        String text = str.replaceAll("A", "А")
                .replaceAll("B", "В")
                .replaceAll("C", "С")
                .replaceAll("E", "Е")
                .replaceAll("H", "Н")
                .replaceAll("K", "К")
                .replaceAll("M", "М")
                .replaceAll("O", "О")
                .replaceAll("P", "Р")
                .replaceAll("T", "Т")
                .replaceAll("X", "Х")
                .replaceAll("Y", "У")
                .replaceAll("W", "Ш")
                .replace("?", "Ш");
        return text;
    }

    public static String getSha(String str) {
        return str.replace("?", "Ш");
    }
}
