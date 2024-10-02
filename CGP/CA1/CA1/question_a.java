import java.util.Scanner;

	
	static void Bresenham( int X0,int Y0, int X1,int Y1) {
		int d,i1,i2,dx,dy,x,y,xMin,xMax;
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter coordinates ;");
		System.out.print("\tX0 = ");
		X0 = obj.nextInt();
		System.out.print("\tY0 = ");
		Y0 = obj.nextInt();
		System.out.print("\n\tX1 = ");
		X1 = obj.nextInt();
		System.out.print("\tY1 = ");
		Y1 = obj.nextInt();
		
		dx= X1-X0;
		dy= Y1-Y0;
			
		i1 = 2*dy;
		i2 = 2*(dy-dx);
		d = i1-dx;
		
		if(dx<0){
			x=X1;
			y=Y1;
			xMax=X0;
			xMin=X1-1;
		}
		else{
			x=X0;
			y=Y0;
			xMax=X1;
			xMin=X0-1;
		}
		
		if(x>=xMax){
			System.exit(0);
		}
		
		System.out.println("Output cordinates : ");
		System.out.println("\t ( "+x+", "+y+" )");
		
		while (x<xMax){
			
			if(d<0){
				d=d+i1;
				x=x+1;
				if(Y1<Y0){
					y=y-1;
				}
			}
			else{
				d=d+i2;
				y=y+1;				
				x=x+1;
				
			}
		
			System.out.println("\t ( "+x+", "+y+" )");
		}
	}