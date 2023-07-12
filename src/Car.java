import java.awt.*;

public class Car extends Thread {
    private int x;
    private int y;
    private boolean driving;

    public Car(int x, int y) {
        this.x = x;
        this.y = y;
        this.driving = true;
        this.run();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDriving() {
        return driving;
    }

    public void run() {
        new Thread(() -> {
            while (true) {
                if (this.driving) {
                    this.x++;
                }
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void stopCar() {
        this.driving = false;
    }

    public void start () {
        this.driving = true;
    }

    public void draw (Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(this.x, this.y, 30, 30);
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
