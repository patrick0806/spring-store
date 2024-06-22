package tech.patricknicezi.Spring.Store.util;

public class StringUtils {

    public static String onlyLetters(String str) {
        return str.replaceAll("[^a-zA-Z]", "");
    }

    public static String onlyNumbers(String str) {
        return str.replaceAll("[^0-9]", "");
    }
}
