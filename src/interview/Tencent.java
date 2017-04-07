package interview;

import java.util.Arrays;
import java.util.Scanner;

public class Tencent {

	/*
	 * 腾讯在线笔试 
	 * 
	 * 蛇形矩阵
	 */
	public static void shexingjuzhen(int n){
		int count=n*n;
		int[][] nums=new int[n][n];
		int flag=1;
		int i=0, j=0, num=1;
		
		while(num<=count){
			if(flag==1){
				if(j<n&&nums[i][j]==0){
					nums[i][j]=num++;
					j++;
				}else{
					j--;
					i++;
					flag=2;
				}
			}else if(flag==2){
				if(i<n&&nums[i][j]==0){
					nums[i][j]=num++;
					i++;
				}else{
					i--;
					j--;
					flag=3;
				}
			}else if(flag==3){
				if(j>=0&&nums[i][j]==0){
					nums[i][j]=num++;
					j--;
				}else{
					j++;
					i--;
					flag=4;
				}
			}else{
				if(i>=0&&nums[i][j]==0){
					nums[i][j]=num++;
					i--;
				}else{
					i++;
					j++;
					flag=1;
				}
			}
		}
		for(i=0; i<nums.length; i++){
			System.out.println(Arrays.toString(nums[i]));
		}
	}
	
	private static void switchS(String s){
		int len=s.length();
		int[][] dp=new int[len][len];
		
		for(int i=0; i<len; i++){
			dp[i][i]=1;
			for(int j=i-1; j>=0; j--){
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j]=dp[i-1][j+1]+2;
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j+1]);
				}
			}
		}
		System.out.println(len-dp[0][len-1]);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String s=sc.nextLine();
			switchS(s);
		}
		sc.close();
	}

}
