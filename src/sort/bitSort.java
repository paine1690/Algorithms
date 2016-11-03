package sort;

import java.util.Arrays;

/**
 * 		位图排序
 * 编程珠玑第一章
 * 使用：海量数据，每个元素只出现一次。
 * 1000万个数
 * @author Paine
 *
 */
public class bitSort {

	private static int[] a=new int[10000000/32+1];

	/*
	 * 设置位数组中的从0开始的第i位为1
	 * i>>5，即i/32,因为一个int是32位，表示i在数组中地几个int中
	 * 1<<(i&0x1F) i&0x1F取低5位，即对32取余。表示在这个数的第几位
	 */
	private static void set(int i){
		a[i>>5]|=(1<<(i&0x1F));
	}
	
	private static int get(int i){	
		return a[i>>5]&(1<<(i&0x1F));
	}
	
	private static void clear(int i){
		a[i>>5]&=~(1<<(i&0x1F));
	}
	
	private static void sort(int[] nums){
		for(int num: nums){
			set(num);
		}
		for(int i=0; i<10000000; i++){
			if(get(i)!=0){
				System.out.println(i);
			}
			clear(i);
		}		
	}
	
	public static void main(String[] args) {
		int[] nums={8,6,1,3,4,45,78,12,5,48,789,456,129};
		sort(nums);
		
	}

}
