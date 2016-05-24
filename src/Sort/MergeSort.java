package sort;

import java.util.Arrays;

/**
 * 
 * 		归并排序
 * 稳定的排序，优于堆排序与快速
 * 
 * 1、复杂度：最好最坏平均均为O(nlogn)
 * 2、需要额外存储空间O(n)
 * 3、稳定的排序
 * 4、分治策略，Divide and Conquer
 * 5、主要分为划分子表，和合并子表（mergeArray）
 * 6、下面用非递归与递归两种方式实现
 * 
 * @author Paine
 *
 */

public class MergeSort {
	
	
	/*
	 * 非递归写法
	 */
	//将a数组中从first到mid，mid+1到last两个有序数组合并成一个有序数组
	private static void mergeArray(int[] a, int first, int mid, int last, int[] b){
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
	//按照指定步长从a写到b中
	private static void mergeStep(int[] a, int step, int[] b){
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
	
	/*
	 * 递归实现
	 */
	//带回写
	private static void mergeArray2(int[] a, int first, int mid, int last, int[] b){
		int i=first;
		int j=mid+1;
		int k=0;
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
		for(i=0; i<k; i++){
			a[first+i]=b[i];
		}
	}
	public static void mergeSort_recursion(int[] a, int first, int last, int[] b){
		if(first<last){
			int mid=(first+last)/2;
			mergeSort_recursion(a, first, mid, b);
			mergeSort_recursion(a, mid+1, last, b);
			mergeArray2(a, first, mid, last, b);
			System.out.println(Arrays.toString(a));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,5,3,0,2,3,0,3};
		int[] b=new int[a.length];
		mergeSort_recursion(a, 0, a.length-1, b);
		System.out.println(Arrays.toString(a));
	}

}
