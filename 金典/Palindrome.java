package JinDian;

import java.util.Stack;

import JinDianUtils.ListNode;
import JinDianUtils.MyLinkedList;
/**
 * 检查是否是回文串
 * @author wangpeng
 *
 */
public class Palindrome {

	public static boolean isPalindrome(ListNode pHead) {
//		创建一个栈用来保存前半部分
		Stack<Integer> stack = new Stack<Integer>();
		
//		将前半部分保存到栈中
		ListNode slow = pHead;
		ListNode fast = pHead;
		while(fast!=null && fast.next!=null){
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
//		若为奇数时跳过中间结点
		if(fast!=null){
			slow = slow.next;
		}
		
		while(slow!=null){
			if(stack.pop() == slow.val)
				slow = slow.next;
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MyLinkedList myLink = new MyLinkedList();
		int[] num = {0,1,2,3,2,2,0};
		myLink.addAll(num);
		System.out.print(isPalindrome(myLink.head));
	}

}
