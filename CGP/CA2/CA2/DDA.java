import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;

public class DDA {
    public void dda(Graphics g, int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x0;
        float y = y0;

        g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));

        for (int i = 1; i <= steps; i++) {
            x += xIncrement;
            y += yIncrement;
            g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
        }
    }


    public void translatePoint(Graphics g, int P[], int T[]) {
        P[0] += T[0];
        P[1] += T[1];
        g.drawLine(P[0], P[1], P[0], P[1]);
    }

    public void translateLine(Graphics g, int P[][], int T[]) {
        for (int i = 0; i < P.length; i++) {
            P[i][0] += T[0];
            P[i][1] += T[1];
            g.drawLine(P[i][0], P[i][1], P[i][0], P[i][1]);
        }
    }

     public void scale(Graphics g, int x[], int y[], int sx, int sy) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= sx;
            y[i] *= sy;
        }
        g.drawPolygon(x, y, x.length);
    }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Triangle Transformation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
    
            JPanel panel = new JPanel() {
                
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
    
                    int[] xPoints = {50, 100, 150};
                    int[] yPoints = {150, 50, 150};
    
                    g.setColor(Color.BLUE);
                    g.drawPolygon(xPoints, yPoints, 3);
    
                    DDA dda = new DDA();
                    int[] translationVector = {7, 9};
                    for (int i = 0; i < xPoints.length; i++) {
                        int[] point = {xPoints[i], yPoints[i]};
                        dda.translatePoint(g, point, translationVector);
                        xPoints[i] = point[0];
                        yPoints[i] = point[1];
                    }
    
                    g.setColor(Color.RED);
                    g.drawPolygon(xPoints, yPoints, 3);
    
                    int sx = 4;
                    int sy = 8;
                    dda.scale(g, xPoints, yPoints, sx, sy);
                }
            };
    
            frame.add(panel);
        }   



}
