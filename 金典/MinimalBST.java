package JinDian;

public class MinimalBST {

	public static int buildMinimalBST(int[] vals){
		if(vals == null || vals.length==0)
			return -1;
		return deepOfBST(vals,0,vals.length-1);
	}
	private static int deepOfBST(int[] vals, int start, int end) {
		if(start>=end){
			return 1;
		}
		
		int mid = (start + end)/2;
		int left = deepOfBST(vals,start,mid-1);
		int right = deepOfBST(vals,mid+1,end);
		
		return Math.max(left, right)+1;
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,7,8,9};
		System.out.print(buildMinimalBST(num));
	}

}
