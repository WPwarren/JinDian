package JinDian;

public class StackMinAndMax {
	int stackSize = 100;
	int[] stack = new int[stackSize];
	int[] min = new int[stackSize];
	int[] max = new int[stackSize];
	int index = -1;
	int indexMin = -1;
	int indexMax = -1;
	
	public void push(int val){
		if(indexMin < 0 || min[indexMin] >= val){
			indexMin++;
			min[indexMin] = val;
		}
		if(indexMax < 0 || max[indexMax] <= val){
			indexMax++;
			max[indexMax] = val;
		}
		
		if(index + 1 <= stackSize){
			index++;
			stack[index] = val;
		}else{
			throw new RuntimeException("栈已满");
		}
	}
	
	public int pop(){
		if(index < 0){
			throw new RuntimeException("栈已空");
		}
		int val = stack[index];
		index--;
		
		if(val == min[indexMin]){
			indexMin--;
		}
		if(val == max[indexMax]){
			indexMax--;
		}
		
		return val;
	}
	
	public int peek(){
		if(index < 0){
			throw new RuntimeException("栈已空");
		}
		int val = stack[index];
		return val;
	}
	
	public boolean isEmpty(){
		return index < 0;
	}
	
	public int min(){
		if(indexMin < 0){
			throw new RuntimeException("栈已空");
		}
		return min[indexMin];
	}
	
	public int max(){
		if(indexMax < 0){
			throw new RuntimeException("栈已空");
		}
		return max[indexMax];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackMinAndMax s = new StackMinAndMax();
		int[] num = {1,2,5,4,9,7,1,8,0,9};
		for(int i=0;i<num.length;i++){
			s.push(num[i]);
		}
		while(!s.isEmpty()){
			System.out.print("min:"+s.min());
			System.out.println(",max:"+s.max());
			s.pop();
		}
	}

}
