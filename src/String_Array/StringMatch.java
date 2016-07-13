package String_Array;
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
	 * 1、朴素算法  
	 * 
	 * 暴力破解 O((n-m+1)*m)
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
	 * 2、Rabin-Karp算法
	 * 
	 * 最坏情况下和朴素一样O((n-m+1)*m)
	 * 通过哈希函数进行映射
	 * 运行的时候能到达O(n+m)
	 * 
	 */
	public static List<Integer> rabinKarpMatcher(String T, String P){
		List<Integer> re=new ArrayList<Integer>();
		int n=T.length(), m=P.length();
		int q=13;//直接取素数13
		int d=10, h=1;//d直接去10
		int p=0, t=0;
		
		for(int i=0; i<m-1; i++){//根据P的长度求出h，即具有m数位的文本窗口的高位数位上的数字“1”的值
			h=(h*d)%q;
		}
		for(int i=0; i<m; i++){//预处理，初始化求出p和t0的值
			p=(d*p+P.charAt(i)-'0')%q;
			t=(d*t+T.charAt(i)-'0')%q;
		}
		for(int i=0; i<=n-m; i++){//无论何时执行，都有根据t(i)求t(i+1)
			if(p==t){//如果p与t(i)相等，说明取模相等，但有可能是伪命中点
				int j;
				for(j=0; j<m; j++){//进一步判断
					if(P.charAt(j)!=T.charAt(i+j)){
						break;
					}
				}
				if(j==m){//如果完全一样，则加入答案中
					re.add(i);
				}
			}
			if(i<(n-m)){//根据t(i)求t(i+1)
				t=(d*(t-(T.charAt(i)-'0')*h)+T.charAt(i+m)-'0')%q;
				if(t<0){
					t+=q;
				}
			}
		}
		return re;
	}
	
	/*
	 * 4、KMP算法
	 * 
	 * 预处理 O(m)
	 * 运行时间O(n)
	 */
	
	//预处理，求出next数组 O(m)
	private static int[] getNext(String P){
		int m=P.length();
		int[] next=new int[m+1];
		next[0]=next[1]=0;
		int j=0;
		
		for(int i=1; i<m; i++){
			while(j>0&&P.charAt(i)!=P.charAt(i)){
				j=next[j];
			}
			if(P.charAt(i)==P.charAt(j)){
				j++;
			}
			next[i+1]=j;
		}
		return next;
	}

	
	//KMP算法 匹配过程 O(n)
	public static List<Integer> kmpMatcher(String T, String P){
		List<Integer> re=new ArrayList<Integer>();
		int[] next=getNext(P);
		int m=P.length();
		System.out.println(Arrays.toString(next));
		int j=0;
		for(int i=0; i<T.length(); i++){
			while(j>0&&T.charAt(i)!=P.charAt(j)){
				j=next[j];
			}
			if(T.charAt(i)==P.charAt(j)){
				j++;
			}
			if(j==m){
				re.add(i-j+1);
				j=next[j];
			}
		}
		return re;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String P="ababaca";
		String T="abagfdsgfdhfdbaca";
		//System.out.println(naiveStringMatcher(T, P));
		//System.out.println(rabinKarpMatcher(T, P));
		System.out.println(kmpMatcher(T, P));

	}

}
