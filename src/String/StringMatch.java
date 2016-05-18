package String;
import java.util.*;

/**
 * 		字符串匹配
 * 
 * 算法导论第32章
 * 1、朴素算法
 * 2、Rabin-karp算法
 * 3、有限自动机算法
 * 4、kmp算法
 * @author Paine
 *
 */
public class StringMatch {
	
	/*
	 * 1、朴素算法  O((n-m+1)*m)
	 * 暴力破解 
	 * 外层循环 n-m+1
	 * 内层循环 m 
	 */
	public static List<Integer> naiveStringMatcher(String T, String P){
		List<Integer> re=new ArrayList<Integer>();
		int n=T.length();
		int m=P.length();
		for(int i=0; i<=n-m; i++){
			int j;
			for(j=0; j<m; j++){
				if(P.charAt(j)!=T.charAt(i+j)){
					break;
				}
			}
			if(j==m){
				re.add(i);
			}
		}
		return re;
	}
	
	
	
	
	
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
		String P="abc";
		String T="ahdsiufhasdnfabchfushfabc";
		System.out.println(naiveStringMatcher(T, P));
	}

}
