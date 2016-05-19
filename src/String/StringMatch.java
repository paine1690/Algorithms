package String;
import java.util.*;

/**
 * 字符串匹配
 * 
 * 根据算法导论
 * 
 * @author Paine
 *
 */
public class StringMatch {
	/*
	 * KMP算法
	 * 将所有匹配的下标在list中返回
	 */
	public static List<Integer> kmpMatcher(String Text, String Pattern){
		int n=Text.length();
		int m=Pattern.length();
		if(m==0){
			return null;
		}
		char[] T=toCharArray(Text);
		char[] P=toCharArray(Pattern);
		int[] Pi=computePrifix(Pattern);
		List<Integer> list=new ArrayList<Integer>();
		int q=0;
		for(int i=1; i<=n; i++){
			while(q>0&&P[q+1]!=T[i]){
				q=Pi[q];
			}
			if(P[q+1]==T[i]){
				q++;
			}
			if(q==m){
				list.add(i-m);
				q=Pi[q];
			}
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
	/*
	 * MKP算法的预处理函数
	 * 根据匹配的字符串计算出前缀函数
	 */
	private static int[] computePrifix(String s){
		int m=s.length();
		char[] P=toCharArray(s);
		int[] re=new int[m+1];
		int k=0;
		re[1]=0;
		for(int q=2; q<=m; q++){
			while(k>0&&P[k+1]!=P[q]){
				k=re[k];
			}
			if(P[k+1]==P[q]){
				k++;
			}
			re[q]=k;
		}
		return re;
	}
	/*
	 * 把字符串转换成数组，并且下标+1,这样程序里看起来更加直观
	 */
	private static char[] toCharArray(String s){
		char[] re=new char[s.length()+1];
		for(int i=0; i<s.length(); i++){
			re[i+1]=s.charAt(i);
		}
		return re;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="9bwc";
		String T="645r894hfo9bwc9rpnc";
		System.out.println(kmpMatcher(T, s));
	}

}
