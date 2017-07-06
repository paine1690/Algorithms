package algorithm.tree;

/**
 * 		线段树（区间树）
 * @author Paine
 *
 */
public class SegmentTree {
	private class TreeNode{
		private int start;
		private int end;
		private int sum;
		TreeNode left, right;
		public TreeNode(int start, int end){
			this.start=start;
			this.end=end;
			this.sum=0;
		}
	}
	
	private TreeNode root;
	private int[] nums;
	
	public SegmentTree(int[] nums){
		this.nums=nums;
		this.root=buildTree(0, nums.length-1);
	}
	
	public void update(int pos, int val){
		update(root, pos, val);
	}
	
	public int sumRange(int start, int end){
		return sumRange(root, start, end);
	}
	
	private int sumRange(TreeNode root, int start, int end){
		if(start>end){
			return 0;
		}
		if(root.start==start&&root.end==end){
			return root.sum;
		}
		int mid=root.start+(root.end-root.start)/2;
		if(end<=mid){
			return sumRange(root.left, start, end);
		}else if(start>mid){
			return sumRange(root.right, start, end);
		}else{
			return sumRange(root.left, start, mid)+sumRange(root.right, mid+1, end);
		}
		
	}
	
	private void update(TreeNode root, int pos, int val){
		if(root==null){
			return;
		}
		if(root.start==pos&&root.end==pos){
			root.sum=val;
			nums[pos]=val;
			return ;
		}
		int mid=root.start+(root.end-root.start)/2;
		if(pos<=mid){
			update(root.left, pos, val);
		}else{
			update(root.right, pos, val);
		}
		root.sum=root.left.sum+root.right.sum;		
	}
	
	private TreeNode buildTree(int start, int end){
		if(start>end){
			return null;
		}
		TreeNode root=new TreeNode(start, end);
		if(start==end){
			root.sum=nums[start];
		}else{
			int mid=start+(end-start)/2;
			root.left=buildTree(start, mid);
			root.right=buildTree(mid+1, end);
			root.sum=root.left.sum+root.right.sum;
		}
		return root;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
