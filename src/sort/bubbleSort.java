package sort;

import java.util.Arrays;

public class bubbleSort {

	
	private static void swap(int[] nums, int i, int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	public static void bubbleSort1(int[] nums){		
		for(int i=1; i<nums.length; i++){//len-1趟
			for(int j=0; j<nums.length-i; j++){
				if(nums[j]>nums[j+1]){
					swap(nums, j+1, j);
				}
			}
			System.out.println(Arrays.toString(nums));
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void bubbleSort2(int[] nums){
		boolean flag=true;
		int firstChange=0;
		int lastChange=nums.length-1;
		int i;
		while(flag){
			flag=false;
			for(i=firstChange; i<lastChange; i++){
				if(nums[i]>nums[i+1]){
					swap(nums, i, i+1);
					if(!flag){//第一次交换，记录位置，下次只需要判断i-1与i，即从i-1开始判断
						firstChange=i-1;
					}
					flag=true;
				}
			}
			lastChange=i;
			firstChange=Math.max(firstChange, 0);
			System.out.println(Arrays.toString(nums));
		}
		System.out.println(Arrays.toString(nums));
	}
	
	
	public static void main(String[] args) {
		int[] nums={20,15,14,18,22,35,40};
		bubbleSort2(nums);
	}

}
