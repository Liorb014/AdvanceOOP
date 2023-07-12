import java.awt.*;

public class Pedestrians extends Thread {
    private int x;
    private int y;
    private int width;
    private int height;
    private final int SIZE=30;

    public Pedestrians(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = SIZE;
        this.height = SIZE;
    }
    public void draw (Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(this.x, this.y, 30, 30);
    }

    public boolean closeEnough (TrafficLight trafficLight) {
        boolean result = false;
        if (trafficLight.getX() - this.x <= 20) {
            result = true;
        }
        return result;
    }

    public boolean needToStop (TrafficLight trafficLight) {
        boolean result = false;
        if (!passed(trafficLight)) {
            if (this.closeEnough(trafficLight)) {
                if (trafficLight.isRed()) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean passed (TrafficLight trafficLight) {
        boolean result = false;
        if (this.x > trafficLight.getX() + TrafficLight.WIDTH) {
            result = true;
        }
        return result;
    }

}
