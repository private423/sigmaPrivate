import java.awt.Graphics;
import javax.swing.JFrame;

public class MidpointCircleDrawing extends JFrame {

    private int xc, yc, r;

    public MidpointCircleDrawing(int xc, int yc, int r) {
        super("Midpoint Circle Drawing Algorithm");
        this.xc = xc;
        this.yc = yc;
        this.r = r;
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawMidpointCircle(g, xc, yc, r);
    }

    private void drawMidpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 1 - r; // Initial decision parameter P0

        drawCircle(g, xc, yc, x, y);

        while (x < y) {
            if (d < 0) {
                d += 2 * x + 3;
            } else {
                d += 2 * (x - y) + 5;
                y--;
            }
            x++;
            drawCircle(g, xc, yc, x, y);
        }
    }

    private void drawCircle(Graphics g, int xc, int yc, int x, int y) {
        g.drawLine(xc + x, yc + y, xc + x, yc + y);
        g.drawLine(xc - x, yc + y, xc - x, yc + y);
        g.drawLine(xc + x, yc - y, xc + x, yc - y);
        g.drawLine(xc - x, yc - y, xc - x, yc - y);
        g.drawLine(xc + y, yc + x, xc + y, yc + x);
        g.drawLine(xc - y, yc + x, xc - y, yc + x);
        g.drawLine(xc + y, yc - x, xc + y, yc - x);
        g.drawLine(xc - y, yc - x, xc - y, yc - x);
    }

    public static void main(String[] args) {
        new MidpointCircleDrawing(250, 250, 100);
    }
}
