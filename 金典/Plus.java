package JinDian;

import JinDianUtils.ListNode;
import JinDianUtils.MyLinkedList;


public class Plus {

	public static ListNode plusAB(ListNode a, ListNode b){
		return plusCode(a,b,0);
	}
	private static ListNode plusCode(ListNode a, ListNode b, int carry) {
		if(a == null && b == null && carry ==0)
			return null;
		ListNode result = new ListNode(0);
		int val = carry;
		
		if(a != null)
			val += a.val;
		
		if(b != null)
			val += b.val;
		
		result.val = val % 10;
		
		ListNode more = plusCode(a==null?null:a.next,
								 b==null?null:b.next,
								 val >=10 ? 1:0);
		result.next = more;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {7,1,6};
		int[] num2 = {5,9,2};
		MyLinkedList list1 = new MyLinkedList();
		list1.addAll(num1);
		MyLinkedList list2 = new MyLinkedList();
		list2.addAll(num2);
		
		ListNode head =plusAB(list1.head, list2.head);
		MyLinkedList.printList(head);
	}

}
