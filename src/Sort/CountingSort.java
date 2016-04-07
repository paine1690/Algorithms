package Sort;

/*
 * 计数排序
 * 1、不是基于比较的，复杂度为O(k+n)
 * 2、前提必须是带排序元素范围已知(K)
 * 3、稳定排序
 * 4、需要一个辅助数组C[k]
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
		for(int i=0; i<n; i++){
			re[C[nums[i]]-1]=nums[i];
			C[nums[i]]--;
		}		
		return re;
	}
	/*
	 * 计数排序的改进，排序后直接写会原来的数组
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

	}

}
