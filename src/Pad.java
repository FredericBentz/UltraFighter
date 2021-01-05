public class Pad {
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public static String padLeft(int s, int n) {
        return String.format("%" + n + "s", s);
    }
}
