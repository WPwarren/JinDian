package JinDian;

import java.util.HashMap;
import JinDianUtils.ListNode;


public class DeleteDups {

	public static void deleteDups(ListNode n){
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		ListNode pre = null;
		while(n != null){
			if(map.containsKey(n.val)){
				pre.next = n.next;
			}else{
				map.put(n.val, true);
				pre = n;
			}
			n = n.next;
		}
	}
	public static void main(String[] args) {
		
	}

}
