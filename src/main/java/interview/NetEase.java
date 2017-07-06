package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetEase {

	/*  2017网易内推笔试编程题(洗牌)
	 * 
		洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
		
		输入描述:
		
		第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,…,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
		
		输出描述:
		
		对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
		
		输入例子:
		3
		3 1
		1 2 3 4 5 6
		3 2
		1 2 3 4 5 6
		2 2
		1 1 1 1
		
		输出例子:
		
		1 4 2 5 3 6
		1 5 4 3 2 6
		1 1 1 1
		
	 */
	
	
	public static void test(int[] nums, int n, int k){
		if(k==0){
			System.out.println(Arrays.toString(nums));
			return;
		}
		int i=0, j=n, c=0;
		int[] re=new int[2*n];
		while(i<n){
			re[c++]=nums[i++];
			re[c++]=nums[j++];
		}	
		test(re, n, k-1);
	}
	
	public static void xipai(){
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		for(int i=0; i<c; i++){
			int n=s.nextInt();
			int k=s.nextInt();
			int[] nums=new int[2*n];
			for(int j=0; j<nums.length; j++){
				nums[j]=s.nextInt();
			}
			test(nums, n, k);
		}
		s.close();
	}
	
	
	public static int rev(int x){
		int re=0;
		while(x>0){
			int temp=x%10;
			re=re*10+temp;
			x/=10;
		}
		return re;
		
	}
	
	public static boolean isBlack(char[] s){
		if(s.length<3){
			return true;
		}
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		map.put(s[0], 1);
		if(map.containsKey(s[1])){
			map.put(s[1], map.get(s[1])+1);
		}else{
			map.put(s[1], 1);
		}
		for(int i=2; i<s.length; i++){
			char c=s[i];
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
			if(map.size()==3){
				return false;
			}else{
				char cc=s[i-2];
				if(map.get(cc)==1){
					map.remove(cc);
				}else{
					map.put(cc, map.get(cc)-1);
				}
			}
		}
		return true;
	}
	
	
	/*
	 * 实习笔试 排队形 男生女生
	 */
	public static void swap(String s){
		char[] chars=s.toCharArray();
		int re1=0, re2=0, g=0, b=0;
		for(int i=0; i<chars.length; i++){
			if(chars[i]=='G'){
				re1+=i-g;
				g++;
			}else{
				re2+=i-b;
				b++;
			}
		}
		System.out.print(Math.min(re1, re2));
	}
	
	/*
	 * 魔力手环
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
					sum+=a[i][x]*b[x][j]%100;
				}
				re[i][j]=sum%100;
			}
		}
		return re;
	}
	
	public static void print(int[][] matrix){
		int[] nums=matrix[0];
        System.out.print(nums[0]);
        for(int i=1; i<nums.length; i++){
            System.out.print(" "+nums[i]);
        }
	}
	
	public static int[][] matrixPow(int[][] a, int n){
		if(a.length==0||a[0].length==0||a.length!=a[0].length){
			return null;
		}
		int len=a.length;
		int[][] re=new int[len][len];
		for(int i=0; i<len; i++){//单位阵
			re[i][i]=1;
		}
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
	
	private static void magicHoop(int[] nums, int n, int k){
		int[][] a=new int[n][n];
		a[0][0]=1;
		a[0][n-1]=1;
		for(int i=1; i<n; i++){
			a[i][i]=1;
			a[i][i-1]=1;
		}
		print(multi(new int[][]{nums}, matrixPow(a, k)));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] nums=new int[n];
		for(int i=0; i<n; i++){
			nums[i]=sc.nextInt();
		}
		sc.close();
		magicHoop(nums, n, k);		
	}
}







