import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TrafficLight extends Thread{
    public static final int GREEN = 1;
    public static final int RED = 3;
    public static final int WIDTH = 50;
    private int color;
    private int x;
    private int y;
    private Map<Integer, Integer> durations;

    public TrafficLight(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        Random random = new Random();
        this.durations = new HashMap<>();
        this.durations.put(RED, random.nextInt(5000, 9000));
        this.durations.put(GREEN, random.nextInt(4000, 8000));
        this.changeColor();
    }

    private void changeColor () {
        new Thread(() -> {
            while (true) {
                int sleepTime = this.durations.get(this.color);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (this.color) {
                    case RED -> this.color = GREEN;
                    case GREEN -> this.color = RED;
                }
            }
        }).start();
    }

    public void draw (Graphics graphics) {
        Color color = null;
        switch (this.color) {
            case GREEN -> color = Color.GREEN;
            case RED -> color = Color.RED;
        }
        graphics.setColor(color);
        graphics.fillRect(this.x, this.y, WIDTH, 150);
    }

    public int getX() {
        return this.x;
    }

    public boolean isRed () {
        return this.color == RED;
    }

    public Rectangle calculateRectangle () {
        Rectangle rectangle = new Rectangle(this.x, this.y, WIDTH, 150);
        return rectangle;
    }

}
