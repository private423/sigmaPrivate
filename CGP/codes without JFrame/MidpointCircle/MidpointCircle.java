public class  MidpointCircle
{
	public void drawCircle(int r)
	{
		int x=0;
		int y = r;
		int p = 1-r;
		
		while(x<=y)
		{
			setPixel(x,y);
			setPixel(y,x);
			setPixel(-x,y);
			setPixel(-y,x);
			setPixel(-x,-y);
			setPixel(-y,-x);
			setPixel(x,-y);
			setPixel(y,-x);
			
			if(p<0)
			{
				p=p+2*x+3;
			}
			else
			{
				p=p+2*(x-y)+6;
				y--;
			}
			x++;
			
		}
	}
	private void setPixel(int x, int y)
	{
		System.out.println("("+x+","+y+")");
	}
	
	public static void main (String[] args)
	{
		MidpointCircle circle = new MidpointCircle();
		int r =10;
		
		circle.drawCircle(r);
	}
	
}