package JinDian;

public class Clearer {

	public int[][] clearZero(int[][] mat,int n){
		if(mat == null )
			return null;
		int[][] copy = new int[n][n];
		init(copy);
		for(int i= 0;i<n;i++){
			for(int j=0;j<n;j++){
				if(mat[i][j] == 0){
					clear(copy,i,j);
				}else{
					if(copy[i][j] == -1)
						copy[i][j] = mat[i][j];
				}
			}
		}
		return copy;
	}
	private void init(int[][] copy) {
		int n = copy.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				copy[i][j] = -1;
			}
		}
	}
	private void clear(int[][] copy, int row, int col) {
		int n = copy.length;
		for(int i=0;i<n;i++){
			copy[row][i] = 0;
		}
		for(int i=0;i<n;i++){
			copy[i][col] = 0;
		}
	}
	
	
	
	/**
	 * 金典中的算法
	 * @param args
	 * 两次遍历数组，第一次记录0所在的位置
	 * 第二次遍历数组，将0所在的行或列值为0
	 */
	public int[][] clearZero2(int[][] mat,int n){
		if(mat == null)
			return null;
		
		int rows = mat.length;
		int cols = mat[0].length;
		int row = 0;
		int col = 0;
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(mat[i][j] == 0){
					row |= 1<<i;
					col |= 1<<j;
				}
			}
		}
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if((((1<<i)&row) != 0) || (((1<<j)&col) != 0)){
					mat[i][j] = 0;
				}
			}
		}
		
		return mat;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clearer cl = new Clearer();
		int[][] mat = {{1,2,3},{0,1,2},{0,0,1}};
		mat = cl.clearZero2(mat, mat.length);
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat.length;j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
