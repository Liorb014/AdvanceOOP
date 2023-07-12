public class Philosophy extends Thread{
    private int id;
    private Fork rightFork;
    private Fork leftFork;
    public static boolean eating;

    public Philosophy(int id , Fork rightFork, Fork leftFork) {
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        eating = false;
        this.id =id;
        run();
    }

    public void run (){
        new Thread(()->{
            while (true){
                if (eating){
                    System.out.println(this.leftFork.getId()+" "+this.rightFork.getId());

                    System.out.println( "philosophy number "+this.id +" eating");
                }else {
                    this.rightFork = null;
                    this.leftFork = null;
                    System.out.println("philosophy number " + this.id + " not eating");
                }
            }
        }).start();

    }
    private  void think(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tryToEat(){
        synchronized (this.rightFork){
            if (this.rightFork.isPiked()==false){
                this.rightFork.setPiked(true);
                synchronized (this.leftFork){
                    if (this.leftFork.isPiked()){
                        this.leftFork.setPiked(true);
                    }
                }
            }
        }
    }
}
