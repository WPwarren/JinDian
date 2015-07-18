package JinDian;

import Arithmetic2.BinaryTree;
import Arithmetic2.TreeNode;

/**
 * 寻找下一个结点
 * @author wangpeng
 * 若一个结点有右子树，则右子树的最左边为所求
 * 若没有右子树，找到第一个父结点，父结点满足这个结点是父结点的左子树
 */
public class Successor {
	
	public static int findSucc(TreeNode root, int p) {
        TreeNode node = findNode(root,p);
        if(node != null){
        	if(node.right != null){
        		TreeNode pre = node.right;
        		while(pre.left != null){
        			pre = pre.left;
        		}
        		return pre.val;
        	}else{
        		TreeNode cur = node;
        		TreeNode pre = node.parent;
        		while(pre != null && cur ！= pre.left){
        			cur = pre;
        			pre = pre.parent;
        		}
        		return pre.val;
        	}
        }
        
        return -1;
    }
	private static TreeNode findNode(TreeNode root,int p) {
		if(root == null)
			return null;
		
		if(root.val == p)
			return root;
		
		TreeNode node = findNode(root.left,p);
		if(node == null)
			node = findNode(root.right,p);
		return node;
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] num = {4,2,5,1,3,6};
		tree.buildTree(num);
		findSucc(tree.root, 8);

	}

}
