/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER=new Comparator<Point>() {
		
		@Override
		public int compare(Point o1, Point o2) {
			double slopeo1,slopeo2;
			if((o1.x-x)==0 && (o1.y-y) >=0){
				slopeo1=Double.POSITIVE_INFINITY;
			}else if ((o1.x-x)==0 && (o1.y-y) <=0){
				slopeo1=Double.NEGATIVE_INFINITY;
			}else{
				slopeo1=(double )(o1.y-y)/(double)(o1.x-x);
			}
			if((o2.x-x)==0 && (o2.y-y) >=0){
				slopeo2=Double.POSITIVE_INFINITY;
			}else if ((o2.x-x)==0 && (o2.y-y) <=0){
				slopeo2=Double.NEGATIVE_INFINITY;
			}else{
				slopeo2=(double )(o2.y-y)/(double )(o2.x-x);
			}
			if( slopeo1 >= 0 && slopeo2 <0 ) return -1;
			else if (slopeo1 < 0 && slopeo2 >=0 ) return 1;
			else return (int )slopeo1-(int )slopeo2;
		}
	};       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
    	
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
    	
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
    	if((that.x-this.x)==0){
    		if (that.y>this.y){
    			 return Double.POSITIVE_INFINITY;
    		}else{
    			return Double.NEGATIVE_INFINITY;
    		}    		
    	}else{
    		 return ((double)(that.y-this.y)/(double)(that.x-this.x) );
    	}
       
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    	if(this.y>that.y){
    		return 1;
    	}else if(this.y<that.y){
    		return -1;
    	}else{
    		if(this.x>that.x)
    			return 1;
    		else if(this.x < that.x)
    			return -1;
    		else
    			return 0;
    	}
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}