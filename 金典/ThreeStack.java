package JinDian;

public class ThreeStack {

	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackTop = {-1,-1,-1};
	
	public void push(int stackNum,int val){
		if(stackTop[stackNum] + 1 >= stackSize){
			throw new RuntimeException("数组越界");
		}
		stackTop[stackNum]++;
		buffer[absTopOfStack(stackNum)] = val;
	}
	

	public int pop(int stackNum){
		if(stackTop[stackNum] < 0){
			throw new RuntimeException("数组越界");
		}
		int val = buffer[absTopOfStack(stackNum)];
		stackTop[stackNum]--;
		return val;
	}
	
	public int peek(int stackNum){
		return buffer[absTopOfStack(stackNum)];
	}
	
	public boolean isEmpty(int stackNum){
		if(stackTop[stackNum] == -1)
			return true;
		else
			return false;
	}
	
	private int absTopOfStack(int stackNum) {
		return stackSize * stackNum + stackTop[stackNum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
