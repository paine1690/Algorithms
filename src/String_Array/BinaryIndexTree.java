package String_Array;

import java.util.Random;

/**
 * 		树状数组 （二叉索引树）
 * 			 修改           求某一段值
 * 普通数组：   O(1)     O(n)
 * 树状数组：   O(logn)  O(logn)
 * @author Paine
 *
 */
public class BinaryIndexTree {
	public int len;
	public int[] tree;
	
	/*
	 * 为了统一下标，所以tree[0]不被使用，数组有效范围1~len。
	 */
	public BinaryIndexTree(int len){
		this.len=len;
		tree=new int[len+1];
	}
	
	/*
	 * 计算1~index范围内和
     * index一直减去lowBit(index)，直到index为0
	 */
	
	public int sum(int index){
		if(index<1||index>len){
			return -1;
		}
		int sum=0;
		while(index>0){
			sum+=tree[index];
			index-=lowBit(index);
		}
		return sum;
	}
	
	/*
	 * 计算start~end范围内和
	 */
	public int sum(int start, int end){
		return sum(end)-sum(start-1);
	}
	
	/*
	 * 指定index位置的数值为给定值
	 * index一直加上lowBit(index)，直到index为length。这些位置的值都加上value
	 */	
	public void put(int index, int val){
		if(index<1||index>len){
			return;
		}
		while(index<=len){
			tree[index]+=val;
			index+=lowBit(index);
		}
	}
	
	/*
	 * 获取index位置的数值
	 */
	public int get(int index){
		if(index<1||index>len){
			return -1;
		}
		int sum=tree[index];
		int z=index-lowBit(index);
		index--;
		while(index!=z){
			sum-=tree[index];
			index-=lowBit(index);
		}
		return sum;
	}	
	
	/*
	 * 位运算的经典用法，保留i的二进制最低位1的值。例如，1110保留最低位1即0010.
	 */
	private int lowBit(int i){
		return i&(-i);
	}
	
	
	
	public static void main(String[] args) {
		int length=15;
		BinaryIndexTree bTree=new BinaryIndexTree(length);
        Random random=new Random();
        //随机放满数据
        for (int i = 1; i <= bTree.len; i++) {
            bTree.put(i, random.nextInt(100));
        }
        //取出每一位
        for (int i = 1; i <= bTree.len; i++) {
            int value=bTree.get(i);
            System.out.printf("%3d",value);
            System.out.print("  ");
        }
        System.out.println();
        //计算0~i的和
        for (int i = 1; i <= bTree.len; i++) {
            int sum=bTree.sum(i);

            System.out.printf("%3d",sum);
            System.out.print("  ");
        }
        System.out.println();
        //计算start~end的和
        System.out.printf("%3d",bTree.sum(2,4));

	}

}
