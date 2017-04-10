package algorithm.sort;

import java.util.Arrays;

/**
 * 
 * 		堆排序
 * 空间复杂度O(1)，优于归并与快速
 * 
 * 1、复杂度：最好最坏平均均为O(nlogn)
 * 2、空间复杂度O(1)
 * 3、不是稳定排序
 * 4、主要步骤：建堆-维护对的性质-取出最大值
 * 
 * @author Paine
 *
 */

public class HeapSort {
	private static void swap(int[] nums, int i, int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	/*
	 * 筛选法建最大堆
	 * 时间复杂度O(n) 
	 * 从length/2-1开始调整，直至跟节点 
	 * 
	 */
	private static void heapBuild(int[] nums){
		for(int i=nums.length/2-1; i>=0; i--){//从length/2-1开始调整直至根节点
			adjust(nums, nums.length, i);
		}
	}
	
	/*
	 * 以i为根节点维护堆的性质
	 * 比较i的左右孩子，依次向下调整直至最低层
	 * 注意数组是从0开始的，所以左孩子节点是2*i+1 
	 */
	private static void adjust(int[] nums, int len, int i){
		int max=i;
		int left=2*i+1;
		int right=left+1;
		
		while(left<len){//维护对的性质，O(h)树的高度
			if(nums[left]>nums[max]){
				max=left;
			}
			if(right<len&&nums[right]>nums[max]){
				max=right;
			}
			if(max!=i){
				swap(nums, max, i);
				i=max;
				left=2*i+1;
				right=left+1;
			}else{
				break;
			}
		}
	}
	
	public static void heapSort(int[] nums){
		heapBuild(nums);
		int i=nums.length-1;
		while(i>0){			
			swap(nums, 0, i);
			adjust(nums, i, 0);
			i--;
		}
	}
	public static void main(String[] args) {
		int[] a={4,1,3,2,16,9,10,14,8,7};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

}
