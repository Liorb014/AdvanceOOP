public class Utility {
    public static void sleep(int milPerSec){
        try {
            Thread.sleep(milPerSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
