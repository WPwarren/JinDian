package JinDian;

/**
 * 像素反转
 * @author wangpeng
 * 采用剥洋葱圈的方法
 * 
 */
public class Transform {

	public static int[][] transformImage(int[][] mat,int n){
		for(int layer=0;layer<n/2;layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++){
				int offset = i-first;
//				保存上边
				int top = mat[layer][i];
//				左边移到上边
				mat[first][i] = mat[last-offset][first];
//				下边移到左边
				mat[last-offset][first] = mat[last][last-offset];
//				右边移到下边
				mat[last][last-offset] = mat[i][last];
//				上边移到右边
				mat[i][last] = top;
			}
		}
		
		return mat;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int n = 3;
		transformImage(mat, 3);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		
	}

}
