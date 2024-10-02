import java.awt.Graphics;
import javax.swing.JFrame;

public class BresenhamCircleDrawing extends JFrame {

    private int centerX, centerY, radius;

     public BresenhamCircleDrawing(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    public void paint(Graphics g) {
        super.paint(g);
        drawBresenhamCircle(g, radius);
    }

    private void drawBresenhamCircle(Graphics g,int radius) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;
        //g.drawOval(300,300,100,100);
        drawCircle(g, x, y);
        
        while (x < y) {
            x++;
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                y--;
                d = d + 4 * (x - y) + 10;
            }
            drawCircle(g, x, y);
        }
    }

    private void drawCircle(Graphics g, int x, int y) {
        g.drawLine(centerX + x, centerY + y, centerX + x, centerY + y);
        g.drawLine(centerX - x, centerY + y, centerX - x, centerY + y);
        g.drawLine(centerX + x, centerY - y, centerX + x, centerY - y);
        g.drawLine(centerX - x, centerY - y, centerX - x, centerY - y);
        g.drawLine(centerX + y, centerY + x, centerX + y, centerY + x);
        g.drawLine(centerX - y, centerY + x, centerX - y, centerY + x);
        g.drawLine(centerX + y, centerY - x, centerX + y, centerY - x);
        g.drawLine(centerX - y, centerY - x, centerX - y, centerY - x);
    }

    public static void main(String[] args) {

        int cX= 300, cY=300, r=100;

        BresenhamCircleDrawing c1 = new BresenhamCircleDrawing(cX,cY,r);

        BresenhamCircleDrawing c2 = new BresenhamCircleDrawing(400,400,r);

    }
}
