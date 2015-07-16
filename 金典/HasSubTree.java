package JinDian;

import JinDianUtils.TreeNode;

/**
 * 判断树A是否为树B的子树
 * @author wangpeng
 * 采用前序遍历
 */
public class HasSubTree {

	public static boolean hasSubTree(TreeNode root1,TreeNode root2){
		boolean result = false;
		if(root1 != null && root2 != null){
			if(root1.val == root2.val)
				result = isSubTree(root1,root2);
			if(!result)
				result = hasSubTree(root1.left,root2);
			if(!result)
				result = hasSubTree(root1.right,root2);
		}
		return result;
	}
	private static boolean isSubTree(TreeNode root1, TreeNode root2) {
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		
		return isSubTree(root1.left,root2.left) && isSubTree(root1.right, root2.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
