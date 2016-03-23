package Sort;
import java.util.Arrays;

public class Sort {
	/*
	 * 计数排序
	 * 1、不是基于比较的，复杂度为O(k+n)
	 * 2、前提必须是带排序元素范围已知(K)
	 * 3、稳定排序
	 * 4、需要一个辅助数组C[k]
	 */
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
	
	/*
	 * 归并排序
	 * 非递归写法
	 */
	
	//将a数组中从first到mid，mid+1到last两个有序数组合并成一个有序数组
	public static void mergeArray(int[] a, int first, int mid, int last, int[] b){
		int i=first;
		int j=mid+1;
		int k=first;
		while(i<=mid&&j<=last){
			if(a[i]<a[j]){
				b[k++]=a[i++];
			}else{
				b[k++]=a[j++];
			}
		}
		while(i<=mid){
			b[k++]=a[i++];
		}
		while(j<=last){
			b[k++]=a[j++];
		}
	}
	//按照制定步长从a写到b中
	public static void mergeStep(int[] a, int step, int[] b){
		int len=a.length;
		int first=0;
		int mid=first+step-1;
		int last=mid+step;
		while(last<len){
			mergeArray(a, first, mid, last, b);
			first=last+1;
			mid=first+step-1;
			last=mid+step;
		}
		if(mid>=len){//剩余元素已经有序 
			for(int i=first; i<len; i++){
				b[i]=b[i];
			}
		}else{//mid到len-1无序 所以要从first到len-1 
			mergeArray(a, first, mid, len-1, b);
		}
	}
	
	public static void mergeSort(int[] a){
		int len=a.length;
		int[] b=new int[len];
		int flag=0;
		
		for(int step=1; step<len; step=step<<1){
			if(flag++%2==1){//奇数次，从a写到b
				mergeStep(b, step, a);
			}else{//偶数次，从b写回a
				mergeStep(a, step, b);
			}
		}
		if(flag%2==1){
			for(int i=0; i<len; i++){
				a[i]=b[i];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,5,3,0,2,3,0,3};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

}
