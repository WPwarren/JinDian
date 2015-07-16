package JinDian;

import Arithmetic2.TreeNode;

/**
 * 给定一个有序整数数组，元素各有不同且按升序排列，编写一个算法，创建一棵高度最小的二叉查找树
 * @author wangpeng
 * 思路：
 * 创建最小二叉树，即要尽量保证左右子树的节点数相近
 * 1、选取数组的中间结点作为根结点
 * 2、左边为左子树
 * 3、右边为右子树
 * 4、递归处理
 */
public class CreateMinBST {

	public static TreeNode createMinBST(int[] arr){
		if(arr == null || arr.length==0)
			return null;
		return createMinBST(arr,0,arr.length-1);
	}
	public static TreeNode createMinBST(int arr[], int start,int end){
		if(start >= end)
			return null;
		//获取数组的中间结点作为根结点
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		
		//数组的左部分以递归的方式构件左子树
		root.left = createMinBST(arr,start,mid-1);
		//数组的右部分以递归的方式构建右子树
		root.right = createMinBST(arr,mid+1,end);
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
