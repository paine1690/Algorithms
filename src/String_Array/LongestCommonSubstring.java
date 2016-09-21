package String_Array;

/**
 * 
 * 最长公共子串
 * 
 * 动态规划
 * 
 * @author Paine
 *
 */
public class LongestCommonSubstring {

	public static String longestCommonSubstring(String s1, String s2){
		int m=s1.length();
		int n=s2.length();
		int[][] dp=new int[m+1][n+1];
		int max=0, x=0;
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				if(dp[i][j]>max){
					max=dp[i][j];
					x=i;
				}
			}
		}
		System.out.println(max);
		return s1.substring(x-max, x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="bcd";
		String s2="abcdef";
		System.out.println(longestCommonSubstring(s1, s2));
	}

}
