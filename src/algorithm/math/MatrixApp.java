package algorithm.math;

/*
 * 矩阵快速幂的应用
 */
public class MatrixApp {	
	/*
	 * 计算第n个斐波那契数列
	 */
	public static int fib(int n){
		int[][] A=new int[][]{
			{1,1},
			{1,0}
		};
		int[][] An=Matrix.matrixPow(A, n-1);		
		int F1=1, F0=0;		
		return F1*An[0][0]+F0*An[0][1];
	}
	
	
	public static void main(String[] args) {
		System.out.println(fib(10));
	}
}
