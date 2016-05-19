package String;

/**
 * 
 * 最长公共子序列
 * 
 * 动态规划
 * 
 * @author Paine
 *
 */
public class LongestCommonSubsequeuece {

	public static String longestCommonSubsequeuece(String s1, String s2){
		int m=s1.length();
		int n=s2.length();
		int[][] dp=new int[m+1][n+1];
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[m][n]);
		StringBuilder s=new StringBuilder();
		while(m>0&&n>0){
			if(s1.charAt(m-1)==s2.charAt(n-1)){
				s.insert(0, s1.charAt(m-1));
				m--;
				n--;
			}else if(dp[m-1][n]>=dp[m][n-1]){
				m--;
			}else{
				n--;
			}
		}
		return s.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcfbc";
		String s2="abfcba";
		System.out.println(longestCommonSubsequeuece(s1, s2));
	}

}
