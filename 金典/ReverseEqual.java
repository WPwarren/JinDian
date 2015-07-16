package JinDian;

public class ReverseEqual {

	public static boolean checkReverseEqual(String s1,String s2){
		String s = s1 + s1;
		return s.contains(s2);
	}
	public static void main(String[] args) {
		String s1 = "waiterbottle";
		String s2 = "eurbottlewat";
		System.out.print(checkReverseEqual(s1,s2));
	}

}
