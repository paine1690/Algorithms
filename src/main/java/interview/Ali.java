package interview;

import java.util.Arrays;

public class Ali {
	
    static boolean resolve(int[] A) {
    	int len=A.length;
    	int[] sum1=new int[len];
    	int[] sum2=new int[len];
    	sum1[0]=A[0];
    	for(int i=1; i<A.length; i++){
    		sum1[i]=A[i]+sum1[i-1];
    	}
    	sum2[len-1]=A[len-1];
    	for(int i=len-2; i>=0; i--){
    		sum2[i]=A[i]+sum2[i+1];
    	}
    	System.out.println(Arrays.toString(sum1));
    	System.out.println(Arrays.toString(sum2));
    	
    	return judge(sum1, sum2, len);
    }
	
    static boolean judge(int[] sum1, int[] sum2, int len){
    	int i=0, j=len-1;
    	while(i<j){
    		int sumBefore=sum1[i];
    		int sumAfter=sum2[j];
    		if(sumBefore<sumAfter){
    			i++;
    		}else if(sumBefore>sumAfter){
    			j--;
    		}else{
    			if(juedge2(sum1, sum2, i+1, j-1, sumBefore)){
    				return true;
    			}
    			i++;
    			j--;    
    			
    		}
    	}    	
    	return false;
    }
    
    static boolean juedge2(int[] sum1, int[] sum2, int start, int end, int target){
    	for(int i=start+1; i<end; i++){
    		int sumBefore=sum1[i-1]-sum1[start];
    		int sumAfter=sum2[i+1]-sum2[end]; 
    		if(sumBefore==sumAfter&&target==sumAfter){
    			return true;
    		}
    	}
    	return false;
    }
    
	public static void main(String[] args) {
        System.out.println(resolve(new int[]{1,2,1,1,1,1,1,1,1,1,1,2,1}));
	}
	
}
