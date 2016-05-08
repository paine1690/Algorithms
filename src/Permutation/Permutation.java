package Permutation;
import java.util.Arrays;

/**
 * 		全排列问题
 * 
 * @author Paine
 *
 */
public class Permutation {

	private static void swap(int[] nums, int a, int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
	
	
	public static void permute(int[] nums){
		perm(nums, 0, nums.length-1);
		perm2(nums, 0, nums.length-1);
	}
	
	//1、递归实现
	private static void perm(int[] nums, int start, int end){
		if(start==end){
			System.out.println(Arrays.toString(nums));
		}else{
			for(int i=start; i<=end; i++){
				swap(nums, start, i);
				perm(nums, start+1, end);
				swap(nums, start, i);
			}
		}
	}
	
	//2、递归实现 防止重复元素  第i个数与第j个数交换时，要求[i,j)中没有与第j个数相等的数
	private static boolean isSwap(int[] nums, int i, int j){
		for(int k=i; k<j; k++){
			if(nums[k]==nums[j]){
				return false;
			}
		}
		return true;
	}
	
	private static void perm2(int[] nums, int start, int end){
		if(start==end){
			System.out.println(Arrays.toString(nums));
		}else{
			for(int i=start; i<=end; i++){
				if(isSwap(nums, start, i)){
					swap(nums, start, i);
					perm2(nums, start+1, end);
					swap(nums, start, i);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums={1,2,2};
		permute(nums);
	}

}
