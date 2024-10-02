import java.awt.Graphics;
import javax.swing.JFrame;

public class BresenhamLineDrawing extends JFrame {

    private int x0, y0, x1, y1;

    public BresenhamLineDrawing(int x0, int y0, int x1, int y1) {
        super("Bresenham Line Drawing Algorithm");
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBresenhamLine(g, x0, y0, x1, y1);
    }

    private void drawBresenhamLine(Graphics g, int x0, int y0, int x1, int y1) {
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.drawLine(x0, y0, x0, y0); // Plot the point
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    public static void main(String[] args) {
        new BresenhamLineDrawing(50, 50, 200, 200);
    }
}
