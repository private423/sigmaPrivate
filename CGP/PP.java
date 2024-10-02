import java.awt.*;
import javax.swing.*;

public class PP extends JFrame{
		
		PP(){
			setSize(500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);			
		}
		
		public void paint(Graphics g){
			super.paint(g);
			
			
			g.drawLine(300,300,400,300);
			g.drawLine(400,300,400,400);
			g.drawLine(400,400,300,400);
			g.drawLine(300,400,300,300);
			
			g.drawLine(350,300,425,450);
			g.drawLine(425,450,350,450);
			g.drawLine(350,450,350,300);
			
			g.drawLine(400,300,600,100);
			
			g.drawOval(385,215,100,100);
			g.drawOval(460,145,100,100);
		}
	
	
	
	
	
	
	public static void main(String [] args){
		
		
		new PP();
		
	}
	
	
}