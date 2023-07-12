import javax.swing.*;

public class Window extends JFrame {
    public static void main(String[] args) {
        new Window();
    }
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public Window() {

            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(WIDTH, HEIGHT);
            this.setResizable(false);
            this.setLayout(null);
            this.add(new Road(0, 0, WIDTH, HEIGHT));
            this.setLocationRelativeTo(null);
            this.setVisible(true);
    }
}
