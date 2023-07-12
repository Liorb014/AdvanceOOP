import java.util.ArrayList;

public class Junction extends Thread{
    private int x;
    private int y;
    private int width;
    private int height;
    private ArrayList<TrafficLight> trafficLights;

    public Junction(int x, int y, int width, int height, ArrayList<TrafficLight> trafficLights) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.trafficLights = trafficLights;
    }

}
