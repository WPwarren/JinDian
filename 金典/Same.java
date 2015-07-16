package JinDian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 确定两串乱序同构
 * @author wangpeng
 *
 */
public class Same {

	/*
	 * 排序法，效率不高
	 */
	public static boolean checkSam(String stringA,String stringB){
		if(stringA.length() != stringB.length())
			return false;
		return sort(stringA).equals(sort(stringB));
	}
	private static String sort(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	/*
	 * 利用特点：
	 * 乱序同构的两个字符串，长度相等，字符一样，个数一样
	 */
	public static boolean checkSam2(String stringA,String stringB){
		if(stringA == null || stringB==null)
			return false;
		if(stringA.length() != stringB.length()){
			return false;
		}
		int[] check = new int[256];
		char[] strA = stringA.toCharArray();
//		统计stringA
		for(int i=0;i<strA.length;i++){
			check[strA[i]]++;
		}
//		统计stringB
		char[] strB = stringB.toCharArray();
		for(int i=0;i<strB.length;i++){
			check[strB[i]]--;
			if(check[strB[i]] < 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Here you are";
		String s2 = "Are you Here";
		System.out.print(checkSam2(s1,s2));
	}

}
