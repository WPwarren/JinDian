package JinDian;

public class Reverse {

	/*
	 * 有额外的存储空间
	 */
	public static String reverseString(String iniString){
		char[] strAtt = iniString.toCharArray();
		int begin = 0;
		int end = iniString.length()-1;
		while(begin < end){
			char temp = strAtt[begin];
			strAtt[begin] = strAtt[end];
			strAtt[end] = temp;
			begin++;
			end--;
		}
		return new String(strAtt);
	}
	/**
	 * 不使用额外的存储空间
	 * @param args
	 */
	public static String reverseString2(String iniString){
		int begin = 0;
		int end = iniString.length()-1;
		StringBuffer sb = new StringBuffer(iniString);
		while(begin < end){
			char temp = sb.charAt(begin);
			sb.setCharAt(begin, sb.charAt(end));
			sb.setCharAt(end, temp);
			begin++;
			end--;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is nowcoder";
		System.out.print(reverseString2(s));
	}

}
