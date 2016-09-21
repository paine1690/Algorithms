import java.util.Arrays;

/**
 * 
 * 		求素数
 * 1.1 判断素数-根据定义
 * 1.2 判断素数优化-去掉偶数
 * 1.3 判断素数优化-求平方根
 * 2.1 素数筛法-求特定范围内所有素数 
 * 2.2 素数筛法优化-线性时间
 * 
 * @author Paine
 *
 */

public class PrimNumber {	
	
	/*
	 * 1.1、根据定义判断：只能被1和本身整除
	 * 判断从1到n
	 * O(n)
	 */
	public static boolean isPrime(int n){
		if(n<2){
			return false;
		}
		for(int i=2; i<n; i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 1.2、改进，去掉偶数判断
	 * 
	 * 如果是偶数，直接返回false
	 * 如果是奇数，判断从3到n所有奇数，速度提高一倍
	 * O(n/2)
	 */
	public static boolean isPrime2(int n){
		if(n<2){
			return false;
		}
		if(n==2){
			return true;
		}
		if((n&1)==0){
			return false;
		}
		for(int i=3; i<n; i+=2){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 1.3、进一步改进
	 * 
	 * 定理：任何数的最大质因数都小于等于它的平方根
	 * 所以，求素数只要到它的平方根就可以
	 * 判断奇偶后从3到sqrt(n)
	 * O(sqrt(n)/2)
	 */
	public static boolean isPrime3(int n){
		if(n<2){
			return false;
		}
		if(n==2){
			return true;
		}
		if((n&1)==0){
			return false;
		}
		int sqrt=(int) Math.sqrt(n);
		for(int i=3; i<=sqrt; i+=2){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 2.1、素数筛法
	 * 
	 * 打印出某范围内所有素数，如果用上述方法，则最快时间复杂度为O(n*sqrt(n)),不够优化
	 * 
	 * 素数筛法：维护一个从1到n的数组
	 * 将所有偶数计为false
	 * 判断素数后标记为true，然后将后面它的倍数全部标记为flase
	 * 
	 * 会有重复的标记
	 */
	public static boolean[] printPrime(int n){
		boolean[] prime=new boolean[n];
		prime[2]=true;
		for(int i=3; i<n; i++){
			if((i&1)!=0){
				prime[i]=true;
			}
		}
		int sqrt=(int)Math.sqrt(n);
		for(int i=3; i<=sqrt; i+=2){
			if(prime[i]){
				for(int j=i*i; j<n; j+=i){
					prime[j]=false;
				}
			}
		}
		
		for(int i=0; i<n; i++){
			if(prime[i]){
				System.out.println(i);
			}
		}
		return prime;
	}
	
	/*
	 * 2.2、素数筛法改进-线性时间
	 * 
	 * prime数组中只存储奇数，prime[i]=2*i+3
	 * 
	 */
	public static void printPrime2(int n){
		int half=n>>1;
		int sqrt=(int)Math.sqrt(n);
		boolean[] prime=new boolean[half];
		Arrays.fill(prime, true);
		for(int i=0; i<=sqrt; i++){
			if(prime[i]){
				int k=i+i+3;		//k=2*i+3,即i对应的素数
				for(int j=2*i*i+6*i+3; j<half; j+=k){
					//起点是k的平方，即2*j+3=k*k,然后依次递增k
					prime[j]=false;
				}
			}
		}
		System.out.println(2);//2也是素数
		for(int i=0; i<half; i++){
			if(prime[i]&&2*i+3<n){
				System.out.println(2*i+3);
			}
		}
	}
	public static void main(String[] args) {
		printPrime2(86);

	}

}
