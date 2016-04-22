package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * 		二叉树
 * 
 * 1、二叉树遍历
 * 		先序、中序、后序、层序遍历，递归与非递归实现
 * 2、树的最大深度与最小深度
 * 3、反转二叉树 递归与非递归实现
 * 4、根据两种遍历确定二叉树（必须有中序遍历）
 * 5、判断平衡二叉树
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
    
    //1.1.2 先序遍历 非递归实现 堆栈
    public static List<Integer> preorderTraversal2(TreeNode root){
    	List<Integer> re=new ArrayList<Integer>();
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode node=root;
    	while(node!=null||!stack.isEmpty()){
    		while(node!=null){
    			re.add(node.val);
    			stack.push(node);
    			node=node.left;
    		}
    		if(!stack.isEmpty()){
    			node=stack.pop();
    			node=node.right;
    		}
    	}
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
    
    //1.2.2 中序遍历 非递归实现 堆栈
    public List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> re=new ArrayList<Integer>();
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode node=root;
    	while(node!=null||!stack.isEmpty()){
    		while(node!=null){
    			stack.push(node);
    			node=node.left;
    		}
    		if(!stack.isEmpty()){
    			node=stack.pop();
    			re.add(node.val);
    			node=node.right;
    		}
    	}
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
    
    //1.3.2 后序遍历 非递归实现 堆栈
    public List<Integer> postorderTraversal2(TreeNode root) {
    	List<Integer> re=new ArrayList<Integer>();
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode node=root;
    	while(node!=null||!stack.isEmpty()){
    		while(node!=null){
    			stack.push(node);
    			node=node.left;
    		}
    		if(!stack.isEmpty()){
    			if(stack.peek().right==null){
    				re.add(stack.pop().val);
    			}else{
    				node=stack.peek().right;
    				stack.peek().right=null;
    			}
    		}
    	}
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
    
    //2.1 树的深度 最大深度
    public static int maxDepth(TreeNode root) {
    	if(root==null){
			return 0;
		}
		return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
    
    //2.2 树的最小深度
    public static int minDepth(TreeNode root) {
        if(root==null){
			return 0;
		}else if(root.left==null&&root.right==null){
        	return 1;
        }else if(root.left==null){
        	return minDepth(root.right)+1;
        }else if(root.right==null){
        	return minDepth(root.left)+1;
        }else{
        	return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
        }
    }
    //3.1 反转二叉树 递归实现
    public TreeNode invertTree(TreeNode root) {
    	if(root==null){
    		return root;
    	}
        TreeNode temp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=temp;
        return root;
    }
    
    //3.2 反转二叉树 非递归实现
    public TreeNode invertTree2(TreeNode root){
    	if(root==null){
    		return root;
    	}
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		TreeNode node=queue.poll();
    		TreeNode temp=node.left;
    		node.left=node.right;
    		node.right=temp;
    		if(node.left!=null){
    			queue.offer(node.left);
    		}
    		if(node.right!=null){
    			queue.offer(node.right);
    		}
    	}
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
    
    //5.1 平衡二叉树 两边递归
    public boolean isBalanced(TreeNode root) {
        if(root==null){
        	return true;
        }
        if(root.left==null&&root.right==null){
        	return true;
        }
    	if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
    		return false;
    	}
    	return isBalanced(root.left)&&isBalanced(root.right);
    }
    
    //5.2 平衡二叉树 先用遍历一遍将深度信息存在val上
    private static int getDeep(TreeNode root){
    	if(root==null){
    		return 0;
    	}
    	root.val=Math.max(getDeep(root.left)+1, getDeep(root.right)+1);
    	return root.val;
    }
    private static boolean dfs(TreeNode root){
    	if(root==null){
        	return true;
        }
        if(root.left==null&&root.right==null){
        	return true;
        }
        int l=0, r=0;
        if(root.left!=null){
        	l=root.left.val;
        }
        if(root.right!=null){
        	r=root.right.val;
        }
    	if(Math.abs(l-r)>1){
    		return false;
    	}
    	return dfs(root.left)&&dfs(root.right);
    }
    public boolean isBalanced2(TreeNode root) {
       getDeep(root);
       return dfs(root);
    }
    
    
    
    
	public static void main(String[] args) {
		

	}

}
