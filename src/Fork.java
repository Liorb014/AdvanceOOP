public class Fork {
    private int id =1;
    private boolean piked;


    public int getId() {
        return id;
    }

    public boolean isPiked() {
        return piked;
    }

    public void setPiked(boolean piked) {
        this.piked = piked;
    }

    public Fork(int id){
        this.id=id;
    }
    private void tookNumber(){
        id++;
    }
}
