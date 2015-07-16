package JinDian;

import java.util.ArrayList;
import java.util.LinkedList;

import Arithmetic2.TreeNode;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有结点的链表
 * @author wangpeng
 * 方法有二：
 * 一、利用深度遍历，即采用二叉树的前序遍历递归
 * 		1、递归方法中有三个参数：节点、结果集合、所在层
 * 			1）获得结点所在层的链表
 * 			2）将结点放入到链表中
 * 		2、递归左子树
 * 		3、递归右子树
 * 二、利用层序遍历
 * 		1、初始第一层链表，根结点作为第一层链表
 * 		2、while循环，直到新生成的链表为空
 * 			3、将链表放入结果集合中
 * 			4、创建一个新的链表
 * 			5、将刚放入结果集中的链表，中的所有结点的子节点放入到正新的链表中。
 */
public class LevelLinkedList {

	/*
	 * 方法一
	 */
	public ArrayList<LinkedList<TreeNode>> levelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		if(root == null)
			return lists;
		levelLinkedList(root,lists,0);
		return lists;
	}
	private void levelLinkedList(TreeNode root,
			ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(root == null)
			return ;
		
//		获取节点所在层的链表，若不存在就创建一个
		LinkedList<TreeNode> cur = null;
		if(lists.size() == level){
			cur = new LinkedList<TreeNode>();
			lists.add(cur);
		}else{
			cur = lists.get(level);
		}
		
//		将节点放入到对应层所在的链表
		cur.add(root);
//		递归左子树
		levelLinkedList(root.left,lists,level+1);
//		递归右子树
		levelLinkedList(root.right,lists,level+1);
	}
	
	/*
	 * 方法二
	 */
	public ArrayList<LinkedList<TreeNode>> levelLinkedList2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		if(root == null)
			return lists;
		
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		if(root!= null){
			cur.add(root);
		}
		
		while(!cur.isEmpty()){
			lists.add(cur);
			LinkedList<TreeNode> parent = cur;
			cur = new LinkedList<TreeNode>();
			for(TreeNode node : parent){
				if(node.left != null)
					cur.add(node);
				if(node.right != null)
					cur.add(node);
			}
		}
		
		return lists;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
