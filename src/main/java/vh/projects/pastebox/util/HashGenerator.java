package vh.projects.pastebox.util;

public class HashGenerator {
    private static long hash = 0;

    public static long getHash() {
        return hash++;
    }
}
