package JinDian;

import java.util.Stack;

public class MyQuery<T> {
	private Stack<T> s1,s2;
	public MyQuery(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void offer(T val){
		s1.push(val);
	}
	
	public T peek(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}
	
	public T remove(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public static void main(String[] args) {
		MyQuery<Integer> myQuery = new MyQuery<Integer>();
		int[] num = {1,2,3,4,5,6,7,8,9};
		for(int i=0;i<num.length;i++){
			myQuery.offer(num[i]);
		}
		
		for(int i=0;i<num.length;i++){
			System.out.print(myQuery.remove() + " ");
		}
	}

}
