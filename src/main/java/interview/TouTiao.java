package interview;

import java.util.Scanner;

public class TouTiao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];
		int[] res = new int[q];
		for(int i=0; i<n ;i++){
			A[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}
		int t = 0;
		for(int i=0; i<q; i++){
			int k = 0;
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j=0; j<n; j++){
				if(A[j]>=x && B[j]>=y){
					k++;
				}
			}
			res[t++] = k;
		}
		for(int i=0; i<q; i++){
			System.out.println(res[i]);
		}

	}

}
