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
			int mid=i+(j-i)/2;
			if(nums[mid]>=target){
				j=mid-1;
			}else{
				i=mid+1;
			}
		}
		return j+1;
	}

	public static int lengthOfLIS(int[] nums){
		if(nums.length<2){
			return nums.length;
		}
		int[] d=new int[nums.length];
		d[0]=nums[0];
		int len=0;
		
		for(int i=1; i<nums.length; i++){
			if(nums[i]>d[len]){
				d[++len]=nums[i];
			}else{
				int index=binarySearch(d, 0, len, nums[i]);
				d[index]=nums[i];
			}
		}	
		
		return len+1;
		
	}
	
	
	public static void main(String[] args) {
		int nums[]={10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}

}
