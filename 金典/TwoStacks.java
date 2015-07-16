package JinDian;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacks {

	public static ArrayList<Integer> twoStackSort(int[] numbers){
		ArrayList<Integer> stack = new ArrayList<Integer>();
		if(numbers == null || numbers.length == 0){
			return stack;
		}
		Stack<Integer> temp = new Stack<Integer>();
		
		for(int i=0;i<numbers.length;i++){
			if(stack.isEmpty()){
				stack.add(numbers[i]);
			}else{
				while(!stack.isEmpty() && stack.get(stack.size()-1) < numbers[i]){
					int num = stack.get(stack.size() - 1);
					temp.push(num);
					stack.remove(stack.size() - 1);
				}
				stack.add(numbers[i]);
				while(!temp.isEmpty()){
					stack.add(temp.pop());
				}
			}
		}
		
		return stack;
	}
	public static void main(String[] args) {
		int[] num = {5,4,3,2,7,9,0,11};
		System.out.print(twoStackSort(num));

	}
}
