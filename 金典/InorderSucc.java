package JinDian;

import JinDianUtils.TreeNode;


/**
 * 找出二叉查找树中指定结点的“下一个”结点，每个节点都有指向父结点的指针
 * @author wangpeng
 * 公式：
 * 指定结点有右子树，则右子树中最左边的为所求
 * 指定结点无右子树，若为不是父结点的左孩子，则一直向上找，直到找到为止，返回父结点
 */
public class InorderSucc {

	public static TreeNode inorderSucc(TreeNode node){
		if(node == null)
			return null;
//		如果有右子树，则为右子树最左结点
		if(node.right != null){
			return leftMostChild(node.right);
		}else{
//			如果不是父结点的左孩子，则一直向上找，父结点为所求
			TreeNode cur = node;
			TreeNode par = node.parent;
			while(par != null && par.left != cur){
				cur = par;
				par = par.parent;
			}
			return par;
		}
		
	}
	private static TreeNode leftMostChild(TreeNode node) {
		while(node.left != null)
			node = node.left;
		return node;
	}
	public static void main(String[] args) {

	}

}
