package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 		二叉树
 * 
 * 1、二叉树遍历
 * 		先序、中序、后序、层序遍历，递归与非递归实现
 * 2、树的深度
 * 3、反转二叉树
 * 4、根据两种遍历确定二叉树
 * 
 * @author Paine
 *
 */
public class BinaryTree {
	
	//1.1.1 先序遍历 递归实现
    private static void preOrder(TreeNode root, List<Integer> re){
    	if(root!=null){
        	re.add(root.val);
        	preOrder(root.left, re);
        	preOrder(root.right, re);
    	}
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> re=new ArrayList<Integer>();
        preOrder(root, re);
        return re;
    }
    
    //1.2.1 中序遍历 递归实现
    private void inOrder(TreeNode root, List<Integer> re){
    	if(root!=null){
        	inOrder(root.left, re);
        	re.add(root.val);
        	inOrder(root.right, re);
    	}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> re=new ArrayList<Integer>();
    	inOrder(root, re);
        return re;
    }
    
    //1.3.1 后序遍历 递归实现
    private static void postOrder(TreeNode root, List<Integer> re){
    	if(root!=null){
    		postOrder(root.left, re);
    		postOrder(root.right, re);
    		re.add(root.val);
    	}
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> re=new ArrayList<Integer>();
        postOrder(root, re);
        return re;
    }
    
    
    //1.4.1 层序遍历 递归实现
    private static void level(List<List<Integer>> re, Queue<TreeNode> p, Queue<TreeNode> q){
    	List<Integer> level=new ArrayList<Integer>();
    	while(!p.isEmpty()){
    		TreeNode temp=p.poll();
    		level.add(temp.val);
    		if(temp.left!=null)		q.offer(temp.left);
    		if(temp.right!=null)	q.offer(temp.right);
    	}
    	re.add(level);
    	if(!q.isEmpty()){
    		level(re, q, p);
    	}
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> re=new ArrayList<List<Integer>>();
        if(root==null){
    		return re;
    	}
    	Queue<TreeNode> p=new LinkedList<TreeNode>();
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	p.offer(root);
    	level(re, p, q);
    	return re;
    }
	
    //1.4 层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> re=new ArrayList<List<Integer>>();
        if(root==null){
    		return re;
    	}
    	Queue<TreeNode> p=new LinkedList<TreeNode>();
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	p.offer(root);
    	level(re, p, q);
    	Collections.reverse(re);
    	return re;
    }
    
    //2 树的深度
    public static int maxDepth(TreeNode root) {
    	if(root==null){
			return 0;
		}
		return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
    
    //3 反转二叉树
    public TreeNode invertTree(TreeNode root) {
    	if(root==null){
    		return root;
    	}
        TreeNode temp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=temp;
        return root;
    }
    
    //4.1 先序和中序 确定二叉树
    private static int getIndex(int[] nums, int start, int end, int num){
    	for(int i=start; i<=end; i++){
    		if(nums[i]==num){
    			return i;
    		}
    	}
    	return -1;
    }
    private static TreeNode build(int[] inorder, int start, int end, int pre[], int index){
    	TreeNode root=null;
    	if(start<=end){
    		root=new TreeNode(pre[index]);
    		if(start!=end){
    			int mid=getIndex(inorder, start, end, pre[index]);
        		root.left=build(inorder, start, mid-1, pre, index+1);
            	root.right=build(inorder, mid+1, end, pre, index+1+mid-start);
    		}
    	}
    	return root;    	
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder, 0, preorder.length-1, preorder, 0); 
    }
    
    //4.2 中序和后序 确定二叉树
    private static TreeNode build2(int[] inorder, int start, int end, int[] postorder, int index){
    	TreeNode root=null;
    	if(start<=end){
    		root=new TreeNode(postorder[index]);
    		if(start!=end){
    			int mid=getIndex(inorder, start, end, postorder[index]);
    			root.right=build2(inorder, mid+1, end, postorder, index-1);
    			root.left=build2(inorder, start, mid-1, postorder, index-1-end+mid);
    		}
    	}
    	return root;
    }
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return build2(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
    
	public static void main(String[] args) {
		

	}

}
