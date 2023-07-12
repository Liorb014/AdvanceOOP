import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Road extends JPanel {
    private ArrayList<TrafficLight> trafficLights;
    private Car car;

    public Road (int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setBackground(Color.BLACK);
        this.trafficLights = new ArrayList<>();
        this.trafficLights.add(new TrafficLight(TrafficLight.RED, width - 100, 200));
        this.trafficLights.add(new TrafficLight(TrafficLight.RED, width - 300, 200));
        this.trafficLights.add(new TrafficLight(TrafficLight.RED, width - 500, 200));
        this.car = new Car(0, 250);
        repaintThread ();
    }

    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        for (TrafficLight trafficLight : this.trafficLights) {
            trafficLight.draw(graphics);
        }
        this.car.draw(graphics);
    }

    public void repaintThread () {

        new Thread(() -> {
            while (true) {
                boolean needToStop = false;
                for (TrafficLight trafficLight : this.trafficLights) {
                    if (this.car.needToStop(trafficLight)) {
                        needToStop = true;
                        break;
                    }
                }
                if (needToStop) {
                    this.car.stopCar();
                } else {
                    this.car.start();
                }
                this.repaint();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
