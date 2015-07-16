package JinDian;

import Arithmetic2.TreeNode;

/**
 * 实现一个函数，查找一棵二叉树是否为二叉查找树
 * @author wangpeng
 * 方法有二：
 * 方法一：
 * 中序遍历，由于二叉排序树的中序遍历是有序的，故有一个全局变量来存储上一个结点内容
 * 每次遍历是需要判断当前结点是否大于上一个结点
 * 方法二：
 * 利用二叉查找树的定义，在二叉查找树中，左边的结点小于当前结点，当前结点大于右边结点
 * 使用前序遍历，在遍历左子树和右子树是需要向其传递最大值和最小值
 */
public class IsBST {
	private static int pre_date = Integer.MIN_VALUE;
	public static boolean isBST1(TreeNode root){
		if(root == null){
			return true;
		}
		
		if(!isBST1(root.left))
			return false;
		
		if(pre_date >= root.val)
			return false;
		pre_date = root.val;
		
		if(!isBST1(root.right))
			return false;
		
		return true;
	}
	
	public static boolean isBST2(TreeNode root,int min,int max){
		if(root == null)
			return true;
		
		if(root.val < min || root.val > max)
			return false;
		
		if(!isBST2(root.left,min,root.val))
			return false;
		if(!isBST2(root.right,root.val,max))
			return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
