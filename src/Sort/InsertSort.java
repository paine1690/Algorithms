package Sort;

import java.util.Arrays;

/*
 * 插入排序
 * 时间复杂度:O(n^2)
 * 		最好情况：O(n)    数组有序
 * 	
 * 空间复杂度O(1)
 * 
 * 
 */

public class InsertSort {

	public static void insertSort(int[] nums){
		for(int i=0; i<nums.length; i++){
			int num=nums[i];
			int j=i-1;
			while(j>=0&&nums[j]>num){
				nums[j+1]=nums[j];
				j--;
			}
			nums[j+1]=num;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={10,4,8,5,4,6,15,4,14,654,1,4,4,1,1,154,5};
		insertSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
