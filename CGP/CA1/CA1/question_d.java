import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class question_d {
    
    public static void Bresenham(Graphics g, int x0, int y0, int xl, int yl) {
        int dx = Math.abs(xl - x0);
        int dy = Math.abs(yl - y0);
        int sx = x0 < xl ? 1 : -1;
        int sy = y0 < yl ? 1 : -1;
        int err = dx - dy;
        int x = x0;
        int y = y0;

        while (x != xl || y != yl) {
            g.drawLine(x, y, x, y);
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
        g.drawLine(x, y, xl, yl);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bresenham Line Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(new DrawingPanel());
        frame.setVisible(true);
		
    }

    static class DrawingPanel extends JPanel {
		
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
						
						
            Bresenham(g,-100,-100,-100,400);
			Bresenham(g,100,50,100,250);
			Bresenham(g,100,250,350,250);
			Bresenham(g,100,50,350,50);
			Bresenham(g,350,250,350,50);
			Bresenham(g,350,50,550,-350);
			Bresenham(g,225,50,225,350);
			
        }
    }
}