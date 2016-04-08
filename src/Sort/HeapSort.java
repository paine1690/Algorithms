package Sort;

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
	
	/*
	 * 筛选法建最大堆
	 * 时间复杂度O(n)
	 * 
	 * 从length/2-1开始调整，直至跟节点 
	 * 比较i的左右孩子，依次向下调整直至最低层
	 * 注意数组是从0开始的，所以左孩子节点是2*i+1 
	 */
	private static void heapBuild(int[] nums,int len){
		for(int i=len/2-1; i>=0; i--){//从length开始调整直至根节点
			int j=i;
			int max=j;
			int left=2*j+1;
			int right=left+1;
			
			while(left<len){//维护对的性质，O(h)树的高度
				if(nums[left]>nums[max]){
					max=left;
				}
				if(right<len&&nums[right]>nums[max]){
					max=right;
				}
				if(max!=j){
					int temp=nums[j];
					nums[j]=nums[max];
					nums[max]=temp;
					j=max;
					left=2*j+1;
					right=left+1;
				}else{
					break;
				}
			}
		}
	}
	
	public static void heapSort(int[] nums){
		int len=nums.length;
		int temp;
		while(len>1){
			heapBuild(nums, len);
			temp=nums[len-1];
			nums[len-1]=nums[0];
			nums[0]=temp;
			len--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,1,3,2,16,9,10,14,8,7};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

}
