package sort;

import java.util.Arrays;

/**
 * 
 * 		计数排序
 * 
 * 不是基于比较的，复杂度为O(k+n)
 * 前提必须是带排序元素范围已知(K)
 * 稳定排序
 * 需要一个辅助数组C[k]
 * 
 * 改进后的虽然节省空间，但是无法保证稳定
 * 
 * @author Paine
 *
 */


public class CountingSort {
	
	public static int[] countingSort_extra(int nums[], int k){
		int n=nums.length;
		int[] re=new int[n];
		int[] C=new int[k+1];
		for(int i=0; i<n; i++){
			C[nums[i]]++;
		}
		for(int i=1; i<C.length; i++){
			C[i]+=C[i-1];
		}
		for(int i=n-1; i>=0; i--){//必须从后向前遍历，才能保证稳定
			re[C[nums[i]]-1]=nums[i];
			C[nums[i]]--;
		}		
		return re;
	}
	
	/*
	 * 计数排序的改进，排序后直接写回原来的数组，但是不能保证稳定
	 */
	public static void countingSort(int[] nums, int k){
		int n=nums.length;
		int[] B=new int[k+1];
		int count=0;
		for(int i=0; i<n; i++){
			B[nums[i]]++;
		}
		for(int i=0; i<=k; i++){
			while(B[i]-->0){
				nums[count++]=i;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,5,4,6,3,2,1,4,8,9,6,5,4,5,2,4,8,2};
		countingSort(nums, 9);
		System.out.println(Arrays.toString(countingSort_extra(nums, 9)));
		
		
	}

}
