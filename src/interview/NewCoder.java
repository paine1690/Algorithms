package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NewCoder {
	
	
	
	public static void getSum(long num, int L){
		int len=(int) Math.sqrt(2*num);
		String re="";
		int min=Integer.MAX_VALUE;
		for(int n=2; n<=len; n++){
			long temp=2*num-n*n;
			if(temp%n==0){
				if((temp/n&1)==1){
					int k=(int) ((temp/n+1)/2);
					//System.out.println(k+"  "+n);
					if(n>=L&&n<min&&n<100){
						min=n;
						int j=0;
						StringBuilder s=new StringBuilder();
						for(; j<n-1; j++){
							s.append(k+j).append(" ");
						}						
						re=s.append(k+j).toString();
					}
				}
			}
		}
		if(re.length()>1){
			System.out.println(re);
		}else{
			System.out.println("No");
		}
	}
	
	
	
	
	static void stuggle(int a, int b, int k){
		if(a%k==0){
			System.out.println(a/k);
			return;
		}
		int re=Integer.MAX_VALUE;
		for(int i=3; i<=a; i+=2){
			int sum1=a*3;
			if(sum1%k==0){
				System.out.println(a/k);
				return;
			}			
			for(int j=2; j<=b; j+=2){
				int sum=sum1+b*j;
				if(sum%k==0){
					if(sum/k<re){
						re=sum/k;
						break;
					}
				}
			}
		}
		System.out.println(re==Integer.MAX_VALUE? -1: re);
	}
	
	
	
	public static List<Integer> printPrime(int n){
		boolean[] prime=new boolean[n+1];
		Arrays.fill(prime, true);
		for(int i=4; i<=n; i+=2){
			prime[i]=false;
		}
		prime[0]=false;
		prime[1]=false;	
		
		int sqrt=(int)Math.sqrt(n);
		for(int i=3; i<=sqrt; i+=2){
			if(prime[i]){
				for(int j=i*i; j<=n; j+=i){
					prime[j]=false;
				}
			}
		}
		List<Integer> re=new ArrayList<Integer>();
		for(int i=0; i<=n; i++){
			if(prime[i]){
				re.add(i);
			}
		}		
		return re;
	}
	
	static void print(int n){
		boolean isNO=true;		
		List<Integer> prime=printPrime(n/2);
		System.out.println(prime);
		for(int i=0; i<prime.size(); i++){
			int p=prime.get(i);			
			for(int q=2; Math.pow(p, q)<=n; q++){				
				if(Math.pow(p, q)==n){
					isNO=false;
					System.out.println(p+" "+q);
				}
			}
		}	
		if(isNO){
			System.out.println("No");
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		if(n<2){
			System.out.println("No");
		}else{
			print(n);
		}
		
		
		
//		Scanner in = new Scanner(System.in);
//		int a = in.nextInt();
//		int b = in.nextInt();
//		int k = in.nextInt();
//		stuggle(a, b, k);
		
//		Scanner in = new Scanner(System.in);
//		while (in.hasNextInt()) {// 注意while处理多个case
//			int a = in.nextInt();
//			int b = in.nextInt();
//			int k = in.nextInt();
//			stuggle(a, b, k);
//		}
	}

}
