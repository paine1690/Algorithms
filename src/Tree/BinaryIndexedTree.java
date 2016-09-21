package Tree;

/**
 * 		树状数组 （二叉索引树）
 * 			 修改           求某一段值
 * 普通数组：   O(1)     O(n)
 * 树状数组：   O(logn)  O(logn)
 * @author Paine
 *
 */
public class BinaryIndexedTree {
	private int[] nums;
	private int[] tree;
	private int len;
	
	/*
	 * 为了统一下标，所以tree[0]不被使用，数组有效范围1~len。
	 */
	public BinaryIndexedTree(int[] nums){
		this.nums=nums;
    	len=nums.length;
    	tree=new int[len+1];
    	for(int i=0; i<nums.length; i++){
    		add(i+1, nums[i]);
    	}
	}

	
	/*
	 * 计算1~index范围内和
     * index一直减去lowBit(index)，直到index为0
	 */
	
	public int sumRange(int index){
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
	public int sumRange(int start, int end){
		return sumRange(end+1)-sumRange(start);
	}
	
	/*
	 * 指定index位置的数值为给定值
	 */	
    public void update(int i, int val) {
    	int diff=val-nums[i];
    	nums[i]=val;
    	add(i+1, diff);
    }
	
	/*
	 * 位运算的经典用法，保留i的二进制最低位1的值。例如，1110保留最低位1即0010.
	 */
	private int lowBit(int i){
		return i&(-i);
	}

	
    private void add(int index, int val){
    	while(index<=len){
        	tree[index]+=val;
        	index+=lowBit(index);
        }
    }
    
	
	public static void main(String[] args) {


	}

}
