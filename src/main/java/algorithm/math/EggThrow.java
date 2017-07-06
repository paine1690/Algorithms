package algorithm.math;

public class EggThrow {
	
	private static int f(int n, int[] dp){
		if(n<2){
			return n;
		}
		if(dp[n]>0){
			return dp[n];
		}
		int min=Integer.MAX_VALUE;
		for(int i=1; i<=n; i++){
			min=Math.min(min, 1+Math.max(i-1, f(n-i, dp)));
		}
		dp[n]=min;
		return min;
	}
	
	public static int eggThrow(int n){
		int[] dp=new int[n+1];
		return f(n, dp);
	}
	
	public static void main(String[] args) {
		System.out.println(eggThrow(100));
	}

}
