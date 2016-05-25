package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 		桶排序
 * 
 * 
 * @author Paine
 *
 */

public class BucketSort {
	@SuppressWarnings("unchecked")
	private static List<Double>[] bucket=new List[10];
	
	public static void bucketSort(double[] nums){
		int len=nums.length;
		
		for(int i=0; i<len; i++){
			int index=(int)Math.floor(nums[i]*10);
			if(bucket[index]==null){
				bucket[index]=new ArrayList<Double>();
			}
			bucket[index].add(nums[i]);
		}
		
		for(int i=0; i<bucket.length; i++){
			if(bucket[i]!=null){
				Collections.sort(bucket[i]);;
			}
		}
		
		int count=0;
		for(int i=0; i<bucket.length; i++){
			if(bucket[i]!=null){
				System.out.println(bucket[i]);
				Iterator<Double> ite=bucket[i].iterator();
				while(ite.hasNext()){
					nums[count++]=ite.next();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		double[] nums={0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		bucketSort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
