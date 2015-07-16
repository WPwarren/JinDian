package JinDian;
/**
 * 空格替换
 * @author wangpeng
 * 对于字符串的问题一般是从字符串尾部开始反向操作字符串
 * 遍历两次字符串
 * 一、第一次遍历计算空格的个数
 * 二、得到变换后的长度
 * 三、反向操作字符串，替换空格
 */
public class ReplaceSpace {
	
	public static String replaceSpace(String iniString,int length){
		char[] strArr = iniString.toCharArray();
		int count = 0;
		for(int i=0;i<strArr.length;i++){
			if(strArr[i] == ' ')
				count++;
		}
		String replace = "%20";
		int finalLength = length + count*(replace.length()-" ".length());
		char[] result = new char[finalLength];
		int finalIndex = finalLength-1;
		int oldIndex = length-1;
		while(finalIndex >= 0 && oldIndex >= 0){
			if(strArr[oldIndex] != ' '){
				result[finalIndex--] = strArr[oldIndex--];
			}else{
				result[finalIndex--] = '0';
				result[finalIndex--] = '2';
				result[finalIndex--] = '%';
				oldIndex--;
			}
		}
		
		return new String(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello  wrold";
		System.out.print(replaceSpace(str, str.length()));
	}

}
