package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * 		快速排序
 * 基于比较的内部排序中最好的方法，当待排序元素随机分布时，快速排序的平均时间最短
 * 
 * 1、复杂度：最坏情况会O(n^2)，但是平均性能O(nlgn)
 * 2、空间复杂度：O(lgn),递归栈。最坏情况下O(n)
 * 3、不是稳定排序
 * 
 * @author Paine
 *
 */


public class QuikSort {
	
	/*
	 * 数组划分  算法导论书上的版本
	 * 将nums数组从p到r进行原址重排，nums[p...q-1]<nums[q]<nums[q+1...r]
	 * 
	 * 过程：
	 * 选取x=nums[r]为主元
	 * 数组中p到i部分全部小于x，i+1到j部分全部大于x
	 * 
	 */
//	private static int partition1(int[] nums, int p, int r){
//		int x=nums[r];
//		int i=p-1;
//		int temp;
//		for(int j=p; j<r; j++){
//			if(nums[j]<=x){
//				i++;
//				temp=nums[i];
//				nums[i]=nums[j];
//				nums[j]=temp;
//			}
//		}
//		temp=nums[i+1];
//		nums[i+1]=nums[r];
//		nums[r]=temp;
//		return i+1;
//	}
	
	/*
	 * 数组划分  网上的方法
	 * 过程：
	 * 选取x=nums[l]为主元
	 * 数组中l到i部分全部小于x，i+1到j部分全部大于x
	 * 
	 */
	private static int partition2(int[] nums, int l, int r){
		int i=l, j=r;
		int x=nums[i];
		while(i<j){
			while(i<j&&nums[j]>=x){
				j--;
			}
			if(i<j){
				nums[i++]=nums[j];
			}
			while(i<j&&nums[i]<x){
				i++;
			}
			if(i<j){
				nums[j--]=nums[i];
			}
		}
		nums[i]=x;
		return i;
	}
	
	/*
	 * 随机化版优化
	 * 
	 * 每次都选取nums[r]作为主元，如果数组有序，会影响性能
	 * 所以在partition的时候从p到r随机选取一个主元，在平均情况下，性能会有提升
	 */
	
	private static int randomPartition(int[] nums, int p, int r){
		Random rand=new Random();
		int i=rand.nextInt(r-p)+p;
		System.out.println(i);
		
//		调用partition1(),nums[r]为主元
//		int temp=nums[i];
//		nums[i]=nums[r];
//		nums[r]=temp;
//		return partition1(nums, p, r);
		
		
		int temp=nums[i];
		nums[i]=nums[p];
		nums[p]=temp;
		return partition2(nums, p, r);
	}
	
	
	//循环调用
	private static void quik(int[] nums, int p, int r){
		if(p<r){
			int i=randomPartition(nums, p, r);
			System.out.println(Arrays.toString(nums));
			quik(nums, 0, i-1);
			quik(nums, i+1, r);
		}
	}
	
	//第一次调用，从0到len-1
	public static void quikSort(int[] nums){
		quik(nums, 0, nums.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={54,21,73,84,60,18,62,59,89,89,41,55,27,65,94,61,12,76,35,48,0,60,84,9,28,55,4,67,86,33};
		quikSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
