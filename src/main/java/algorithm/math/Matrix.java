package algorithm.math;

import java.util.Arrays;

/*
 * 矩阵相乘
 * 矩阵快速幂
 * 
 */


public class Matrix {
	/*
	 * 矩阵a与b相乘
	 * a的列数与b的行数相同才有意义
	 */
	public static int[][] multi(int[][] a, int[][] b){
		if(a.length==0||a[0].length==0||b.length==0||b[0].length==0||a[0].length!=b.length){
			return null;
		}
		int m=a.length, n=b[0].length;
		int[][] re=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int sum=0;
				for(int x=0; x<b.length; x++){
					sum+=a[i][x]*b[x][j];
				}
				re[i][j]=sum;
			}
		}
		return re;
	}
	
	public static void printMatrix(int[][] matrix){
		for(int[] nums: matrix){
			System.out.println(Arrays.toString(nums));
		}
	}	
	
	
	/*
	 * 计算矩阵的幂
	 * 方阵a的n次幂
	 */
	public static int[][] matrixPow(int[][] a, int n){
		if(a.length==0||a[0].length==0||a.length!=a[0].length){
			return null;
		}
		int len=a.length;
		int[][] re=new int[len][len];
		for(int i=0; i<len; i++){//单位阵
			re[i][i]=1;
		}
		/*
		 * 这里需要注意一下，Java中二维数组是无法用clone实现深拷贝的
		 * 也就是说这个temp指向的内存和a是相同的
		 * 因为multi方法中每次都会返回一个新的数组，所以说a的内容不会被修改
		 * 
		 */
		int[][] temp=a.clone();
		
		while(n>0){
			if((n&1)==1){
				re=multi(re, temp);
			}
			temp=multi(temp, temp);
			n>>=1;
		}
		return re;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix=new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		printMatrix(matrixPow(matrix, 4));
	}
}
