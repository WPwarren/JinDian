package JinDian;

import JinDianUtils.ListNode;
import JinDianUtils.MyLinkedList;
/**
 * 链表分割
 * @author wangpeng
 * 定义两个链表：
 * 一个用来存储小的部分
 * 一个用来存储大的部分
 * 使用前插法
 */
public class Partition {

	public static ListNode partition(ListNode pHead,int x){
		if(pHead == null)
			return null;
		ListNode beforeHead = null;
		ListNode afterHead = null;
		ListNode cur = pHead;
		while(cur != null){
			ListNode next = cur.next;
			if(cur.val < x){
				cur.next = beforeHead;
				beforeHead = cur;
			}else{
				cur.next = afterHead;
				afterHead = cur;
			}
			cur = next;
		}
		
		if(beforeHead == null)
            return afterHead;
		
		ListNode bIndex = beforeHead;
		while(bIndex.next != null)
			bIndex = bIndex.next;
		bIndex.next = afterHead;
		return beforeHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList myLink = new MyLinkedList();
		int[] num = {5,4,3,2,1};
		myLink.addAll(num);
		ListNode newHead = partition(myLink.head, 8);
		myLink.printList(newHead);
	}

}
