import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class Fast {
	private static boolean isColliner(Point a,Point b,Point c,Point d){
		if( a.slopeTo(b)==a.slopeTo(c) && a.slopeTo(b)==a.slopeTo(d)  ) return true;
		else return false;
	}
public static void main (String[] args){
	Scanner in;
	try {
		in = new Scanner(new FileReader(args[0]));
		int NumberOfPoints=Integer.parseInt(in.nextLine());
		Point[] arr=new Point[NumberOfPoints];		
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		for(int j=0;j<arr.length;j++){
			int x=in.nextInt();
			int y=in.nextInt();
			arr[j]=new Point(x, y);
			arr[j].draw();
		}
	
			
			Arrays.sort(arr, arr[0].SLOPE_ORDER);
			for(int i=0;i<arr.length-1;i++){
				System.out.println("The slope of arr["+0+"] with arr["+(i+1)+"]"+arr[0].slopeTo(arr[i+1]));
			}
		
					
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
}

