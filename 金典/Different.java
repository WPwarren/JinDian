package JinDian;
/**
 * 确定字符互异
 * @author wangpeng
 * 两种方法：
 * 方法一：使用boolean数组，标记被访问的字符
 * 方法二：有用位运算来节省空间
 */
public class Different {
	/*
	 * 256个字符：使用boolean数组
	 */
	public static boolean checkDifferent(String iniString){
		boolean[] visited = new boolean[256];
		boolean result = true;
		int index ;
		for(int i=0;i<iniString.length();i++){
			index = iniString.charAt(i);
			if(visited[index]){
				result = false;
				break;
			}else{
				visited[index] = true;
			}
		}
		return result;
	}
	/*
	 * 使用位来标记：由于int只有32位，故这个方法只适用于标记个数小于32的
	 */
	public static boolean checkDifferern2(String iniString){
		int flag = 0;
		int val = 0;
		boolean result = true;
		for(int i=0;i<iniString.length();i++){
			val = iniString.charAt(i);
			if((flag & (1<<val)) != 0){
				result = false;
				break;
			}else{
				flag |= (1<<val);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aoeiou";
		System.out.print(checkDifferern2(s));
	}

}
