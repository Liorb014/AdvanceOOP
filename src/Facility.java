import java.util.Random;

public class Facility extends Thread {
    private Integer id;
    private String name;
    private int timeSpending;
    private int maxCapability;
    private boolean finishToRun;
    public final int REST_TIME=5000;



    public Facility(int maxCapability, String name, int id) {
        super();
        Random random = new Random();
        this.timeSpending = random.nextInt(10,31);
        this.maxCapability = maxCapability;
        this.finishToRun=false;
        if (this.finishToRun){
            run();
        }
        this.id =id;
    }
    public long getId() {
        return id;
    }
    public void run (){
        Utility.sleep(REST_TIME);
    }

    public boolean gotUsed(){
        boolean result= false;

        return result;
    }
}
