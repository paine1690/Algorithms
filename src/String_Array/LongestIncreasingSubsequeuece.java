package String_Array;

/**
 * 
 * 最长递增子序列
 * 
 * O(nlogn)
 * @author Paine
 *
 */

public class LongestIncreasingSubsequeuece {

	private static int binarySearch(int[] nums, int i, int j, int target){
		while(i<=j){
			int mid=(i+j)>>>1;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]<target){
				i=mid+1;
			}else{
				j=mid-1;
			}
		}
		return ++j;
	}
	
	public static int lengthOfLIS(int[] nums){
		if(nums.length<2){
			return nums.length;
		}
		int d[]=new int[nums.length+1];
		d[0]=Integer.MIN_VALUE;
		int len=0;
		for(int i=0; i<nums.length; i++){
			if(nums[i]>d[len]){
				d[++len]=nums[i];
			}else{
				int index=binarySearch(d, 1, len, nums[i]);
				d[index]=nums[i];
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		int nums[]={1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(nums));
	}

}
