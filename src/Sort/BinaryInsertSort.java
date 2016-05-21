package Sort;

import java.util.Arrays;

/**
 * 
 * 		二分排序
 * 
 * 原理类似与插入排序，将元素插入已排序元素时采用二分查找来确定插入的位置
 * 
 * @author Paine
 *
 */
public class BinaryInsertSort {
	public static void binaryInsertSort(int[] nums){
		int low, high, val;
		for(int i=1; i<nums.length; i++){
			low=0; 
			high=i-1;
			val=nums[i];
			while(low<=high){
				int mid=(low+high)>>>1;
				if(nums[mid]>val){
					high=mid-1;
				}else{
					low=mid+1;
				}
			}
			for(int j=i-1; j>high; j--){
				nums[j+1]=nums[j];
			}
			nums[high+1]=val;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={8,4,4,1,4,5,4,65,31,4,86,456};
		binaryInsertSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
