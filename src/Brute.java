import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Brute {
	/**
	 * This method generates the combinations of k-tuples from a sequence (0..n)
	 * The algorithm is my implementation of Applied combinatorics algorithm
	 *  B. Jackson, D. Thoro (Addison-Wesley, 1990)
	 * @param n the sequence of numbers from zero to n 
	 * @param k the number of tuples 
	 * @return a two dimensional array[][]  where the index of the first 
	 * dimension is the tuple number out of (binomial(n,k)) combinations
	 * and the second is the index of the sequence produced
	 */
	private static int[][] generate(int n,int k){
		if(k == n || k <= 0 || n <= 0    ){
			throw new IllegalArgumentException("the number of compinations must be greater than k and positive");
		}
		int noOfCompinations=combinations(n,k);	
		int[] sequence=new int[n];
		int[][] result=new int[noOfCompinations][k];
		for (int i=0 ; i < n ;i ++){
				sequence[i]=i;
				if (i < k ){
					result[0][i]=i;
				}
		}			
		int counter = 0;
		while(counter < noOfCompinations -1 ){
			int j=k-1;
			while ( result[counter][j] > n-k+j-1 ){
				j--;	
			}
			counter++;
			int temp=1;
			for (int i = 0; i < k ; i ++ ){
				if (i < j ){
					result[counter][i]=result[counter-1][i];
				}else{
					result[counter][i]=result[counter-1][j]+temp;		
					temp++;
				}					
			}
		}
		return result;
	}
	/**
	 * Binomial coefficient computation
	 * @param n number of different elements
	 * @param k number of combinations 
	 * @return the integer number of different unordered k-tuples that is the number of distinct combinations
	 */
	private static int combinations(int n, int k) {
			int coeff = 1;
			for (int i = n - k + 1; i <= n; i++) {
				coeff *= i;
			}
			for (int i = 1; i <= k; i++) {
				coeff /= i;
			}
			return coeff;
		}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	private static boolean isColliner(Point a,Point b,Point c,Point d){
		if( a.slopeTo(b)==a.slopeTo(c) && a.slopeTo(b)==a.slopeTo(d)  ) return true;
		else return false;
	}
	public static void main(String[] args){
		Scanner in;
		try {
			in = new Scanner(new FileReader(args[0]));
			int NumberOfPoints=Integer.parseInt(in.nextLine());
			Point[] arr=new Point[NumberOfPoints];
			int[][] comb;
			StdDraw.setXscale(0, 32768);
			StdDraw.setYscale(0, 32768);
			for(int j=0;j<arr.length;j++){
				int x=in.nextInt();
				int y=in.nextInt();
				arr[j]=new Point(x, y);
				arr[j].draw();
			}
			comb=generate(NumberOfPoints,4);
			for(int i=0;i<comb.length;i++){
				if(isColliner(arr[comb[i][0]],arr[comb[i][1]],arr[comb[i][2]],arr[comb[i][3]])){
					System.out.println(arr[comb[i][0]].toString()+" -> "+arr[comb[i][1]].toString()+" -> "+arr[comb[i][2]].toString()+" -> "+arr[comb[i][3]].toString());
					arr[comb[i][0]].drawTo(arr[comb[i][3]]);
					Point min,max;
					min=arr[comb[i][0]];
					max=arr[comb[i][0]];
					for(int j=1;j<4;j++){
						if( min.compareTo(arr[comb[i][j]])>0 ){
							min=arr[comb[i][j]];
						}
						if( max.compareTo(arr[comb[i][j]])<0 ){
							max=arr[comb[i][j]];
						}
					}
					max.drawTo(min);
				}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
