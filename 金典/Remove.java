package JinDian;

import Arithmetic2.ListNode;

public class Remove {

	public static boolean removeNode(ListNode pNode){
		if(pNode.next == null)
			return false;
		ListNode pNext = pNode.next;
		int temp = pNode.val;
		pNode.val = pNext.val;
		pNext.val = temp;
		pNode.next = pNext.next;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
