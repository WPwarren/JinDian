package JinDian;

import java.util.HashMap;

/**
 * 给定两个32位的整数N与M，以及表示比特位置的i与j。
 * 编写一个方法，将M插入N，使得M从N的第j位开始，到底i位结束。
 * @author wangpeng
 * 方法：
 * 1、将N的2进制表示中，第i~第j位清0；
 * 2、将M移到第i位
 * 3、N和M合并
 */
public class InsertM {

	public static int insertM(int n,int m, int i,int j){
		/*
		 * 将N的2进制表示中，第i~第j位清0
		 */
		int mask = ~0;
//		0~j位清0
		mask = (mask << (j+1));
//		0~i位置1
		mask = mask | ((1<<i)-1);
		n = n & mask;
		/*
		 * 将M移到第i位
		 */
		m = m<<i;
		/*
		 * N和M合并
		 */
		return n|m;
	}
	public static void main(String[] args) {
		int n = 4355;
		int m = 4;
		
		int i=2;
		int j=7;
		System.out.print(insertM(n, m, i, j));
	}

}
