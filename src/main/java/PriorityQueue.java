

/**
 *
 *		优先队列 大顶堆实现
 * 
 * 主要操作：
 * 		insert(int key)
 * 		maximum()
 * 		extractMax()
 * 		increaseKey(int i, int key)
 * 
 * 所有操作都可以在O(lgn)时间内完成
 * 
 * 
 * @author Paine
 *
 */



public class PriorityQueue {
	
	private int[] nums=new int[16];
	private int size=0;
	
	//返回堆顶元素（最大值）
	public int maximum(){
		return nums[0];
	}
	
	//返回堆顶元素（最大值），并且将堆顶元素移除 
	public int extractMax(){
		if(size<1){
			System.out.println("error: 没有元素");
			return -1;
		}
		int max=nums[0];
		nums[0]=nums[size-1];
		size--;
		maxHeapAdjust(nums, 0);
		return max;
	}
	
	//维护大顶堆的性质
	private void maxHeapAdjust(int[] nums, int i){
		int left=2*i+1;
		int right=left+1;
		int max=i;
		while(left<size){
			if(nums[left]>nums[max]){
				max=left;
			}
			if(right<size&&nums[right]>nums[max]){
				max=right;
			}
			if(max!=i){
				int temp=nums[i];
				nums[i]=nums[max];
				nums[max]=temp;
				i=max;
				left=2*i+1;
				right=left+1;
			}else{
				break;
			}
		}
	}
	
	//增加给定索引位元素的值，并重新构成MaxHeap
	public void increaseKey(int i, int key){
		if(key<nums[i-1]){
			System.out.println("error:新值小于原有值");
		}
		nums[i-1]=key;
		int parent=i/2;
		while(parent>0&&nums[parent-1]<nums[i-1]){
			int temp=nums[i-1];
			nums[i-1]=nums[parent-1];
			nums[parent-1]=temp;
			i=parent;
			parent=i/2;
		}
	}
	
	public void insert(int key){
		if(size==16){
			System.out.println("满了");
			return;
		}
		size++;
		increaseKey(size, key);
	}
	
	public void print(){
		for(int i=0; i<size; i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		PriorityQueue q=new PriorityQueue();
		q.print();
		q.insert(3);
		q.insert(9);
		q.insert(9);
		q.insert(9);
		q.insert(9);
		q.insert(9);
		q.insert(3);
		q.insert(7);
		q.insert(9);
		q.insert(53);
		q.insert(9);
		q.insert(7);
		q.insert(45);
		q.insert(354);
		q.insert(456);
		q.insert(7);
		q.increaseKey(16, 457);
		q.print();
		System.out.println(q.extractMax());
		q.print();
		System.out.println(q.extractMax());
		q.print();
		System.out.println(q.extractMax());
		q.print();
		System.out.println(q.extractMax());
		q.print();
		System.out.println(q.extractMax());
		q.print();
		System.out.println(q.extractMax());
		q.print();
		
	}

}
