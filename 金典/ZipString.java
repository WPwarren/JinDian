package JinDian;

import org.junit.Test;

/**
 * 基本字符串压缩
 * @author wangpeng
 * 
 */
public class ZipString {

	public String zipString(String iniString){
		if(iniString == null || iniString.length() == 0){
			return null;
		}
		/*
		 * 检测字符串是否被压缩
		 */
		int zipsize = countCompress(iniString);
		if(zipsize >= iniString.length())
			return iniString;
		/*
		 * 压缩字符串
		 */
		StringBuffer sbuf = new StringBuffer();
		char last = iniString.charAt(0);
		int count = 1;
		for(int i=1;i<iniString.length();i++){
			if(last == iniString.charAt(i)){
				count++;
			}else{
				sbuf.append(last);
				sbuf.append(count);
				last = iniString.charAt(i);
				count = 1;
			}
		}
		sbuf.append(last);
		sbuf.append(count);
		
		return sbuf.toString();
	}
	private int countCompress(String iniString) {
		int size = 0;
		char last = iniString.charAt(0);
		int count = 1;
		
		for(int i=1;i<iniString.length();i++){
			if(last == iniString.charAt(i)){
				count++;
			}else{
				size += 1+String.valueOf(count).length();
				last = iniString.charAt(i);
				count= 1;
			}
		}
		size +=1+String.valueOf(count).length();
		
		return size;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabcccccaaa";
		ZipString zip = new ZipString();
		System.out.print(zip.zipString(s));
	}

	@Test
	public void fun1(){
		System.out.print(String.valueOf(8).length());
	}
}
