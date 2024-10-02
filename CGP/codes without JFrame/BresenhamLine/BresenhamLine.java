public class BresenhamLine
{
	public void Bresenham(int x1,int y1 ,int x2,int y2)
	{
		int x=x1;
		int y= y1;
		int dx = x2-x1;
		int dy = y2-y1;
		int ds = 2*dy;
		int dt =2*(dy-dx);
		int d = 2*dy -dx;
		setPixel(x,y);
		
		while (x<x2)
		{
			
			if(d<0)
			{
				x++;
				d=d+ds;
			}
			else
			{
				x++;
				y++;
				d=d+dt;
			}
			
			setPixel(x,y);
		}
		
	}
	
	private void setPixel(int x, int y)
	{
		System.out.println("(" + x + "," + y + ")");
	}

	public static void main(String[] args)
	{
		BresenhamLine line = new BresenhamLine();
		int x1=2;
		int y1=15;
		int x2 =14;
		int y2=3;
		
		line.Bresenham(x1,y1,x2,y2);
	}
}