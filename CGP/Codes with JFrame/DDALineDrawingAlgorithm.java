import java.awt.Graphics;
import javax.swing.JFrame;

public class DDALineDrawingAlgorithm extends JFrame {

    private int x0, y0, x1, y1, x2, y2, x3, y3;

    public DDALineDrawingAlgorithm(int x0, int y0, int x1, int y1) {
        super("Line Drawing Algorithm");
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y0;
        this.x3 = x0;
        this.y3 = y1;
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        drawDDALine(g, x0, y0, x2, y2); // Top side
        drawDDALine(g, x2, y2, x1, y1); // Right side
        drawDDALine(g, x1, y1, x3, y3); // Bottom side
        drawDDALine(g, x3, y3, x0, y0); // Left side

        scalin(g, x0, y0, x2, y2); // Top side
        scalin(g, x2, y2, x1, y1); // Right side
        scalin(g, x1, y1, x3, y3); // Bottom side
        scalin(g, x3, y3, x0, y0); // Left side

        rotation(g, x0, y0, x2, y2); // Top side
        rotation(g, x2, y2, x1, y1); // Right side
        rotation(g, x1, y1, x3, y3); // Bottom side
        rotation(g, x3, y3, x0, y0); // Left side
    }

    public void rotation (Graphics g, int x0, int y0, int x1, int y1){

        double radians = Math.toRadians(10);

        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        double xa = x0 * cos -1*y0*sin;
        double ya = x0 * sin + y0 * cos;
        
        double xb = x1 * cos -1*y1*sin;
        double yb = x1 * sin + y1 * cos;

        x0 = (int) xa;
        y0 = (int) ya;
        x1 = (int) xb;
        y1 = (int) yb;

        drawDDALine(g,x0,y0,x1,y1);
    }

    public void scalin(Graphics g, int x0, int y0, int x1, int y1){

        int sx= 2;
        int sy= 2;

        x0 = x0*sx;
        x1 = x1*sx;
        y0 = y0*sy;
        y1 = y1*sy;

        drawDDALine(g,x0,y0,x1,y1);
       }

    public void scaling (Graphics g, int x0, int y0, int x1, int y1){

        int sx= 2;
        int sy= 2;

        x0 = x0*sx;
        x1 = x1*sx;
        y0 = y0*sy;
        y1 = y1*sy;

        drawDDALine(g,x0,y0,x1,y1);
    }

    private void drawDDALine(Graphics g, int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        int steps;
        float xIncrement, yIncrement;

        if (Math.abs(dx) > Math.abs(dy))
            steps = Math.abs(dx);
        else
            steps = Math.abs(dy);

        xIncrement = (float) dx / steps;
        yIncrement = (float) dy / steps;

        float x = x0, y = y0;
        for (int v = 0; v < steps; v++) {
            x += xIncrement;
            y += yIncrement;
            g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
        }
    }

    public static void main(String[] args) {
        new DDALineDrawingAlgorithm(400, 400 ,450,450);
    }
}
