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
		int max=0, x=0, y=0;
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				if(dp[i][j]>max){
					max=dp[i][j];
					x=i;
					y=j;
				}
			}
		}
		System.out.println(max);
		StringBuilder s=new StringBuilder();
		while(dp[x][y]>0){
			s.insert(0, s1.charAt(x-1));
			x--;
			y--;
		}
		return s.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcde";
		String s2="7431564";
		System.out.println(longestCommonSubstring(s1, s2));
	}

}
