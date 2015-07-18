package JinDian;

import java.util.ArrayList;

import Arithmetic.BinTree;
import Arithmetic.TreeNode;
import JinDianUtils.ListNode;
/**
 * 输出单层结点:
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * @author wangpeng
 * 利用树的前序遍历
 * 当到达dep层时，将其加入到list中
 */
public class TreeLevel {

	public ListNode getTreeLevel(TreeNode root,int dep){
		if(root == null )
			return null;
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		treeLevelCode(root,dep,0,list);
		
		ArrayList<TreeNode> list = treeLevelCode(root,dep);
		
		ListNode head = null;
		ListNode cur = null;
		for(int i=0;i<list.size();i++){
			if(cur == null){
				cur = new ListNode(list.get(i).val);
				head = cur;
			}
			else{
				cur.next = new ListNode(list.get(i).val);
				cur = cur.next;
			}
		}
		return head;
	}
	private ArrayList<TreeNode> treeLevelCode(TreeNode root, int dep) {
		ArrayList<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
		
		ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
		cur.add(root);
		
		while(!cur.isEmpty()){
			lists.add(cur);
			if(lists.size() == dep)
				break;
			ArrayList<TreeNode> parent = cur;
			cur = new ArrayList<TreeNode>();
			for(TreeNode node : parent){
				if(node.left != null)
					cur.add(node.left);
				if(node.right != null)
					cur.add(node.right);
			}
		}
		return lists.get(lists.size()-1);
	}
	
	
	
	
	
	
//	private void treeLevelCode1(TreeNode root, int dep,int level,ArrayList<Integer> list) {
//		if(root == null){
//			return ;
//		}
//		
//		if(dep == level){
//			list.add(root.val);
//		}
//		
//		treeLevelCode1(root.left, dep, level+1, list);
//		treeLevelCode1(root.right,dep, level+1, list);
//	}
//	
	
	public static void main(String[] args) {
		BinTree tree = new BinTree();
		int[] data = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,
				15,16,17,18,19,20,21,22,23,24,25,26,27,28,
				29,30,31,32,33,34,35,36,37,38,39,40,41,42,
				43,44,45,46,47,48,49,50,51,52,53,54,55,56,
				57,58,59,60,61,62,63,64,65,66,67,68,69,70,
				71,72,73,74,75,76,77,78,79,80,81,82,83,84,
				85,86,87,88,89,90,91,92,93,94,95,96,97,98,
				99,100,101,102,103,104,105,106,107,108,109,
				110,111,112,113,114,115,116,117,118,119,120,
				121,122,123,124,125,126,127,128,129,130,131,
				132,133,134,135,136,137,138,139,140,141,142,
				143,144,145,146,147,148,149,150,151,152,153,
				154,155,156,157,158,159,160,161,162,163,164,
				165,166,167,168,169,170,171,172,173,174,175,
				176,177,178,179,180,181,182,183,184,185,186,
				187,188,189,190,191,192,193,194,195,196,197,
				198,199,200,201,202,203,204,205,206,207,208,
				209,210,211,212,213,214,215,216,217,218,219,220,
				221,222,223,224,225,226,227,228,229,230,231,232,
				233,234,235,236,237,238,239,240,241,242,243,244,
				245,246,247,248,249,250,251,252,253,254};
		tree.createBinTree(data);
//		tree.preOrderTraverse(tree.nodeList.get(0));
		
		TreeLevel tl = new TreeLevel();
		int dep = 4;
		ListNode head = tl.getTreeLevel(tree.nodeList.get(0), dep);
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}
