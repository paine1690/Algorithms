package algorithm.sort;

import java.util.Arrays;

/**
 * 		基数排序
 * 
 * 给定n个d位数，其中每个数位有k个可能的取值
 * 采用稳定的O(n+k)的排序算法即计数排序，基数排序的时间复杂度为O(d(n+k))
 * 
 * 
 * 
 * @author Paine
 *
 */

public class RadixSort {
	private static int[] c;
	//计算num倒数第n位的数字
	private static int valInBit(int num, int n){
		int temp=1;
		while(n>0){
			temp*=10;
			n--;
		}
		return num%temp/(temp/10);
	}
	
	//按照数组的倒数第n位数字进行排序
	private static void countingSort(int[] nums, int[] re, int n){
		Arrays.fill(c, 0);
		for(int i=0; i<nums.length; i++){
			c[valInBit(nums[i], n)]++;
		}
		for(int i=1; i<c.length; i++){
			c[i]+=c[i-1];
		}
		for(int i=nums.length-1; i>=0; i--){
			int val=valInBit(nums[i], n);
			int index=c[val];
			re[index-1]=nums[i];
			c[val]--;
		}
		System.out.println("step"+n+": "+Arrays.toString(re));
	}
	
	/*
	 * 给定n个d位数，其中每个数位有k个可能的取值
	 */
	public static void radixSort(int[] nums, int d, int k){
		c=new int[k];
		int[] temp=new int[nums.length];
		for(int i=1; i<=d; i++){
			if((i&1)==1){
				countingSort(nums, temp, i);
			}else{
				countingSort(temp, nums, i);
			}
		}	
		
		if((d&1)!=1){
			nums=temp;
		}
		
	} 
	public static void main(String[] args) {
		int[] nums={329,457,657,839,436,720,355};
		radixSort(nums, 3, 10);
		System.out.println(Arrays.toString(nums));
	}

}
