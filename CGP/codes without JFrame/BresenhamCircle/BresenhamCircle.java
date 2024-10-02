public class BresenhamCircle
{
	public void drawCircle(int r)
	{
		int x=0;
		int y=r;
		int d = 3-2*r;
		
		while (x<=y)
		{
			setPixel(x,y);
			setPixel(y,x);
			setPixel(-x,y);
			setPixel(-y,x);
			setPixel(-x,-y);
			setPixel(-y,-x);
			setPixel(x,-y);
			setPixel(y,-x);
			if(d<0)
			{
				d=d+4*x+6;
			}
			else
			{
				d=d+4*(x-y)+10;
				y--;
			}
			x++;
		}
	}
	private void setPixel(int x ,int y)
	{
		System.out.println("(" + x + "," + y + ")"); 
	}

	public static void main(String[] args)
	{
		BresenhamCircle circle = new BresenhamCircle();
		
		int r=10;
		
		circle.drawCircle(r);
	}
}