package JinDian;

import java.util.Stack;
/**
 * 栈的排序
 * @author wangpeng
 * 1、定义一个栈，该栈用来排序，即栈内是有序的
 * 2、取出s1中的元素val，将val放入到s2中正确的位置
 * 3、知道s1为空为止
 */
public class Sort {

	public static Stack<Integer> sort (Stack<Integer> stack){
		Stack<Integer> temp  = new Stack<Integer>();
		while(!stack.isEmpty()){
			int val = stack.pop();
			
			while(!temp.isEmpty() && temp.peek() > val){
				stack.push(temp.pop());
			}
			temp.push(val);
		}
		
		return temp;
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int[] num = {9,8,3,2,1,7,6,5,4};
		for(int i=0;i<num.length;i++){
			s.push(num[i]);
		}
		s = sort(s);
		while(!s.isEmpty()){
			System.out.print(s.pop());
		}
		
	}

}
