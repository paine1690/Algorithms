package String;

/**
 * 
 * 		Manacher算法
 * 求字符串的最长回文字字串
 * 详细说明见链接
 * @author Paine
 *
 */

public class Manacher {
	/*
	 * 预处理
	 * 为了方便后面处理
	 * 在开始和结尾分别加上^ $,字母之间加上#
	 */
	private static String preProcess(String str){
    	int len=str.length();
		if(len==0){
			return "^$";
		}
		StringBuilder s=new StringBuilder("^");
		for(int i=0; i<str.length(); i++){
			s.append("#").append(str.charAt(i));
		}
		s.append("#$");
		return s.toString();
    }
    
	/*
	 * T为处理后的字符串，P[]为T中对应字符的最长字串长度
	 */
    public static String longestPalindrome(String s) {
    	String T=preProcess(s);
    	int len=T.length();
    	int[] P=new int[len];
    	int C=0, R=0;
    	
    	for(int i=1; i<len-1; i++){
    		int j=C-(i-C);
    		int diff=R-i;
    		
    		if(diff>=0&&diff>P[j]){
    			P[i]=P[j];
    		}else{
    			P[i]=diff>=0? diff:0;
    			while(T.charAt(i+P[i]+1)==T.charAt(i-P[i]-1)){
    				P[i]++;
    			}
    			C=i;
    			R=i+P[i];
    		}
    	}
    	
    	int max=0;
		C=0;
		for(int i=1; i<len-1; i++){
			if(P[i]>max){
				max=P[i];
				C=i;
			}
		}
		int start=(C-max)/2;
		return s.substring(start, start+max);
    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aba"));

	}

}
