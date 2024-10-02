public class DDA_Line
{
	public void DDA(int x0,int y0,int x1,int y1)
	{
		int dx= x1-x0;
		int dy= y1-y0;
		
		int steps = Math.max(Math.abs(dx),Math.abs(dy));
		
		float x_inc = (float)dx/steps;
		float y_inc = (float)dy/steps;
		
		float x = x0;
		float y = y0;
		
		System.out.println("("+ Math.round(x) + "," + Math.round(y)+ ")" );
		
		for(int i =0;i<steps ; i++)
		{
			x +=x_inc;
			y += y_inc;
			
			System.out.println("("+ Math.round(x) + "," + Math.round(y)+ ")" );
		}
	}

	public static void main(String[] args)
	{
		DDA_Line line = new DDA_Line();
		int x0 =2;
		int y0=15;
		int x1=14;
		int y1=3;
		
		line.DDA(x0,y0,x1,y1);
	}
}