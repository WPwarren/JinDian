package JinDian;

public class BinInsert {
	
	public static int binInsert(int n, int m, int j, int i) {
	       //对m的第i~j位清0
	        int mask = ~0;
	        mask = mask << (j+1);
	        mask = mask | ((1<< i) -1);
	        
	        n = n & mask;
	        m = m<<i;
	        return m|n;
	}
	 
	public static void main(String[] args) {
		int n = 4355;
		int m = 4;
		
		int i=2;
		int j=7;
		
		System.out.print(binInsert(n, m, j, i));

	}

}
