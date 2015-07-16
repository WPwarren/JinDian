package JinDian;

import Arithmetic2.TreeNode;

public class Balance {

	public boolean isBalance(TreeNode root) {
        if(root == null )
        	return false;
        Integer deep = 0;
        return isBalance(root, deep);
    }
	private boolean isBalance(TreeNode root, Integer deep) {
		if(root == null){
			deep = 0;
			return true;
		}
		
		Integer left = 0;
		Integer right = 0;
		if(isBalance(root.left,left) && isBalance(root.right,right)){
			int dis = left - right;
			if(dis < 1 && dis > -1){
				deep = Math.max(left, right);
				return true;
			}
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
