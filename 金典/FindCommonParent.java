package JinDian;

import JinDianUtils.TreeNode;

/**
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * @author wangpeng
 * 思路：
 * 1、若p和q都在node的左边，则第一个共同的结点在node的左子树中找
 * 2、若p和q都在node的右边，则第一个共同的结点在node的右子树中找
 * 3、若p和q都在node的左右两边，则node为所求
 */
public class FindCommonParent {

	public static TreeNode findCommonParent(TreeNode root,TreeNode p,TreeNode q){
		if(!covers(root,p) || !covers(root,q)){
			return null;
		}
		return findCommonCord(root,p,q);
	}
	private static TreeNode findCommonCord(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		
//		判断p和q结点是否都在同一侧
		boolean is_left1 = covers(root.left,p);
		boolean is_left2 = covers(root.left,q);
		
		if(is_left1 == is_left2){
			TreeNode child_side = is_left1 ? root.left:root.right;
			return findCommonCord(child_side, p, q);
		}else{
			return root;
		}
	}
	private static boolean covers(TreeNode root, TreeNode p) {
		if(root == null)
			return false;
		if(root == p)
			return true;
		return covers(root.left,p) || covers(root.right,p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
